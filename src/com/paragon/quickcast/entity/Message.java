package com.paragon.quickcast.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int msg_id;
	
	@Column(nullable = false)
	private int dispatch_id;
	
	@Column(nullable = false)
	private int receive_id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String content;
	
	@Column(nullable = false)
	private String status;
	
	@Column(nullable = false)
	private String dispatch_time;

	@Column(nullable = false)
	private String message_type;
	

	
	
	
	public int getMsg_id() {
		return msg_id;
	}

	public void setMsg_id(int msg_id) {
		this.msg_id = msg_id;
	}

	public int getDispatch_id() {
		return dispatch_id;
	}

	public void setDispatch_id(int dispatch_id) {
		this.dispatch_id = dispatch_id;
	}

	public int getReceive_id() {
		return receive_id;
	}

	public void setReceive_id(int receive_id) {
		this.receive_id = receive_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDispatch_time() {
		return dispatch_time;
	}

	public void setDispatch_time(String dispatch_time) {
		this.dispatch_time = dispatch_time;
	}

	public String getMessage_type() {
		return message_type;
	}

	public void setMessage_type(String message_type) {
		this.message_type = message_type;
	}

	

	
	

}
