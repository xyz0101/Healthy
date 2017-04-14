package com.Healthy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Jump {
		@RequestMapping("/tosport")
		public String tosport(){
			return "sport";
		}
		
		
}	
