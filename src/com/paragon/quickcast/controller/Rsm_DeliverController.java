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
import com.paragon.quickcast.entity.Rsm_Deliver;
import com.paragon.quickcast.service.DeliverService;

@Controller
@RequestMapping("/rsm_deliver.do")
public class Rsm_DeliverController {
	
	@Resource
	private DeliverService deliverservice;
	@Resource
	private Encoding encoding;
	
	@RequestMapping(params="method=imp_deliver_insert")	
	public @ResponseBody String imp_deliver_insert(@RequestBody Rsm_Deliver rsm_deliver){
	
		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
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
	public @ResponseBody String imp_deliver_queryByRsmId(@RequestBody Rsm_Deliver rsm_deliver){
		
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		List l = deliverservice.queryByRsmId(rsm_deliver.getRsm_id());
		Iterator iter = l.iterator();
		while(iter.hasNext()){
			Rsm_Deliver deliver = (Rsm_Deliver)iter.next();
			data.put("", deliver.getDeliver_id());
			data.put("", deliver.getEtp_id());
			data.put("", deliver.getRsm_id());
			data.put("", deliver.getDeliver_id());
			json_result.put(data);
		}
		String result = "{\"friend_list\":"+ json_result +"}";
		String result_temp = encoding.encoding(result);		
		return result_temp;	
	}
	
	@RequestMapping(params="method=imp_deliver_queryByEtpId")	
	public @ResponseBody String imp_deliver_queryByEtpId(@RequestBody int etp_id){
		
		List l = deliverservice.queryByEtpId(etp_id);
		Iterator iter = l.iterator();
		while(iter.hasNext()){
			Rsm_Deliver rsm_deliver = (Rsm_Deliver)iter.next();
		}
		return "index";
	}
	
	@RequestMapping(params="method=imp_deliver_queryByHunterId")	
	public @ResponseBody String imp_deliver_queryByHunterId(@RequestBody int hunter_id){
		
		List l = deliverservice.queryByHunterId(hunter_id);
		Iterator iter = l.iterator();
		while(iter.hasNext()){
			Rsm_Deliver rsm_deliver = (Rsm_Deliver)iter.next();
		}
		return "index";
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
	
	

	public DeliverService getDeliverservice() {
		return deliverservice;
	}

	public void setDeliverservice(DeliverService deliverservice) {
		this.deliverservice = deliverservice;
	}

	public Encoding getEncoding() {
		return encoding;
	}

	public void setEncoding(Encoding encoding) {
		this.encoding = encoding;
	}

}
