package com.paragon.quickcast.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hunter_Info {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int info_id;
	
	@Column(name="user_id",unique=true,nullable=false)
	private int user_id;
	
	@Column(name="etp_name",nullable=false)
	private String etp_name;
	
	@Column(name="gender",nullable=false)
	private String gender;
	
	@Column(name="mobile",nullable=false)
	private String mobile;
	
	private String work_phone;
	
	private String hunter_fax;
	
	private String work_email;
	
	private String work_time;
	
	@Column(name="t_area",nullable=false)
	private String t_area;
	
	@Column(name="work_place",nullable=false)
	private String work_place;
	
	@Column(name="msg_addr",nullable=false)
	private String msg_addr;
	
	private String self_intro;
	
	private String partner;
	
	private String etp_intro;
	
	private String business_card;
	
	private String age;
	
	@Column(name="certificate",nullable=true)
	private String certificate;
	
	@Column(name="check_status",nullable=true)
	private String check_status;
	

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getWork_phone() {
		return work_phone;
	}

	public void setWork_phone(String work_phone) {
		this.work_phone = work_phone;
	}

	public String getHunter_fax() {
		return hunter_fax;
	}

	public void setHunter_fax(String hunter_fax) {
		this.hunter_fax = hunter_fax;
	}

	public String getWork_email() {
		return work_email;
	}

	public void setWork_email(String work_email) {
		this.work_email = work_email;
	}

	public String getWork_time() {
		return work_time;
	}

	public void setWork_time(String work_time) {
		this.work_time = work_time;
	}

	public String getT_area() {
		return t_area;
	}

	public void setT_area(String t_area) {
		this.t_area = t_area;
	}

	
	
	public String getMsg_addr() {
		return msg_addr;
	}

	public void setMsg_addr(String msg_addr) {
		this.msg_addr = msg_addr;
	}

	public String getSelf_intro() {
		return self_intro;
	}

	public void setSelf_intro(String self_intro) {
		this.self_intro = self_intro;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getEtp_intro() {
		return etp_intro;
	}

	public void setEtp_intro(String etp_intro) {
		this.etp_intro = etp_intro;
	}

	public String getBusiness_card() {
		return business_card;
	}

	public void setBusiness_card(String business_card) {
		this.business_card = business_card;
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
		
}
