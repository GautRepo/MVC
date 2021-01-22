package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.OrderMgmtService;
import com.nt.service.OrderMgmtServiceImpl;

@SpringBootApplication
public class SpringMailProj1BootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(SpringMailProj1BootApplication.class, args);
	
	OrderMgmtService service =ctx.getBean("service", OrderMgmtServiceImpl.class);
	
	try {
		String result =service.purchase(new String[] {"Chaat,Samosa,Bhelpuri,Litti"},
				new float[] {50.0f,8.0f,30.0f,20.0f},"ronit.blr541@gmail.com",
				new String[] {"gauti408@gmail.com"},
				new String[] {"tolktogautam@gmail.com"});
		
		System.out.println(result);
	}catch(Exception e) {
		e.printStackTrace();
	}
	((ConfigurableApplicationContext) ctx).close();
	
	}

}
