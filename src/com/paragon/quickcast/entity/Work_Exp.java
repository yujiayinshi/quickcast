package com.paragon.quickcast.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Work_Exp {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int exp_id;
	
	@Column(nullable=false)
	private int user_id;
	
	private String start_time;
	
	private String end_time;
	
	private String etp_name;
	
	private String etp_industry;
	
	private String etp_nature;
	
	private String etp_size;
	
	private String etp_desc;
	
	@Column(nullable=false)
	private String profession;
	
	@Column(nullable=false)
	private String work_place;
	
	@Column(nullable=false)
	private String work_duty;

	
	
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

	public String getEtp_name() {
		return etp_name;
	}

	public void setEtp_name(String etp_name) {
		this.etp_name = etp_name;
	}

	public String getEtp_industry() {
		return etp_industry;
	}

	public void setEtp_industry(String etp_industry) {
		this.etp_industry = etp_industry;
	}

	public String getEtp_nature() {
		return etp_nature;
	}

	public void setEtp_nature(String etp_nature) {
		this.etp_nature = etp_nature;
	}

	public String getEtp_size() {
		return etp_size;
	}

	public void setEtp_size(String etp_size) {
		this.etp_size = etp_size;
	}

	public String getEtp_desc() {
		return etp_desc;
	}

	public void setEtp_desc(String etp_desc) {
		this.etp_desc = etp_desc;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getWork_place() {
		return work_place;
	}

	public void setWork_place(String work_place) {
		this.work_place = work_place;
	}

	public String getWork_duty() {
		return work_duty;
	}

	public void setWork_duty(String work_duty) {
		this.work_duty = work_duty;
	}
	
	
}
