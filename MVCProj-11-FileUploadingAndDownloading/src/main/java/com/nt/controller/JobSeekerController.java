package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.JobSeekerInfo;
import com.nt.service.FileDownloadService;

@Controller
public class JobSeekerController {
	
	@Autowired
	private ServletContext sc;
	
	@Autowired
	private FileDownloadService service;

	@GetMapping("/upload")
	public String getReg(@ModelAttribute("info") JobSeekerInfo jbInfo) {
		return "seeker_register";
	}
	
	@PostMapping("/upload")
	public String uploadFiles(Map<String,Object> map,@ModelAttribute("info") JobSeekerInfo jbInfo)throws Exception {
		
		String folderLocation =sc.getInitParameter("uploadStore");
		
		File file = new File(folderLocation);
		
		if(!file.exists()) {
			file.mkdir();
		}
		
		String resumeFileName=jbInfo.getResume().getOriginalFilename();
		String photoFileName=jbInfo.getPhoto().getOriginalFilename();
		
		InputStream resumeIs=jbInfo.getResume().getInputStream();
		InputStream photoIs=jbInfo.getPhoto().getInputStream();
		
		OutputStream resumeOs=new FileOutputStream(folderLocation+"/"+resumeFileName);
		OutputStream photoOs=new FileOutputStream(folderLocation+"/"+photoFileName);
		
		IOUtils.copy(photoIs, photoOs);
		IOUtils.copy(resumeIs, resumeOs);
		
		photoOs.close();
		resumeOs.close();
		photoIs.close();
		resumeIs.close();

		map.put("resumeFileName", resumeFileName);
		map.put("photoFileName", photoFileName);
		
		return "success_page";
	}
	
	@GetMapping("/list_files")
	public String getFileList(Map<String,Object> map) {
		
		String folderLocation =sc.getInitParameter("uploadStore");
		List<String> fileList= service.fetchAllFile(folderLocation);
		map.put("fileList", fileList);
		
		return "show_files";
		
	}
	
	@GetMapping("/download")
	public String downloadFile(@RequestParam("fname")String fileName
								,HttpServletResponse res)throws Exception {
		
		String filePath=sc.getInitParameter("uploadStore")+"/"+fileName;
		
		File file = new File(filePath);
		
		res.setContentLengthLong(file.length());
		
		String mimeType=sc.getMimeType(filePath);
		
		res.setContentType(mimeType==null?"application/octet-stream":mimeType);
												
		InputStream is = new FileInputStream(filePath);
		
		OutputStream os= res.getOutputStream();
		
		res.addHeader("Content-Disposition","attachment;fileName"+fileName);
		
		IOUtils.copy(is, os);
		
		return null;
	}
	
}
