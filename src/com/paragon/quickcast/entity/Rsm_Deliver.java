package com.paragon.quickcast.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Rsm_Deliver {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int deliver_id;
	
	@Column(nullable = false)
	private int rsm_id;
	
	@Column(nullable = false)
	private int etp_id;
	
	@Column(nullable = true)
	private int hunter_id;

	@Column(nullable = false)
	private String handle_status;
	
	
	public int getDeliver_id() {
		return deliver_id;
	}

	public void setDeliver_id(int deliver_id) {
		this.deliver_id = deliver_id;
	}

	public int getRsm_id() {
		return rsm_id;
	}

	public void setRsm_id(int rsm_id) {
		this.rsm_id = rsm_id;
	}

	public int getEtp_id() {
		return etp_id;
	}

	public void setEtp_id(int etp_id) {
		this.etp_id = etp_id;
	}

	public int getHunter_id() {
		return hunter_id;
	}

	public void setHunter_id(int hunter_id) {
		this.hunter_id = hunter_id;
	}

	public String getHandle_status() {
		return handle_status;
	}

	public void setHandle_status(String handle_status) {
		this.handle_status = handle_status;
	}	
	
}
