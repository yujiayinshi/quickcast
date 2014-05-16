package com.paragon.quickcast.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seeker_Info {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int info_id;
	
	@Column(name="user_id",unique=true,nullable=false)
	private int user_id;
	
	@Column(name="mobile",unique=true,nullable=false)
	private String mobile;
	
	private String seeker_photo;
	
	@Column(name="gender",nullable=false)
	private String gender;
	
	private String age;
	
	private String marital_status;
	

	private String highest_edu;
	
	private String edu_type;
	
	@Column(name="start_time",nullable=false)
	private String start_time;
	
	@Column(name="end_time",nullable=false)
	private String end_time;
	
	@Column(name="job_status")
	private String job_status;
	
	private String self_intro;
	
	@Column(name="work_place")
	private String work_place;
	
	@Column(name="etp_name")
	private String etp_name;
	

	@Column(name="seeker_profession")
	private String seeker_profession;
	

	@Column(name="etp_industry")
	private String etp_industry;
	
	@Column(name="tech_direction")
	private String tech_direction;
	

	
	public int getInfo_id() {
		return info_id;
	}

	public void setInfo_id(int info_id) {
		this.info_id = info_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSeeker_photo() {
		return seeker_photo;
	}

	public void setSeeker_photo(String seeker_photo) {
		this.seeker_photo = seeker_photo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMarital_status() {
		return marital_status;
	}

	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}

	public String getHighest_edu() {
		return highest_edu;
	}

	public void setHighest_edu(String highest_edu) {
		this.highest_edu = highest_edu;
	}

	public String getEdu_type() {
		return edu_type;
	}

	public void setEdu_type(String edu_type) {
		this.edu_type = edu_type;
	}

	public String getStart_time() {
		return start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getJob_status() {
		return job_status;
	}

	public void setJob_status(String job_status) {
		this.job_status = job_status;
	}

	public String getSelf_intro() {
		return self_intro;
	}

	public void setSelf_intro(String self_intro) {
		this.self_intro = self_intro;
	}

	public String getWork_place() {
		return work_place;
	}

	public void setWork_place(String work_place) {
		this.work_place = work_place;
	}

	public String getEtp_name() {
		return etp_name;
	}

	public void setEtp_name(String etp_name) {
		this.etp_name = etp_name;
	}

	public String getSeeker_profession() {
		return seeker_profession;
	}

	public void setSeeker_profession(String seeker_profession) {
		this.seeker_profession = seeker_profession;
	}

	public String getEtp_industry() {
		return etp_industry;
	}

	public void setEtp_industry(String etp_industry) {
		this.etp_industry = etp_industry;
	}

	public String getTech_direction() {
		return tech_direction;
	}

	public void setTech_direction(String tech_direction) {
		this.tech_direction = tech_direction;
	}
		
}
