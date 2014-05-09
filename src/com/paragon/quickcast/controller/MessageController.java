package com.paragon.quickcast.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
import com.paragon.quickcast.entity.Message;
import com.paragon.quickcast.entity.User_Reg;
import com.paragon.quickcast.service.MessageService;
import com.paragon.quickcast.service.UserService;

@Controller
@RequestMapping("/message.do")
public class MessageController {
	
	@Resource
	private MessageService messageservice;
	@Resource
	private UserService userservice;
	@Resource
	private Encoding encoding;
	

	@RequestMapping(params="method=imp_message_insert")
	public @ResponseBody String imp_news_insert(@RequestBody Message message){		
			
		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {	
			message.setMessage_type("1");
			message.setStatus("1");
			messageservice.insert(message);
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
	
	
	@RequestMapping(params="method=imp_message_update")
	public String imp_message_update(Message message){
		
		messageservice.update(message);
		return "index";
	}
	
	
	@RequestMapping(params="method=imp_message_queryByDispatchId")
	public @ResponseBody String imp_message_queryByDispatchId(@RequestBody Message message){
		
		User_Reg userregInstance = null;
		List l = messageservice.queryByDispatchId(message.getDispatch_id());
		Iterator iter = l.iterator();
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		while(iter.hasNext()){
			Message messageInstance = (Message)iter.next();
			data.put("msg_id", messageInstance.getMsg_id());
			data.put("dispatch_id", messageInstance.getDispatch_id());			
			data.put("receive_id", messageInstance.getReceive_id());
			userregInstance = userservice.queryByUserId(messageInstance.getReceive_id());
			data.put("receive_name",userregInstance.getCn_tname());
			data.put("dispatch_time", messageInstance.getDispatch_time());
			data.put("status", messageInstance.getStatus());
			data.put("title", messageInstance.getTitle());
			data.put("content", messageInstance.getContent());
			data.put("message_type", messageInstance.getMessage_type());
			json_result.put(data);
		}
		String result = "{\"message\":"+ json_result +"}";
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
	
	
	@RequestMapping(params="method=imp_message_queryByReceiveId")
	public @ResponseBody String imp_message_queryByReceiveId(@RequestBody Message message){
		
		User_Reg userregInstance = userservice.queryByUserId(message.getReceive_id());
		List l = messageservice.queryByReceiveId(message.getReceive_id());
		Iterator iter = l.iterator();
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		
		while(iter.hasNext()){
			Message messageInstance = (Message)iter.next();
			data.put("msg_id", messageInstance.getMsg_id());
			data.put("dispatch_id", messageInstance.getDispatch_id());
			userregInstance = userservice.queryByUserId(messageInstance.getDispatch_id());
			data.put("dispatch_name",userregInstance.getCn_tname());
			data.put("receive_id", messageInstance.getReceive_id());
			data.put("dispatch_time", messageInstance.getDispatch_time());
			data.put("status", messageInstance.getStatus());
			data.put("title", messageInstance.getTitle());
			data.put("content", messageInstance.getContent());
			data.put("message_type", messageInstance.getMessage_type());
			json_result.put(data);
		}
		String result = "{\"message\":"+ json_result +"}";
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
	
	@RequestMapping(params="method=imp_message_queryByMsgId")
	public String imp_message_queryByMsgId(Message message){
		
		Message messageInstance = messageservice.queryByMsgId(message.getMsg_id());									
		return "index";
	}
	
	
	@RequestMapping(params="method=imp_message_delete")
	public String imp_message_delete(Message message){
		
		messageservice.delete(message);
					
		return "index";
	}
	
	@RequestMapping(params="method=imp_message_deleteByMsgId")
	public @ResponseBody String imp_message_deleteByMsgId(@RequestBody Message message){
		String temp = "success";
		ToJson tojosn = new ToJson();		
		try {
			messageservice.deleteByMsgId(message.getMsg_id());
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			
			temp = "fail";
			String result_temp = tojosn.tojson(temp);
			result_temp = encoding.encoding(result_temp);			
			e.printStackTrace();
			return result_temp;
		}							
		
		
		String result_temp = tojosn.tojson(temp);
		result_temp = encoding.encoding(result_temp);
								
		return result_temp;	
	}
	
	
	@RequestMapping(params="method=imp_message_deleteByDispatchId")
	public String imp_message_deleteByDispatchId(Message message){
		
		messageservice.deleteByDispatchId(message.getDispatch_id());
					
		return "index";
	}
	
	
	@RequestMapping(params="method=imp_message_deleteByReceiveId")
	public String imp_message_deleteByReceiveId(Message message){
		
		messageservice.deleteByReceiveId(message.getReceive_id());
					
		return "index";
	}


	public MessageService getMessageservice() {
		return messageservice;
	}


	public void setMessageservice(MessageService messageservice) {
		this.messageservice = messageservice;
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
