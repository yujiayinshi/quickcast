package com.paragon.quickcast.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Count_Rsmhandle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;
	
	private int etp_id;
	
	private int receive_num;
	
	private int handle_num;
	
	private float handle_rate;

	public int getEtp_id() {
		return etp_id;
	}

	public void setEtp_id(int etp_id) {
		this.etp_id = etp_id;
	}

	public int getReceive_num() {
		return receive_num;
	}

	public void setReceive_num(int receive_num) {
		this.receive_num = receive_num;
	}

	public int getHandle_num() {
		return handle_num;
	}

	public void setHandle_num(int handle_num) {
		this.handle_num = handle_num;
	}

	public float getHandle_rate() {
		return handle_rate;
	}

	public void setHandle_rate(float handle_rate) {
		this.handle_rate = handle_rate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
