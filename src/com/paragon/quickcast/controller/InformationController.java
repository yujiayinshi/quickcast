package com.paragon.quickcast.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.paragon.quickcast.dao.ToJson;
import com.paragon.quickcast.entity.Etp_Info;
import com.paragon.quickcast.entity.Hunter_Info;
import com.paragon.quickcast.entity.Seeker_Info;
import com.paragon.quickcast.serviceImpl.EtpinfoServiceImpl;
import com.paragon.quickcast.serviceImpl.HunterinfoServiceImpl;
import com.paragon.quickcast.serviceImpl.SeekerinfoServiceImpl;

@Controller
@RequestMapping("/info.do")
public class InformationController extends MultiActionController{ 
	
	@Resource 
	private SeekerinfoServiceImpl seekerinfoImpl = new SeekerinfoServiceImpl();
	@Resource 
	private HunterinfoServiceImpl hunterinfoImpl = new HunterinfoServiceImpl();
	@Resource
	private EtpinfoServiceImpl etpinfoImpl = new EtpinfoServiceImpl();
	@Resource
    private Encoding encoding;
	
	
	
	//求职者 1 猎头 2 企业 3
	
	//Seeker_Info
	@RequestMapping(params="method=seekerinfo_insert")
	public @ResponseBody String seekerinfo_insert(@RequestBody Seeker_Info seeker_info){
		
		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			seekerinfoImpl.insert(seeker_info);
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
	
    @RequestMapping(params="method=seekerinfo_update")
    public @ResponseBody String seekerinfo_update(@RequestBody Seeker_Info seeker_info){
    	
    	String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			seekerinfoImpl.update(seeker_info);
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
    
    @RequestMapping(params="method=seekerinfo_delete")
    public @ResponseBody String seekerinfo_delete(@RequestBody Seeker_Info seeker_info){
    	seekerinfoImpl.delete(seeker_info);
    	return "seekerinfo_delete OK";
    }
    
    @RequestMapping(params="method=queryBySeekerInfoId")
    public @ResponseBody String queryBySeekerInfoId(@RequestBody Seeker_Info seeker_info){
    	Seeker_Info seeker_infoInstance = seekerinfoImpl.queryBySeekerInfoId(seeker_info.getInfo_id());
    	System.out.println("-----------seekerinfo_id:"+seeker_info.getInfo_id()+"---------");
		System.out.println("-----------user_id:"+seeker_info.getUser_id()+"---------");
    	
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
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
    	
    	String result = "{\"seeker_info\":"+ json_result +"}";
		String result_temp = "error";
		result_temp = encoding.encoding(result);						
		return result_temp;
    }
    
    @RequestMapping(params="method=queryBySeekerUserId")
    public @ResponseBody String queryBySeekerUserId(@RequestBody Seeker_Info seeker_info){
    	Seeker_Info seeker_infoInstance = seekerinfoImpl.queryBySeekerUserId(seeker_info.getUser_id());
    	Map data = new HashMap();
		JSONArray json_result = new JSONArray();
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
    	String result = "{\"seeker_info\":"+ json_result +"}";
    	String result_temp = "error";
		result_temp = encoding.encoding(result);							
		return result_temp;
    }
    
    @RequestMapping(params="method=deleteBySeekerInfoId")
	public @ResponseBody String deleteBySeekerInfoId(@RequestBody Seeker_Info seeker_info){
    
    	String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			seekerinfoImpl.deleteByInfoId(seeker_info.getInfo_id());
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
	
	@RequestMapping(params="method=deleteBySeekerUserId")
	public @ResponseBody String deleteBySeekerUserId(@RequestBody Seeker_Info seeker_info){
		
		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			seekerinfoImpl.deleteByUserId(seeker_info.getUser_id());
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

	
	
    //Hunter_Info
	@RequestMapping(params="method=hunterinfo_insert")
	public @ResponseBody String hunterinfo_insert(@RequestBody Hunter_Info hunter_info){
		
		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			hunterinfoImpl.insert(hunter_info);
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
	
    @RequestMapping(params="method=hunterinfo_update")
    public @ResponseBody String hunterinfo_update(@RequestBody Hunter_Info hunter_info){
    	
    	String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			hunterinfoImpl.update(hunter_info);
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
    
    @RequestMapping(params="method=hunterinfo_delete")
    public @ResponseBody String hunterinfo_delete(@RequestBody Hunter_Info hunter_info){
    	
    	String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			hunterinfoImpl.delete(hunter_info);
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
    
    @RequestMapping(params="method=queryByHunterInfoId")
    public @ResponseBody String queryByHunterInfoId(@RequestBody Hunter_Info hunter_info){
    	Hunter_Info info = hunterinfoImpl.queryByHunterInfoId(hunter_info.getInfo_id());
    	System.out.println("-----------hunterinfo_id:"+info.getInfo_id()+"---------");
		System.out.println("-----------user_id:"+info.getUser_id()+"---------");

    	Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		data.put("info_id", info.getInfo_id());
		data.put("user_id", info.getUser_id());
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
		
		String result = "{\"hunter_info\":"+ json_result +"}";
    	String result_temp = "error";
		result_temp = encoding.encoding(result);							
		return result_temp;
    }
    
    @RequestMapping(params="method=queryByHunterUserId")
    public @ResponseBody String queryByHunterUserId(@RequestBody Hunter_Info hunter_info){
    	Hunter_Info info = hunterinfoImpl.queryByHunterUserId(hunter_info.getUser_id());
	    Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		data.put("info_id", info.getInfo_id());
		data.put("user_id", info.getUser_id());
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
		
		String result = "{\"hunter_info\":"+ json_result +"}";
    	String result_temp = "error";
		result_temp = encoding.encoding(result);							
		return result_temp;
    }
    
    @RequestMapping(params="method=deleteByHunterInfoId")
	public @ResponseBody String deleteByHunterInfoId(@RequestBody Hunter_Info hunter_info){
    	
    	String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			hunterinfoImpl.deleteByInfoId(hunter_info.getInfo_id());
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
	
	@RequestMapping(params="method=deleteByHunterUserId")
	public @ResponseBody String deleteByHunterUserId(@RequestBody Hunter_Info hunter_info){

		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			hunterinfoImpl.deleteByInfoId(hunter_info.getUser_id());
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

	
	//Etp_Info
		@RequestMapping(params="method=etpinfo_insert")
		public @ResponseBody String etpinfo_insert(@RequestBody Etp_Info etp_info){
			
			String temp = "success";
			ToJson tojosn = new ToJson();	
			try {
				
				etpinfoImpl.insert(etp_info);
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
		
	    @RequestMapping(params="method=etpinfo_update")
	    public @ResponseBody String etpinfo_update(@RequestBody Etp_Info etp_info){
	    	
	    	String temp = "success";
			ToJson tojosn = new ToJson();	
			try {
				etpinfoImpl.update(etp_info);
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
	    
	    @RequestMapping(params="method=etpinfo_delete")
	    public @ResponseBody String etpinfo_delete(@RequestBody Etp_Info etp_info){
	    	
	    	String temp = "success";
			ToJson tojosn = new ToJson();	
			try {
				etpinfoImpl.delete(etp_info);
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
	    
	    @RequestMapping(params="method=queryByEtpInfoId")
	    public @ResponseBody String queryByEtpInfoId(@RequestBody Etp_Info etp_info){
	    	Etp_Info info = etpinfoImpl.queryByEtpInfoId(etp_info.getInfo_id());
	    	System.out.println("-----------etpinfo_id:"+info.getInfo_id()+"---------");
			System.out.println("-----------user_id:"+info.getUser_id()+"---------");
			Map data = new HashMap();
			JSONArray json_result = new JSONArray();
			data.put("info_id", info.getInfo_id());
			data.put("user_id", info.getUser_id());
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
			
			String result = "{\"etp_info\":"+ json_result +"}";
	    	String result_temp = "error";
			result_temp = encoding.encoding(result);							
			return result_temp;
	    }
	    
	    @RequestMapping(params="method=queryByEtpUserId")
	    public @ResponseBody String queryByEtpUserId(@RequestBody Etp_Info etp_info){
	    	Etp_Info info = etpinfoImpl.queryByEtpUserId(etp_info.getUser_id());
	    	System.out.println("-----------etpinfo_id:"+etp_info.getInfo_id()+"---------");
			System.out.println("-----------user_id:"+etp_info.getUser_id()+"---------");
			Map data = new HashMap();
			JSONArray json_result = new JSONArray();
			data.put("info_id", info.getInfo_id());
			data.put("user_id", info.getUser_id());
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
			
			String result = "{\"etp_info\":"+ json_result +"}";
	    	String result_temp = "error";
			result_temp = encoding.encoding(result);							
			return result_temp;
	    }
	    
	    @RequestMapping(params="method=deleteByEtpInfoId")
		public @ResponseBody String deleteByEtpInfoId(@RequestBody Etp_Info etp_info){
	    	
	    	String temp = "success";
			ToJson tojosn = new ToJson();	
			try {
				etpinfoImpl.deleteByInfoId(etp_info.getInfo_id());
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
		
		@RequestMapping(params="method=deleteByEtpUserId")
		public @ResponseBody String deleteByEtpUserId(@RequestBody Etp_Info etp_info){
			
			String temp = "success";
			ToJson tojosn = new ToJson();	
			try {
				etpinfoImpl.deleteByUserId(etp_info.getUser_id());
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

		
		
		
		
		
		public SeekerinfoServiceImpl getSeekerinfoImpl() {
			return seekerinfoImpl;
		}

		public void setSeekerinfoImpl(SeekerinfoServiceImpl seekerinfoImpl) {
			this.seekerinfoImpl = seekerinfoImpl;
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

