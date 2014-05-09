package com.paragon.quickcast.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Edu_Exp {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int exp_id;
	
	@Column(nullable=false)
	private int user_id;
	
	@Column(nullable=false)
	private String school_name;
	
	@Column(nullable=false)
	private String study_start_time;
	
	@Column(nullable=false)
	private String study_end_time;
	
	@Column(nullable=false)
	private String edu_desc;
	
	@Column(nullable=false)
	private String major;
	
	@Column(nullable=false)
	private String edu_bg;

	
	
	

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

	public String getSchool_name() {
		return school_name;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getEdu_bg() {
		return edu_bg;
	}

	public void setEdu_bg(String edu_bg) {
		this.edu_bg = edu_bg;
	}

	public String getStudy_start_time() {
		return study_start_time;
	}

	public void setStudy_start_time(String study_start_time) {
		this.study_start_time = study_start_time;
	}

	public String getStudy_end_time() {
		return study_end_time;
	}

	public void setStudy_end_time(String study_end_time) {
		this.study_end_time = study_end_time;
	}

	public String getEdu_desc() {
		return edu_desc;
	}

	public void setEdu_desc(String edu_desc) {
		this.edu_desc = edu_desc;
	}
	
}
