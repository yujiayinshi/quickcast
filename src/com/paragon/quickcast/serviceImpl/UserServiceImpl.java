package com.paragon.quickcast.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.paragon.quickcast.dao.Personal_RsmDAO;
import com.paragon.quickcast.dao.ToJson;
import com.paragon.quickcast.dao.User_RegDAO;
import com.paragon.quickcast.entity.Personal_Rsm;
import com.paragon.quickcast.entity.User_Reg;
import com.paragon.quickcast.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	@Resource
	private User_RegDAO userregDao;
	@Resource
	private Personal_RsmDAO personal_rsmdao;
	@Resource 
	private ToJson tojson;
	
	private User_Reg user_reg = null;
	
	public String insert(User_Reg user){
	
		Personal_Rsm personal = new Personal_Rsm();
		
		user_reg = userregDao.insert(user);
		String id = tojson.tojson("false");
		personal.setUser_id(user_reg.getUser_id());
		personal_rsmdao.insert(personal);
     

		String ss = System.getProperty("user.dir");
		String temp = ss.replace("\\", "/");
		String temp2 = temp.substring(0,temp.length()-3);
		String path = temp2+"webapps/quickcast/upload/";
        
        
        personal_rsmdao.copyFile(path+"mr.jpg",path+user_reg.getUser_id()+".jpg");
		Map data = new HashMap();
		JSONObject json = new JSONObject();
		data.put("user_id", user_reg.getUser_id()); 
		try {
			json.put("login_result", data);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return json.toString();
	}
	
	public String login(String user_name, String password) {
		// TODO Auto-generated method stub		
		String result = userregDao.login(user_name,password);
		return result;
	}
	
	public String check_username(String username){
		return userregDao.check_username(username);
		
	}
	
	public String check_email(String email) {
		// TODO Auto-generated method stub	
		return userregDao.check_email(email);
	}

    public User_Reg queryByUserId(int user_id){
    	
		return userregDao.queryByUserId(user_id);
	}
    
    
    public List queryByUserType(String user_type){
    	
    	return userregDao.queryByUserType(user_type);
    	
    }
    
    public List queryByName(String cn_tname){
    	
    	return userregDao.queryByName(cn_tname);
    	
    }
	public User_Reg queryByEmail(String email){
		
		return userregDao.queryByEmail(email);
		
	}

	public User_RegDAO getUserregDao() {
		return userregDao;
	}

	public void setUserregDao(User_RegDAO userregDao) {
		this.userregDao = userregDao;
	}

	public ToJson getTojson() {
		return tojson;
	}

	public void setTojson(ToJson tojson) {
		this.tojson = tojson;
	}


	public Personal_RsmDAO getPersonal_rsmdao() {
		return personal_rsmdao;
	}


	public void setPersonal_rsmdao(Personal_RsmDAO personal_rsmdao) {
		this.personal_rsmdao = personal_rsmdao;
	}

}
