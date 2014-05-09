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
import com.paragon.quickcast.entity.Friend_List;
import com.paragon.quickcast.entity.News;
import com.paragon.quickcast.entity.User_Reg;
import com.paragon.quickcast.service.Friend_ListService;
import com.paragon.quickcast.service.NewsService;
import com.paragon.quickcast.service.UserService;

@Controller
@RequestMapping("/news.do")
public class NewsController {
	
	@Resource
	private NewsService newsservice;
	@Resource
	private UserService userservice;
	@Resource 
	private Friend_ListService friend_listservice;
	@Resource
    private Encoding encoding;
	
	
	//发布动态，
	//Pub_type=1表示普通动态
	//Pub_type=2为猎头发布的猎头信息
	//Pub_type=3为企业发布的招聘信息
	@RequestMapping(params="method=imp_news_insert")
	public @ResponseBody String imp_news_insert(@RequestBody News news){
				
		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			news.setInfo_id(0);
			newsservice.insert(news);
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
	
	
	@RequestMapping(params="method=imp_news_update")
	public @ResponseBody String imp_news_update(@RequestBody News news){		
		newsservice.update(news);
		return "index";
	}
	
	//查看发布者个人的所有动态
	@RequestMapping(params="method=imp_news_queryByPubId")
	public @ResponseBody String imp_news_queryByPubId(@RequestBody News news){
		
		User_Reg user_reg = userservice.queryByUserId(news.getPub_id());
		List l = newsservice.queryByPubId(news.getPub_id());
		Iterator iter = l.iterator();
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		while(iter.hasNext()){
		News newsInstance = (News)iter.next();
		data.put("news_id", newsInstance.getNews_id());
		data.put("pub_id", newsInstance.getPub_id());
		data.put("pub_name",user_reg.getCn_tname());
		data.put("pub_time", newsInstance.getPub_time());
		data.put("content", newsInstance.getContent());
		data.put("pub_type", newsInstance.getPub_type());
		data.put("info_id", newsInstance.getInfo_id());
		data.put("work_place", newsInstance.getWork_place());
		data.put("etp_name", newsInstance.getEtp_name());
		json_result.put(data);
		}

		String result = "{\"news\":"+ json_result +"}";
		String result_temp = "error";
		try {
			result_temp = URLEncoder.encode(result, "utf-8");
			result_temp = URLEncoder.encode(result, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
									
		return result_temp;	
	}
	
	//查看好友发布的动态
	@RequestMapping(params="method=imp_news_display")
	public @ResponseBody String imp_news_display(@RequestBody News news){
		List friend_list = friend_listservice.queryBySelfId(news.getPub_id());
		Iterator friend_iter = friend_list.iterator();
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		for(int i=0;i<friend_list.size();i++){
			Friend_List friend_listInstance = (Friend_List)friend_iter.next();
			if(friend_listInstance.getStatus().equals("2")){
			List news_list = newsservice.queryByPubId(friend_listInstance.getPartner_id());
			Iterator news_iter = news_list.iterator();
			for(int j=0;j<news_list.size();j++){
				News newsInstance = (News)news_iter.next();
				data.put("news_id", newsInstance.getNews_id());
				data.put("pub_id", newsInstance.getPub_id());
				User_Reg user_reg = userservice.queryByUserId(friend_listInstance.getPartner_id());
				data.put("pub_name",user_reg.getCn_tname());
				data.put("pub_time", newsInstance.getPub_time());
				data.put("content", newsInstance.getContent());
				data.put("pub_type", newsInstance.getPub_type());
				data.put("info_id", newsInstance.getInfo_id());
				data.put("work_place", newsInstance.getWork_place());
				data.put("etp_name", newsInstance.getEtp_name());
				json_result.put(data);
			}
		  }
		}

		String result = "{\"news\":"+ json_result + "}";
		String result_temp = "error";
		try {
			result_temp = URLEncoder.encode(result, "utf-8");
			result_temp = URLEncoder.encode(result, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}						
		return result_temp;	
	}
	
	
	
	@RequestMapping(params="method=imp_news_queryByNewsId")
	public @ResponseBody String imp_news_queryByNewId(@RequestBody News news){
		
		News newsInstance = newsservice.queryByNewsId(news.getNews_id());
		return "index";
	}
	
	
	@RequestMapping(params="method=imp_news_delete")
	public @ResponseBody String imp_news_delete(@RequestBody News news){
		
		newsservice.delete(news);
		return "index";
	}
	
	
	@RequestMapping(params="method=imp_news_deleteByPubId")
	public @ResponseBody String imp_news_deleteByPubId(@RequestBody News news){
		
		newsservice.deleteByPubId(news.getPub_id());
		return "index";
		
	}
	
	//删除动态
	@RequestMapping(params="method=imp_news_deleteByNewsId")
	public @ResponseBody String imp_news_deleteByNewsId(@RequestBody News news){
		
		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			newsservice.deleteByNewsId(news.getNews_id());
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

	

	public NewsService getNewsservice() {
		return newsservice;
	}

	public void setNewsservice(NewsService newsservice) {
		this.newsservice = newsservice;
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
