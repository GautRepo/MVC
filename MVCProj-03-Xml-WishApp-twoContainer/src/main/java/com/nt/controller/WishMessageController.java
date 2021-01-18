package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.service.WishMsgService;

public class WishMessageController extends AbstractController{
	
	private WishMsgService service;
	
	public WishMessageController(WishMsgService service) {
		
		this.service = service;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String msg = service.wishMsgService();
		
		return new ModelAndView("wish","wmsg",msg);
	}

}
