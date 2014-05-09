package com.paragon.quickcast.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paragon.quickcast.dao.ToJson;
import com.paragon.quickcast.entity.Personal_Rsm;
import com.paragon.quickcast.service.ResumeService;


//个人简历
@Controller
@RequestMapping("/personal_rsm.do")
public class Personal_RsmController {
	
	@Resource
	private ResumeService resumeservice;
	@Resource
	private Encoding encoding;
	

	@RequestMapping(params="method=imp_resume_insert")	
	public @ResponseBody String imp_resume_insert(@RequestBody Personal_Rsm personal_rsm){
		//通过实体类来封装jsp页面
		
		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			resumeservice.insert(personal_rsm);
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
	
	@RequestMapping(params="method=imp_resume_update")
	public @ResponseBody String imp_resume_update(@RequestBody Personal_Rsm personal_rsm){

		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			resumeservice.update(personal_rsm);
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
	
	
	@RequestMapping(params="method=imp_resume_queryByUserId")
	public @ResponseBody String imp_resume_queryByUserId(@RequestBody Personal_Rsm personal_rsm){
		
		Personal_Rsm rsm = resumeservice.queryByUserId(personal_rsm.getUser_id());
		System.out.println("简历编号：--------"+rsm.getRsm_id());
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		data.put("rsm_id", rsm.getRsm_id());
		data.put("user_id", rsm.getUser_id());
		data.put("edit_time", rsm.getEdit_time());
		data.put("expect_industry", rsm.getExpect_industry());
		data.put("expect_job", rsm.getExpect_job());
		data.put("expect_place", rsm.getExpect_place());
		data.put("expect_salary", rsm.getExpect_salary());
		data.put("language_skill", rsm.getLanguage_skill());
		data.put("month_salary", rsm.getMonth_salary());
		data.put("read_status", rsm.getRead_status());
		data.put("self_evaluate", rsm.getSelf_evaluate());
		data.put("work_month", rsm.getWork_month());
		data.put("add_info", rsm.getAdd_info());
		json_result.put(data);
		
		String result = "{\"resume\":"+ json_result + "}";
		String result_temp = "error";
		result_temp = encoding.encoding(result);						
		return result_temp;	
		
	}
	

	@RequestMapping(params="method=imp_resume_queryByRsmId")
	public @ResponseBody String imp_resume_queryByRsmId(Personal_Rsm personal_rsm){
		
		Personal_Rsm rsm = resumeservice.queryByRsmId(personal_rsm.getRsm_id());	
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		data.put("rsm_id", rsm.getRsm_id());
		data.put("user_id", rsm.getUser_id());
		data.put("edit_time", rsm.getEdit_time());
		data.put("expect_industry", rsm.getExpect_industry());
		data.put("expect_job", rsm.getExpect_job());
		data.put("expect_place", rsm.getExpect_place());
		data.put("expect_salary", rsm.getExpect_salary());
		data.put("language_skill", rsm.getLanguage_skill());
		data.put("month_salary", rsm.getMonth_salary());
		data.put("read_status", rsm.getRead_status());
		data.put("self_evaluate", rsm.getSelf_evaluate());
		data.put("work_month", rsm.getWork_month());
		data.put("add_info", rsm.getAdd_info());
		json_result.put(data);
		
		String result = "{\"resume\":"+ json_result + "}";
		String result_temp = "error";
		result_temp = encoding.encoding(result);						
		return result_temp;	
		
	}
	
	
	@RequestMapping(params="method=imp_resume_delete")
	public String imp_resume_delete(Personal_Rsm personal_rsm){
		
		resumeservice.delete(personal_rsm);
		return "index";
		
	}
	
	@RequestMapping(params="method=imp_resume_deleteByUserId")
	public String imp_resume_deleteUserId(int user_id){
		
		resumeservice.deleteByUserId(user_id);
		return "index";
		
	}
	
	
	@RequestMapping(params="method=imp_resume_deleteByRsmId")
	public @ResponseBody String imp_resume_deleteRsmId(Personal_Rsm personal_rsm){
		
		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			resumeservice.deleteByRsmId(personal_rsm.getRsm_id());
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
	
	
	public ResumeService getResumeservice() {
		return resumeservice;
	}

	public void setResumeservice(ResumeService resumeservice) {
		this.resumeservice = resumeservice;
	}
	
	public Encoding getEncoding() {
		return encoding;
	}

	public void setEncoding(Encoding encoding) {
		this.encoding = encoding;
	}

}
