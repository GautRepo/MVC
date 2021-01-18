package com.nt.service;

import java.util.Calendar;

public class WishMessageServiceImpl implements WishMsgService {

	@Override
	public String wishMsgService() {
		
		var hour=0;
		var calender =Calendar.getInstance();
		//get current hour of the day 
		hour = calender.get(Calendar.HOUR_OF_DAY);
		
		if(hour<12)
			return "Good Morning";
		else if(hour<16)
			return "Good After Noon";
		else if(hour<20)
			return "Good evening";
		else
			return "Good Night";
	}

}
