package com.paragon.quickcast.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paragon.quickcast.entity.Etp_Info;
import com.paragon.quickcast.entity.Hunter_Info;
import com.paragon.quickcast.entity.Recruit_Info;
import com.paragon.quickcast.entity.Seeker_Info;
import com.paragon.quickcast.entity.User_Reg;
import com.paragon.quickcast.service.RecruitService;
import com.paragon.quickcast.service.UserService;
import com.paragon.quickcast.serviceImpl.EtpinfoServiceImpl;
import com.paragon.quickcast.serviceImpl.HunterinfoServiceImpl;
import com.paragon.quickcast.serviceImpl.SeekerinfoServiceImpl;

@Controller
@RequestMapping("/search.do")
public class SearchController {
	
	@Resource
    private RecruitService recruitservice;
	@Resource
	private UserService userservice;
	@Resource
	private SeekerinfoServiceImpl seekerImpl;
	@Resource
	private HunterinfoServiceImpl hunterImpl;
	@Resource 
	private EtpinfoServiceImpl etpImpl;
	@Resource 
	private Encoding encoding;
	
	
	@RequestMapping(params="method=search_queryRecruit")
	public @ResponseBody String search_queryRecruit(){
		
		List l = recruitservice.queryAll();
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
	    	data.put("recruit_industry", info.getRecruit_industry());
	    	data.put("work_place", info.getWork_place());
		    data.put("etp_name", info.getEtp_name());
	    	json_result.put(data);
		}
		String result = "{\"recruit_info\":"+ json_result +"}";
		String result_temp = "error";
		result_temp = encoding.encoding(result);						
		return result_temp;	
	}
	
	@RequestMapping(params="method=search_querySeeker")
	public @ResponseBody String search_querySeeker(){
		List l = userservice.queryByUserType("1");
		Iterator iter = l.iterator();
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		for(int i=0;i<l.size();i++){
			User_Reg userregInstance = (User_Reg)iter.next();			
			data.put("user_id", userregInstance.getUser_id());
			data.put("user_name", userregInstance.getUser_name());
			data.put("eng_name", userregInstance.getEng_name());
			data.put("cn_tname", userregInstance.getCn_tname());
			data.put("email", userregInstance.getEmail());
			data.put("password", userregInstance.getPassword());
			data.put("user_type", userregInstance.getUser_type());
			Seeker_Info seeker_infoInstance = seekerImpl.queryBySeekerUserId(userregInstance.getUser_id());
	    	data.put("seekerinfo_id", seeker_infoInstance.getInfo_id());
	    	data.put("user_id", seeker_infoInstance.getUser_id());
	    	data.put("age", seeker_infoInstance.getAge());
	    	data.put("edu_type", seeker_infoInstance.getEdu_type());
	    	data.put("end_time", seeker_infoInstance.getEnd_time());
	    	data.put("etp_industry", seeker_infoInstance.getEtp_industry());
	    	data.put("etp_name", seeker_infoInstance.getEtp_name());
	    	data.put("gender", seeker_infoInstance.getGender());
	    	data.put("highest_edu", seeker_infoInstance.getHighest_edu());
	    	data.put("job_status", seeker_infoInstance.getJob_status());
	    	data.put("marital_status", seeker_infoInstance.getMarital_status());
	    	data.put("mobile", seeker_infoInstance.getMobile());
	    	data.put("seeker_photo", seeker_infoInstance.getSeeker_photo());
	    	data.put("seeker_profession", seeker_infoInstance.getSeeker_profession());
	    	data.put("self_intro", seeker_infoInstance.getSelf_intro());
	    	data.put("start_time", seeker_infoInstance.getStart_time());
	    	data.put("tech_direction", seeker_infoInstance.getTech_direction());
	    	data.put("work_place", seeker_infoInstance.getWork_place());
	    	json_result.put(data);
		}
		String result = "{\"seeker\":"+ json_result +"}";
		String result_temp = "error";
		result_temp = encoding.encoding(result);						
		return result_temp;	
	}
	
	
	
	@RequestMapping(params="method=search_queryHunter")
	public @ResponseBody String search_queryHunter(){
		List l = userservice.queryByUserType("2");
		Iterator iter = l.iterator();
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		for(int i=0;i<l.size();i++){
			User_Reg userregInstance = (User_Reg)iter.next();			
			data.put("user_id", userregInstance.getUser_id());
			data.put("user_name", userregInstance.getUser_name());
			data.put("eng_name", userregInstance.getEng_name());
			data.put("cn_tname", userregInstance.getCn_tname());
			data.put("email", userregInstance.getEmail());
			data.put("password", userregInstance.getPassword());
			data.put("user_type", userregInstance.getUser_type());
			Hunter_Info info = hunterImpl.queryByHunterUserId(userregInstance.getUser_id());
			data.put("info_id", info.getInfo_id());
			data.put("business_card", info.getBusiness_card());
			data.put("certificate", info.getCertificate());
			data.put("check_status", info.getCheck_status());
			data.put("etp_intro", info.getEtp_intro());
			data.put("etp_name", info.getEtp_name());
			data.put("gender", info.getGender());
			data.put("hunter_fax", info.getHunter_fax());
			data.put("mobile", info.getMobile());
			data.put("msg_addr", info.getMsg_addr());
			data.put("partner", info.getPartner());
			data.put("self_intro", info.getSelf_intro());
			data.put("t_area", info.getT_area());
			data.put("work_city", info.getWork_place());
			data.put("work_email", info.getWork_email());
			data.put("work_phone", info.getWork_phone());
			data.put("work_time", info.getWork_time());
	    	json_result.put(data);
		}
		String result = "{\"hunter\":"+ json_result +"}";
		String result_temp = "error";
		result_temp = encoding.encoding(result);						
		return result_temp;	
	}
	
	@RequestMapping(params="method=search_queryEtp")
	public @ResponseBody String search_queryEtp(){
		List l = userservice.queryByUserType("3");
		Iterator iter = l.iterator();
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		for(int i=0;i<l.size();i++){
			User_Reg userregInstance = (User_Reg)iter.next();			
			data.put("user_id", userregInstance.getUser_id());
			data.put("user_name", userregInstance.getUser_name());
			data.put("eng_name", userregInstance.getEng_name());
			data.put("cn_tname", userregInstance.getCn_tname());
			data.put("email", userregInstance.getEmail());
			data.put("password", userregInstance.getPassword());
			data.put("user_type", userregInstance.getUser_type());
			Etp_Info info = etpImpl.queryByEtpUserId(userregInstance.getUser_id());
			data.put("info_id", info.getInfo_id());
			data.put("certificate", info.getCertificate());
			data.put("check_status", info.getCheck_status());
			data.put("etp_intro", info.getEtp_intro());
			data.put("etp_name", info.getEtp_name());
			data.put("msg_addr", info.getMsg_addr());
			data.put("etp_addr", info.getEtp_addr());
			data.put("etp_email", info.getEtp_email());
			data.put("contact_person", info.getContact_person());
			data.put("etp_industry", info.getEtp_industry());
			data.put("etp_nature", info.getEtp_nature());
			data.put("mobile", info.getMobile());
			data.put("etp_size", info.getEtp_size());
	    	json_result.put(data);
		}
		String result = "{\"etp\":"+ json_result +"}";
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
	

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	

	public SeekerinfoServiceImpl getSeekerImpl() {
		return seekerImpl;
	}

	public void setSeekerImpl(SeekerinfoServiceImpl seekerImpl) {
		this.seekerImpl = seekerImpl;
	}

	public HunterinfoServiceImpl getHunterImpl() {
		return hunterImpl;
	}

	public void setHunterImpl(HunterinfoServiceImpl hunterImpl) {
		this.hunterImpl = hunterImpl;
	}

	public EtpinfoServiceImpl getEtpImpl() {
		return etpImpl;
	}

	public void setEtpImpl(EtpinfoServiceImpl etpImpl) {
		this.etpImpl = etpImpl;
	}

	public Encoding getEncoding() {
		return encoding;
	}

	public void setEncoding(Encoding encoding) {
		this.encoding = encoding;
	}

}
