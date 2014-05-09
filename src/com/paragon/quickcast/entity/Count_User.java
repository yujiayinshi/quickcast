package com.paragon.quickcast.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Count_User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;
	
	@Column(nullable = true)
	private int user_num;
	
	@Column(nullable = true)
	private int seeker_num;
	
	@Column(nullable = true)
	private int hunter_num;
	
	@Column(nullable = true)
	private int etp_num;
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	public int getUser_num() {
		return user_num;
	}


	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

	public int getSeeker_num() {
		return seeker_num;
	}

	public void setSeeker_num(int seeker_num) {
		this.seeker_num = seeker_num;
	}

	public int getHunter_num() {
		return hunter_num;
	}

	public void setHunter_num(int hunter_num) {
		this.hunter_num = hunter_num;
	}

	public int getEtp_num() {
		return etp_num;
	}

	public void setEtp_num(int etp_num) {
		this.etp_num = etp_num;
	}
	
	
}
