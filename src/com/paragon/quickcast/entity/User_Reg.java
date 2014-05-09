package com.paragon.quickcast.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User_Reg {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int user_id;
	
	
	@Column(name="user_name",unique=false,nullable=false)
	private String user_name;
	
	@Column(name="password",unique=false,nullable=false)
	private String password;
	
	
	@Column(name="eng_name",unique=false,nullable=true)
	private String eng_name;
	
	@Column(name="cn_tname",unique=false,nullable=false)
	private String cn_tname;
	
	@Column(name="email",unique=true,nullable=false)
	private String email;
	
	private String user_type;

	
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getEng_name() {
		return eng_name;
	}

	public void setEng_name(String eng_name) {
		this.eng_name = eng_name;
	}

	public String getCn_tname() {
		return cn_tname;
	}

	public void setCn_tname(String cn_tname) {
		this.cn_tname = cn_tname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
