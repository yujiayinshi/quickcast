package com.paragon.quickcast.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paragon.quickcast.dao.ToJson;
import com.paragon.quickcast.entity.News;
import com.paragon.quickcast.entity.Recruit_Info;
import com.paragon.quickcast.entity.User_Reg;
import com.paragon.quickcast.service.NewsService;
import com.paragon.quickcast.service.RecruitService;
import com.paragon.quickcast.service.UserService;

@Controller
@RequestMapping("/recruitinfo.do")
public class Recruit_InfoController {

	@Resource
    private RecruitService recruitservice;
	@Resource
	private NewsService newsservice;
	@Resource
	private UserService userservice;
	@Resource 
	private Encoding encoding;
	
	@RequestMapping(params="method=recruitinfo_insert")
	public @ResponseBody String recruitinfo_insert(@RequestBody Recruit_Info recruit_info){
		
		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			recruitservice.insert(recruit_info);
			News news = new News();
			news.setContent(recruit_info.getRecruit_job());
			news.setPub_id(recruit_info.getUser_id());
			news.setPub_time(recruit_info.getIssue_time());
			news.setPub_type("2");
			news.setInfo_id(recruit_info.getInfo_id());
			news.setEtp_name(recruit_info.getEtp_name());
			news.setWork_place(recruit_info.getWork_place());
			newsservice.insert(news);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			temp = "fail";
			String result_temp = tojosn.tojson(temp);
			result_temp = encoding.encoding(result_temp);			
			e.printStackTrace();			
			e.printStackTrace();
			return result_temp;
		}
		String result_temp = tojosn.tojson(temp);
		result_temp = encoding.encoding(result_temp);							
		return result_temp;	
	}
	
	@RequestMapping(params="method=recruitinfo_delete")
	public @ResponseBody String recruitinfo_delete(@RequestBody Recruit_Info recruit_info){
		
		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			recruitservice.delete(recruit_info.getInfo_id());
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			temp = "fail";
			String result_temp = tojosn.tojson(temp);
			result_temp = encoding.encoding(result_temp);			
			e.printStackTrace();			
			e.printStackTrace();
			return result_temp;
		}
		String result_temp = tojosn.tojson(temp);
		result_temp = encoding.encoding(result_temp);							
		return result_temp;	
	}
	
	@RequestMapping(params="method=recruitinfo_update")
	public @ResponseBody String recruitinfo_update(@RequestBody Recruit_Info recruit_info){
		
		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			recruitservice.update(recruit_info);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			temp = "fail";
			String result_temp = tojosn.tojson(temp);
			result_temp = encoding.encoding(result_temp);			
			e.printStackTrace();			
			e.printStackTrace();
			return result_temp;
		}
		String result_temp = tojosn.tojson(temp);
		result_temp = encoding.encoding(result_temp);							
		return result_temp;	
	}
	
	
	@RequestMapping(params="method=recruitinfo_queryByInfoId")
	public @ResponseBody String recruitinfo_queryByInfoId(@RequestBody Recruit_Info recruit_info){
		
		Recruit_Info info = recruitservice.queryByInfoId(recruit_info.getInfo_id());
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();		
	    data.put("info_id", info.getInfo_id());
	    data.put("issue_time", info.getIssue_time());
	    data.put("recruit_detail", info.getRecruit_detail());
	    data.put("recruit_job", info.getRecruit_job());
	    data.put("recruit_time", info.getRecruit_time());
	    data.put("salary", info.getSalary());
	    data.put("recruit_num", info.getRecruit_num());
	    data.put("user_id", info.getUser_id());
	    User_Reg user = userservice.queryByUserId(info.getUser_id());
	    data.put("user_type", user.getUser_type());
	    data.put("recruit_industry", info.getRecruit_industry());
	    data.put("work_place", info.getWork_place());
	    data.put("etp_name", info.getEtp_name());
	    json_result.put(data);
		String result = "{\"recruit_info\":"+ json_result +"}";
		String result_temp = "error";
		result_temp = encoding.encoding(result);						
		return result_temp;	
	}
	
	
	@RequestMapping(params="method=recruitinfo_queryByUserId")
	public @ResponseBody String recruitinfo_queryByUserId(@RequestBody Recruit_Info recruit_info){
		
		List l = recruitservice.queryByUserId(recruit_info.getUser_id());
		Iterator iter = l.iterator();
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		for(int i=0;i<l.size();i++){
			Recruit_Info info = (Recruit_Info)iter.next();			
	    	data.put("info_id", info.getInfo_id());
	    	data.put("issue_time", info.getIssue_time());
	    	data.put("recruit_detail", info.getRecruit_detail());
	    	data.put("recruit_job", info.getRecruit_job());
	    	data.put("recruit_time", info.getRecruit_time());
	    	data.put("salary", info.getSalary());
	    	data.put("recruit_num", info.getRecruit_num());
	    	data.put("user_id", info.getUser_id());
	    	User_Reg user = userservice.queryByUserId(info.getUser_id());
		    data.put("user_type", user.getUser_type());
	    	data.put("recruit_industry", info.getRecruit_industry());
	    	data.put("work_place", info.getRecruit_industry());
		    data.put("etp_name", info.getEtp_name());
	    	json_result.put(data);
		}
		String result = "{\"recruit_info\":"+ json_result +"}";
		String result_temp = "error";
		result_temp = encoding.encoding(result);						
		return result_temp;	
	}



	public RecruitService getRecruitservice() {
		return recruitservice;
	}

	public void setRecruitservice(RecruitService recruitservice) {
		this.recruitservice = recruitservice;
	}
	
	

	public NewsService getNewsservice() {
		return newsservice;
	}

	public void setNewsservice(NewsService newsservice) {
		this.newsservice = newsservice;
	}
	
	

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	public Encoding getEncoding() {
		return encoding;
	}

	public void setEncoding(Encoding encoding) {
		this.encoding = encoding;
	}
	
	
}
