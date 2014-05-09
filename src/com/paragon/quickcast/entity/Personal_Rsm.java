package com.paragon.quickcast.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Personal_Rsm {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int rsm_id;
	
	@Column(unique = true,nullable = false)
	private int user_id;
	
	private String edit_time;
	
	private String read_status;
	
	private String deliver_status;
	
	private String expect_industry;
	
	private String expect_job;
	
	private String expect_place;
	
	private String expect_salary;
	
	private String month_salary;
	
	private String work_month;
	
	private String language_skill;
	
	private String self_evaluate;
	
	private String add_info;

	
	
	public int getRsm_id() {
		return rsm_id;
	}

	public void setRsm_id(int rsm_id) {
		this.rsm_id = rsm_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getEdit_time() {
		return edit_time;
	}

	public void setEdit_time(String edit_time) {
		this.edit_time = edit_time;
	}

	public String getRead_status() {
		return read_status;
	}

	public void setRead_status(String read_status) {
		this.read_status = read_status;
	}

	public String getDeliver_status() {
		return deliver_status;
	}

	public void setDeliver_status(String deliver_status) {
		this.deliver_status = deliver_status;
	}

	public String getExpect_industry() {
		return expect_industry;
	}

	public void setExpect_industry(String expect_industry) {
		this.expect_industry = expect_industry;
	}

	public String getExpect_job() {
		return expect_job;
	}

	public void setExpect_job(String expect_job) {
		this.expect_job = expect_job;
	}

	public String getExpect_place() {
		return expect_place;
	}

	public void setExpect_place(String expect_place) {
		this.expect_place = expect_place;
	}

	public String getExpect_salary() {
		return expect_salary;
	}

	public void setExpect_salary(String expect_salary) {
		this.expect_salary = expect_salary;
	}

	public String getMonth_salary() {
		return month_salary;
	}

	public void setMonth_salary(String month_salary) {
		this.month_salary = month_salary;
	}

	public String getWork_month() {
		return work_month;
	}

	public void setWork_month(String work_month) {
		this.work_month = work_month;
	}

	public String getLanguage_skill() {
		return language_skill;
	}

	public void setLanguage_skill(String language_skill) {
		this.language_skill = language_skill;
	}

	public String getSelf_evaluate() {
		return self_evaluate;
	}

	public void setSelf_evaluate(String self_evaluate) {
		this.self_evaluate = self_evaluate;
	}

	public String getAdd_info() {
		return add_info;
	}

	public void setAdd_info(String add_info) {
		this.add_info = add_info;
	}
		
}
