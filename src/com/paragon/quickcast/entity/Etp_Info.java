package com.paragon.quickcast.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Etp_Info {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int info_id;
	
	private int user_id;
	
	private String etp_name;
	
	private String etp_size;
	
	private String etp_nature;
	
	private String etp_addr;
	
	private String etp_industry;
	
	private String etp_email;
	
	private String msg_addr;
	
	private String contact_person;
	
	private String mobile;
	
	
	private String certificate;

	private String check_status;
	
	private String work_place;
	
	private String age;
	
	private String gender;
	
	@Column(name="etp_intro",nullable=false)
	private String etp_intro;
	
	

	public String getEtp_intro() {
		return etp_intro;
	}

	public void setEtp_intro(String etp_intro) {
		this.etp_intro = etp_intro;
	}

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

	public String getEtp_name() {
		return etp_name;
	}

	public void setEtp_name(String etp_name) {
		this.etp_name = etp_name;
	}

	public String getEtp_size() {
		return etp_size;
	}

	public void setEtp_size(String etp_size) {
		this.etp_size = etp_size;
	}

	public String getEtp_nature() {
		return etp_nature;
	}

	public void setEtp_nature(String etp_nature) {
		this.etp_nature = etp_nature;
	}

	public String getEtp_addr() {
		return etp_addr;
	}

	public void setEtp_addr(String etp_addr) {
		this.etp_addr = etp_addr;
	}

	public String getEtp_industry() {
		return etp_industry;
	}

	public void setEtp_industry(String etp_industry) {
		this.etp_industry = etp_industry;
	}

	public String getEtp_email() {
		return etp_email;
	}

	public void setEtp_email(String etp_email) {
		this.etp_email = etp_email;
	}

	public String getMsg_addr() {
		return msg_addr;
	}

	public void setMsg_addr(String msg_addr) {
		this.msg_addr = msg_addr;
	}

	public String getContact_person() {
		return contact_person;
	}

	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getCheck_status() {
		return check_status;
	}

	public void setCheck_status(String check_status) {
		this.check_status = check_status;
	}

	public String getWork_place() {
		return work_place;
	}

	public void setWork_place(String work_place) {
		this.work_place = work_place;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
