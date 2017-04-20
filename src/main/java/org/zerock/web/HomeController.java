package org.zerock.web;


import java.sql.Connection;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.service.Hello;




/**
 * Handles requests for the application home page.
 */
@Controller   //스프링에 빈으로 주입하기 위해서  @ 
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource(name="korean")
	private Hello service;
	
	@Autowired
	private DataSource ds; 
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)  
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		String greeting = service.sayHello(); 
		
		try {			
			Connection con = ds.getConnection();
			System.out.println("====================");
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		model.addAttribute("serverTime", formattedDate+":"+greeting );
		
		return "home";
	}
	
}
