package com.paragon.quickcast.controller;

import java.net.*;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class Encoding {

	  public String encoding(String request){
		  String result = "fail";
		 
		  try {
				result = URLEncoder.encode(request, "utf-8");
				result = URLEncoder.encode(result, "utf-8");
		
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		  
		  
		  return result;
	  }
}
