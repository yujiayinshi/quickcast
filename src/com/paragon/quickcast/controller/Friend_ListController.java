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
import com.paragon.quickcast.entity.Friend_List;
import com.paragon.quickcast.entity.User_Reg;
import com.paragon.quickcast.service.Friend_ListService;
import com.paragon.quickcast.service.UserService;

@Controller
@RequestMapping("/friend_list.do")
public class Friend_ListController {
	
	@Resource
	private Friend_ListService friend_listservice;
	@Resource
	private UserService userservice;
	@Resource
	private Encoding encoding;
	
	
    //申请好友
	@RequestMapping(params="method=imp_friend_list_insert")	
	public @ResponseBody String imp_friend_list_insert(@RequestBody Friend_List friend_list){
		
		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			friend_list.setStatus("1");
			friend_listservice.insert(friend_list);
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
	
	
	//同意或者拒绝添加好友
	@RequestMapping(params="method=imp_friend_list_update")
	public @ResponseBody String imp_friend_list_update(@RequestBody Friend_List friend_list){
		
		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			System.out.println(friend_list.getStatus());
			if(friend_list.getStatus().equals("2")){
			    friend_listservice.update(friend_list);			    
			}
			else{
				
				friend_listservice.delete(friend_list.getRlts_id());
				
			}				
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
	
	//查看好友申请
	@RequestMapping(params="method=imp_friend_list_apply")
	public @ResponseBody String imp_friend_list_apply(@RequestBody Friend_List friend_list){
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		List l = friend_listservice.queryByPartnerId(friend_list.getPartner_id());
		if(l.isEmpty()){
			ToJson tojson = new ToJson();
			String temp = null;
			String result_temp = tojson.tojson(temp);
			result_temp = encoding.encoding(result_temp);
			return result_temp;
		}
		Iterator iter = l.iterator();
		while(iter.hasNext()){
			
			Friend_List friend_listInstance = (Friend_List)iter.next();
			data.put("rlts_id", friend_listInstance.getRlts_id());
			data.put("partner_id", friend_listInstance.getSelf_id());
			data.put("friend_status", friend_listInstance.getStatus());
			data.put("reason", friend_listInstance.getReason());
			User_Reg user_reg = userservice.queryByUserId(friend_listInstance.getSelf_id());
			data.put("partner_name", user_reg.getCn_tname());
			data.put("partner_email", user_reg.getEmail());
			data.put("user_type",user_reg.getUser_type());
			json_result.put(data);
		    System.out.println("-----------rlts_id:"+friend_listInstance.getRlts_id()+"---------");
		    System.out.println("-----------partner_id:"+friend_listInstance.getPartner_id()+"---------");
		    System.out.println("-----------self_id:"+friend_listInstance.getSelf_id()+"---------");
		    System.out.println("-----------status:"+friend_listInstance.getStatus()+"---------");		
		}	
		
		String result = "{\"friend_list\":"+ json_result +"}";
		String result_temp = encoding.encoding(result);		
		return result_temp;	
	}
	
	//查看好友列表，找出好友
	@RequestMapping(params="method=imp_friend_list_queryBySelfId")
	public@ResponseBody String imp_friend_list_queryBySelfId(@RequestBody Friend_List friend_list){
		
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();		
		List l = friend_listservice.queryBySelfId(friend_list.getSelf_id());
		Iterator iter = l.iterator();
		while(iter.hasNext()){
			
			Friend_List friend_listInstance = (Friend_List)iter.next();
			data.put("rlts_id", friend_listInstance.getRlts_id());
			data.put("self_id", friend_listInstance.getSelf_id());
			data.put("partner_id", friend_listInstance.getPartner_id());
			data.put("friend_status", friend_listInstance.getStatus());
			data.put("reason", friend_listInstance.getReason());
			data.put("friendsgroup",friend_listInstance.getFriendsgroup().getGrouptype());
			User_Reg user_reg = userservice.queryByUserId(friend_listInstance.getPartner_id());
			data.put("partner_name", user_reg.getCn_tname());
			data.put("partner_email", user_reg.getEmail());
			json_result.put(data);
		    System.out.println("-----------rlts_id:"+friend_listInstance.getRlts_id()+"---------");
		    System.out.println("-----------partner_id:"+friend_listInstance.getPartner_id()+"---------");
		    System.out.println("-----------self_id:"+friend_listInstance.getSelf_id()+"---------");
		    System.out.println("-----------status:"+friend_listInstance.getStatus()+"---------");		
		}	
		
		String result = "{\"friend_list\":"+ json_result +"}";
		String result_temp = encoding.encoding(result);		
		return result_temp;	
	}
	
	//通过姓名来搜索，以添加其为好友
	@RequestMapping(params="method=imp_friend_list_queryByName")
	public@ResponseBody String imp_friend_list_queryByName(@RequestBody User_Reg user_reg){
		
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		List l = userservice.queryByName(user_reg.getCn_tname());
		if(l.isEmpty()){
			ToJson tojson = new ToJson();
			String temp = "fail";
			String result_temp = tojson.tojson(temp);
			result_temp = encoding.encoding(result_temp);
			return result_temp;
		}
		Iterator iter = l.iterator();
		for(int i=0;i<l.size();i++){
			
			User_Reg user_regInstacne = (User_Reg)iter.next();
			data.put("partner_id", user_regInstacne.getUser_id());
			data.put("partner_name", user_regInstacne.getCn_tname());
			data.put("partner_email", user_regInstacne.getEmail());
			json_result.put(data);
		    System.out.println("-----------partner_name:"+user_regInstacne.getCn_tname()+"---------");
		    System.out.println("-----------partner_email:"+user_regInstacne.getEmail()+"---------");		
		}	
		
		String result = "{\"query\":"+ json_result +"}";
		String result_temp = encoding.encoding(result);		
		return result_temp;	
	}
	
	//通过邮箱来搜索，以添加其为好友
	@RequestMapping(params="method=imp_friend_list_queryByEmail")
	public@ResponseBody String imp_friend_list_queryByEmail(@RequestBody User_Reg user_reg){
		
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		User_Reg user_regInstacne = userservice.queryByEmail(user_reg.getEmail());

		if(user_regInstacne == null){
			ToJson tojson = new ToJson();
			String temp = "fail";
			String result_temp = tojson.tojson(temp);
			result_temp = encoding.encoding(result_temp);
			return result_temp;
		}
		data.put("partner_id", user_regInstacne.getUser_id());
		data.put("partner_name", user_regInstacne.getCn_tname());
		data.put("partner_email", user_regInstacne.getEmail());
		json_result.put(data);	
		String result = "{\"query\":"+ json_result +"}";
		String result_temp = encoding.encoding(result);		
		return result_temp;	
	}
	
	
	
	
	
	
	@RequestMapping(params="method=imp_friend_list_queryByRltsId")
	public String imp_friend_list_queryByRltsId(@RequestBody Friend_List friend_list){
		
		Friend_List friend_listInstance = friend_listservice.queryByRltsId(friend_list.getRlts_id());
			
		System.out.println("-----------rlts_id:"+friend_listInstance.getRlts_id()+"---------");
		System.out.println("-----------partner_id:"+friend_listInstance.getPartner_id()+"---------");
		System.out.println("-----------self_id:"+friend_listInstance.getSelf_id()+"---------");
		System.out.println("-----------status:"+friend_listInstance.getStatus()+"---------");
		
		return "index";
	}
	
	
	@RequestMapping(params="method=imp_friend_list_delete")
	public String imp_friend_list_delete(@RequestBody Friend_List friend_list){
		
		friend_listservice.delete(friend_list.getRlts_id());
		return "index";
		
	}

	
	@RequestMapping(params="method=imp_friend_list_deleteByPartnerId")
	public String imp_friend_list_deleteByPartnerId(@RequestBody Friend_List friend_list){
		
		friend_listservice.deleteByPartnerId(friend_list.getPartner_id());
		return "index";
		
	}
	
	//解除好友关系
	@RequestMapping(params="method=imp_friend_list_deleteBySelfId")
	public @ResponseBody String imp_friend_list_deleteBySelfId(@RequestBody Friend_List friend_list){

		
		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			friend_listservice.deleteBySelfId(friend_list.getSelf_id(),friend_list.getPartner_id());
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
	
	//好友圈
	@RequestMapping(params="method=display_friendsarray")
	public @ResponseBody String display_friendsarray(@RequestBody Friend_List friend_list){
		Friend_List[] partner = friend_listservice.creat_arraysort(friend_list.getSelf_id());
		 Map data = new HashMap();
		 JSONArray json_result = new JSONArray();
		 for(int i = 0; i<5 && i < partner.length; i++){
			 System.out.println(partner[i].getRlts_id());
			 User_Reg user_reg = userservice.queryByUserId(partner[i].getPartner_id());			 
			 data.put("user_name", user_reg.getCn_tname());
			 data.put("email", user_reg.getEmail());
;			 System.out.println(user_reg.getCn_tname());
			 data.put("partner"+i, partner[i].getPartner_id());
			 data.put("partner_num", partner[i].getRlts_id());
		 }
		 json_result.put(data);
		 String result = "{\"partner\":"+ json_result +"}";
		 String result_temp = encoding.encoding(result);				
		 return result_temp;		 
	}

	public Friend_ListService getFriend_listservice() {
		return friend_listservice;
	}

	public void setFriend_listservice(Friend_ListService friend_listservice) {
		this.friend_listservice = friend_listservice;
	}

	public Encoding getEncoding() {
		return encoding;
	}

	public void setEncoding(Encoding encoding) {
		this.encoding = encoding;
	}




	public UserService getUserservice() {
		return userservice;
	}




	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	
}
