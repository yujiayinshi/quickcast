package com.paragon.quickcast.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.paragon.quickcast.entity.User_Reg;

@Component
public interface UserService {
	
	//public void insert(String user_name,String password,String user_type);
    public String insert(User_Reg user); 
    public String check_username(String username);
    public String check_email(String email);
    public String login(String user_name,String password);
    public User_Reg queryByUserId(int user_id);
	public List queryByName(String cn_tname);
	public User_Reg queryByEmail(String email);
	public List queryByUserType(String user_type);
	
}
