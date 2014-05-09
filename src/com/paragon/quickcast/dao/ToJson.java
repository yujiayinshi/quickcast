package com.paragon.quickcast.dao;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;



@Component
public class ToJson {
    
	public String tojson(String data){
		String result = "";
		Map data_map = new HashMap();
		JSONObject json = new JSONObject();
		data_map.put("data", data);
		try {
			json.put("result", data_map);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return json.toString();
	}
}
