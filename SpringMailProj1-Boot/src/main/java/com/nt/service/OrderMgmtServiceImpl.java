package com.nt.service;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("service")
public class OrderMgmtServiceImpl implements OrderMgmtService {

	@Autowired
	private JavaMailSender sender;
	
	@Override
	public String purchase(String[] items, float[] prices, String custMail,String[] cc,String[] bcc) {
		
		float bAmt=0.0f;
		for(float f : prices)
			bAmt += f;
		
		String body=Arrays.toString(items)+" having respective prices are "+Arrays.toString(prices)+" ,totat price are "+bAmt+" with order id "+new Random().nextInt(1000);
		boolean status= triggerMail(body,custMail,cc,bcc);
		
		return body+" Mail Deliverd "+ status;
	}

	private boolean triggerMail(String body, String custMail, String[] cc, String[] bcc) {
		boolean status = false;
		try {
			MimeMessage msg = sender.createMimeMessage();
			
			MimeMessageHelper helper=new MimeMessageHelper(msg,true); 
			
			helper.setSubject("Open it to know");
			
			helper.setTo(custMail);
			
			helper.setCc(cc);
			
			helper.setBcc(bcc);
			
			helper.setSentDate(new Date());
			
			helper.setText(body);
			
			helper.addAttachment("search.jpg", new ClassPathResource("search.jpg"));
			
			sender.send(msg);
			
			status =true;
		}catch(Exception e) {
			status = false;
			e.printStackTrace();	
		}
		
		
		return status;
	}

}
