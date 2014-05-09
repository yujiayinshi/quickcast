package com.paragon.quickcast.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.paragon.quickcast.service.UserService;


@Controller
@RequestMapping(value = "/upload.do") 
public class UploadController {
	@Resource
	private UserService userservice;
	
	 @RequestMapping(params = "method=image")  
	public  String upload(@RequestParam(value = "file",required = false) MultipartFile file,HttpServletRequest request,ModelMap model,String upload_token){
		 
	        String path = request.getSession().getServletContext().getRealPath("upload");
	        String fileName = upload_token+".jpg";
	        System.out.println("¿ªÊ¼"+fileName); 
	        System.out.println(path);  
	        File targetFile = new File(path, fileName);  
//	        if(!targetFile.exists()){  
//	            targetFile.mkdirs();  
//	        }  
	  
	        //±£´æ  
	        try {  
	            file.transferTo(targetFile);  
	//            model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);
	        } catch (Exception e) {  
	        	    
	        } 
	      
	        return fileName;                   
	    }

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	 
}
	 
	  


