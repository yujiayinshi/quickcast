package com.paragon.quickcast.controller;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paragon.quickcast.entity.User_Reg;
import com.paragon.quickcast.service.UserService;

@Controller
@RequestMapping(value = "/user_reg.do")
public class UserRegController{

	@Resource
	private UserService userService;
	private Encoding encod = new Encoding();
    
	
	//检测用户名是否存在
	@RequestMapping(params = "method=check_uname" )
    public @ResponseBody  String check_uname(@RequestBody User_Reg user_name) {
	   			
    	 return userService.check_username(user_name.getUser_name());
    	 	
    }
	
	
	
	@RequestMapping(params="method=reg")
	public @ResponseBody String reg(@RequestBody User_Reg user_reg){
		return userService.insert(user_reg);
		}
	
	
	@RequestMapping(params="method=check_email")
	public @ResponseBody String check_email(@RequestBody User_Reg email){
		
		String result = userService.check_email(email.getEmail());
		return result;
	}
	
	
	

	@RequestMapping(params="method=login")
	public @ResponseBody String login(@RequestBody User_Reg user){
		String temp = userService.login(user.getUser_name(),user.getPassword());
       
		return temp;
	}
	
	@RequestMapping(params="method=imp_userreg_queryByUserId")
	public @ResponseBody String imp_userreg_queryByUserId(@RequestBody User_Reg userreg){
		User_Reg userregInstance = userService.queryByUserId(userreg.getUser_id());
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		data.put("user_id", userregInstance.getUser_id());
		data.put("user_name", userregInstance.getUser_name());
		data.put("eng_name", userregInstance.getEng_name());
		data.put("cn_tname", userregInstance.getCn_tname());
		data.put("email", userregInstance.getEmail());
		data.put("user_type", userregInstance.getUser_type());
		json_result.put(data);
		String result = "{\"user\":"+ json_result +"}";
		String result_temp = "error";
		try {
			result_temp = URLEncoder.encode(result, "utf-8");
			result_temp = URLEncoder.encode(result, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
									
		return result_temp;
	}
	
	
	
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}