package com.paragon.quickcast.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prj_Exp {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int exp_id;
	
	@Column(nullable=false)
	private int user_id;
	
	@Column(nullable=false)
	private String prj_name;
	
	private String etp_name;
	
	private String prj_profession;
	
	@Column(nullable=false)
	private String start_time;
	
	@Column(nullable=false)
	private String end_time;
	
	@Column(nullable=false)
	private String prj_desc;
	
	@Column(nullable=false)
	private String prj_duty;
	
	@Column(nullable=false)
	private String prj_achievement;

	

	public int getExp_id() {
		return exp_id;
	}

	public void setExp_id(int exp_id) {
		this.exp_id = exp_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getPrj_name() {
		return prj_name;
	}

	public void setPrj_name(String prj_name) {
		this.prj_name = prj_name;
	}

	public String getEtp_name() {
		return etp_name;
	}

	public void setEtp_name(String etp_name) {
		this.etp_name = etp_name;
	}

	public String getPrj_profession() {
		return prj_profession;
	}

	public void setPrj_profession(String prj_profession) {
		this.prj_profession = prj_profession;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getPrj_desc() {
		return prj_desc;
	}

	public void setPrj_desc(String prj_desc) {
		this.prj_desc = prj_desc;
	}

	public String getPrj_duty() {
		return prj_duty;
	}

	public void setPrj_duty(String prj_duty) {
		this.prj_duty = prj_duty;
	}

	public String getPrj_achievement() {
		return prj_achievement;
	}

	public void setPrj_achievement(String prj_achievement) {
		this.prj_achievement = prj_achievement;
	}
	
}
