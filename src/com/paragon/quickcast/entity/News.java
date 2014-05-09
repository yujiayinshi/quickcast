package com.paragon.quickcast.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class News {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int news_id;
	
	@Column(nullable = false)
	private int pub_id;
	
	@Column(nullable = false)
	private String pub_time;
	
	@Column(nullable = false)
	private String content;
	
	@Column(nullable = false)
	private String pub_type;

	@Column(nullable = true)
	private int info_id;
	
	@Column(nullable = true)
	private String work_place;
	
	@Column(nullable = true)
	private String etp_name;
	
	public int getNews_id() {
		return news_id;
	}

	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}

	public int getPub_id() {
		return pub_id;
	}

	public void setPub_id(int pub_id) {
		this.pub_id = pub_id;
	}


	public String getPub_time() {
		return pub_time;
	}

	public void setPub_time(String pub_time) {
		this.pub_time = pub_time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPub_type() {
		return pub_type;
	}

	public void setPub_type(String pub_type) {
		this.pub_type = pub_type;
	}

	public int getInfo_id() {
		return info_id;
	}

	public void setInfo_id(int info_id) {
		this.info_id = info_id;
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
