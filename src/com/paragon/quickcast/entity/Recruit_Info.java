package com.paragon.quickcast.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Index;

@Entity
public class Recruit_Info {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int info_id;
	
	@Column(name="user_id",nullable=false)
	private int user_id;
	
	@Column(name="issue_time",nullable=false)
	private String issue_time;
	
	@Column(name="recruit_job",nullable=false)
	@Index(name="hashindex")
	private String recruit_job;
	
	@Column(name="recruit_num",nullable=false)
	private int recruit_num;
	
	@Column(name="recruit_time")
	private String recruit_time;
	
	@Column(name="salary",nullable=false)
	private String salary;
	
	@Column(name="recruit_detail",nullable=false)
	private String recruit_detail;
	
	@Column(name="recruit_industry",nullable=false)
	private String recruit_industry;
	
	@Column(nullable = true)
	private String work_place;
	
	@Column(nullable = true)
	private String etp_name;
	
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

	public String getIssue_time() {
		return issue_time;
	}

	public void setIssue_time(String issue_time) {
		this.issue_time = issue_time;
	}

	public String getRecruit_job() {
		return recruit_job;
	}

	public void setRecruit_job(String recruit_job) {
		this.recruit_job = recruit_job;
	}

	public int getRecruit_num() {
		return recruit_num;
	}

	public void setRecruit_num(int recruit_num) {
		this.recruit_num = recruit_num;
	}

	public String getRecruit_time() {
		return recruit_time;
	}

	public void setRecruit_time(String recruit_time) {
		this.recruit_time = recruit_time;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}


	public String getRecruit_detail() {
		return recruit_detail;
	}

	public void setRecruit_detail(String recruit_detail) {
		this.recruit_detail = recruit_detail;
	}

	public String getRecruit_industry() {
		return recruit_industry;
	}

	public void setRecruit_industry(String recruit_industry) {
		this.recruit_industry = recruit_industry;
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
	
}
