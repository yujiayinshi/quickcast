package com.paragon.quickcast.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Component
public class Checker {
	  public boolean isEmail(String email){  
	         if (null==email || "".equals(email)) return false;    
//	       Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}"); //��ƥ��  
	         Pattern p =  Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");//����ƥ��  
	         Matcher m = p.matcher(email);  
	         return m.matches();  
	        }  

}
