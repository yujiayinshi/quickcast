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
import com.paragon.quickcast.entity.Etp_Info;
import com.paragon.quickcast.entity.Recruit_Info;
import com.paragon.quickcast.entity.Rsm_Deliver;
import com.paragon.quickcast.entity.User_Reg;
import com.paragon.quickcast.service.DeliverService;
import com.paragon.quickcast.service.RecruitService;
import com.paragon.quickcast.service.UserService;
import com.paragon.quickcast.serviceImpl.EtpinfoServiceImpl;
import com.paragon.quickcast.serviceImpl.HunterinfoServiceImpl;

@Controller
@RequestMapping("/rsm_deliver.do")
public class Rsm_DeliverController {
	
	@Resource
    private RecruitService recruitservice;
	@Resource
	private DeliverService deliverservice;
	@Resource 
	private UserService userservice;
	@Resource 
	private HunterinfoServiceImpl hunterinfoImpl = new HunterinfoServiceImpl();
	@Resource
	private EtpinfoServiceImpl etpinfoImpl = new EtpinfoServiceImpl();
	@Resource
	private Encoding encoding;
	
	@RequestMapping(params="method=imp_deliver_insert")	
	public @ResponseBody String imp_deliver_insert(@RequestBody Rsm_Deliver rsm_deliver){
	
		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			rsm_deliver.setHandle_status("0");
			deliverservice.insert(rsm_deliver);
		} catch (RuntimeException e) {
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
	
	@RequestMapping(params="method=imp_deliver_update")	
	public @ResponseBody String imp_deliver_update(@RequestBody Rsm_Deliver rsm_deliver){
		
		deliverservice.update(rsm_deliver);
		return "index";
	}
	
	
	@RequestMapping(params="method=imp_deliver_queryByDeliverId")	
	public @ResponseBody String imp_deliver_queryByDeliverId(@RequestBody int deliver_id){
		
		Rsm_Deliver rsm_deliver = deliverservice.queryByDeliverId(deliver_id);		
		return "index";
	}
	
	@RequestMapping(params="method=imp_deliver_queryByRsmId")	
	public @ResponseBody String imp_deliver_queryByRsmId(@RequestBody int rsm_id){
		
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		List l = deliverservice.queryByRsmId(rsm_id);
		Iterator iter = l.iterator();
		while(iter.hasNext()){
			Rsm_Deliver deliver = (Rsm_Deliver)iter.next();
			data.put("deliver_id", deliver.getDeliver_id());
			data.put("etp_id", deliver.getEtp_id());
			if(deliver.getEtp_id()!=0){
			Etp_Info etp_info = etpinfoImpl.queryByEtpUserId(deliver.getEtp_id());
			data.put("etp_name", etp_info.getEtp_name());
			}else{
				data.put("etp_name",null);
			}
			data.put("rsm_id", deliver.getRsm_id());
			User_Reg user = userservice.queryByUserId(deliver.getRsm_id());
			data.put("rsm_name", user.getCn_tname());
			data.put("handle_status", deliver.getHandle_status());
			data.put("hunter_id", deliver.getHunter_id());
			if(deliver.getHunter_id()!=0){
			    User_Reg hunter = userservice.queryByUserId(deliver.getHunter_id());
			    data.put("hunter_name", hunter.getCn_tname());
			}else{
				data.put("hunter_name", null);
			}
			data.put("info_id", deliver.getInfo_id());
			if(deliver.getInfo_id()!=0){
			    Recruit_Info info = recruitservice.queryByInfoId(deliver.getInfo_id());
			    data.put("recruit_job", info.getRecruit_job());
			}else{
				data.put("recruit_job", null);
			}
			json_result.put(data);
		}
		String result = "{\"deliver\":"+ json_result +"}";
		String result_temp = encoding.encoding(result);		
		return result_temp;	
	}
	
	@RequestMapping(params="method=imp_deliver_queryByEtpId")	
	public @ResponseBody String imp_deliver_queryByEtpId(@RequestBody int etp_id){
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		List l = deliverservice.queryByEtpId(etp_id);
		Iterator iter = l.iterator();
		while(iter.hasNext()){
			Rsm_Deliver deliver = (Rsm_Deliver)iter.next();
			data.put("deliver_id", deliver.getDeliver_id());
			data.put("etp_id", deliver.getEtp_id());
			if(deliver.getEtp_id()!=0){
			Etp_Info etp_info = etpinfoImpl.queryByEtpUserId(deliver.getEtp_id());
			data.put("etp_name", etp_info.getEtp_name());
			}else{
				data.put("etp_name",null);
			}
			data.put("rsm_id", deliver.getRsm_id());
			User_Reg user = userservice.queryByUserId(deliver.getRsm_id());
			data.put("rsm_name", user.getCn_tname());
			data.put("handle_status", deliver.getHandle_status());
			data.put("hunter_id", deliver.getHunter_id());
			if(deliver.getHunter_id()!=0){
			User_Reg hunter = userservice.queryByUserId(deliver.getHunter_id());
			    data.put("hunter_name", hunter.getCn_tname());
			}else{
				data.put("hunter_name", null);
			}
			data.put("info_id", deliver.getInfo_id());
			if(deliver.getInfo_id()!=0){
			    Recruit_Info info = recruitservice.queryByInfoId(deliver.getInfo_id());
			    data.put("recruit_job", info.getRecruit_job());
			}else{
				data.put("recruit_job", null);
			}
			json_result.put(data);
		}
		String result = "{\"deliver\":"+ json_result +"}";
		String result_temp = encoding.encoding(result);		
		return result_temp;	
	}
	
	@RequestMapping(params="method=imp_deliver_queryByHunterId")	
	public @ResponseBody String imp_deliver_queryByHunterId(@RequestBody int hunter_id){
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		List l = deliverservice.queryByHunterId(hunter_id);
		Iterator iter = l.iterator();
		while(iter.hasNext()){
			Rsm_Deliver deliver = (Rsm_Deliver)iter.next();
			data.put("deliver_id", deliver.getDeliver_id());
			data.put("etp_id", deliver.getEtp_id());
			if(deliver.getEtp_id()!=0){
			Etp_Info etp_info = etpinfoImpl.queryByEtpUserId(deliver.getEtp_id());
			data.put("etp_name", etp_info.getEtp_name());
			}else{
				data.put("etp_name",null);
			}
			data.put("rsm_id", deliver.getRsm_id());
			User_Reg user = userservice.queryByUserId(deliver.getRsm_id());
			data.put("rsm_name", user.getCn_tname());
			data.put("handle_status", deliver.getHandle_status());
			data.put("hunter_id", deliver.getHunter_id());
			if(deliver.getHunter_id()!=0){
			    User_Reg hunter = userservice.queryByUserId(deliver.getHunter_id());
			    data.put("hunter_name", hunter.getCn_tname());
			}else{
				data.put("hunter_name", null);
			}
			data.put("info_id", deliver.getInfo_id());
			if(deliver.getInfo_id()!=0){
			    Recruit_Info info = recruitservice.queryByInfoId(deliver.getInfo_id());
			    data.put("recruit_job", info.getRecruit_job());
			}else{
				data.put("recruit_job", null);
			}
			json_result.put(data);
		}
		
		String result = "{\"deliver\":"+ json_result +"}";
		String result_temp = encoding.encoding(result);		
		return result_temp;	
	}
	
	
	@RequestMapping(params="method=imp_deliver_delete")
	public @ResponseBody String imp_deliver_delete(@RequestBody Rsm_Deliver rsm_deliver){
		
		deliverservice.delete(rsm_deliver);
		return "index";
		
	}
	
	@RequestMapping(params="method=imp_deliver_deleteByDeliverId")
	public String imp_deliver_deleteByDeliverId(int deliver_id){
		
		deliverservice.deleteByDeliverId(deliver_id);
		return "index";
		
	}
	
	@RequestMapping(params="method=imp_deliver_deleteByRsmId")
	public String imp_deliver_deleteByRsmId(int rsm_id){
		
		deliverservice.deleteByRsmId(rsm_id);
		return "index";
		
	}
	
	

	public RecruitService getRecruitservice() {
		return recruitservice;
	}

	public void setRecruitservice(RecruitService recruitservice) {
		this.recruitservice = recruitservice;
	}

	public DeliverService getDeliverservice() {
		return deliverservice;
	}

	public void setDeliverservice(DeliverService deliverservice) {
		this.deliverservice = deliverservice;
	}
	
	
	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	
	

	public HunterinfoServiceImpl getHunterinfoImpl() {
		return hunterinfoImpl;
	}

	public void setHunterinfoImpl(HunterinfoServiceImpl hunterinfoImpl) {
		this.hunterinfoImpl = hunterinfoImpl;
	}

	public EtpinfoServiceImpl getEtpinfoImpl() {
		return etpinfoImpl;
	}

	public void setEtpinfoImpl(EtpinfoServiceImpl etpinfoImpl) {
		this.etpinfoImpl = etpinfoImpl;
	}

	public Encoding getEncoding() {
		return encoding;
	}

	public void setEncoding(Encoding encoding) {
		this.encoding = encoding;
	}

}
