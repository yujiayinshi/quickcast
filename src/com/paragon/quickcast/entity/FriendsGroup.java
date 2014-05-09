package com.paragon.quickcast.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class FriendsGroup {
	
	private int groupid;
	
	private String grouptype;
	
	
	private Set<Friend_List> friend_list =new HashSet<Friend_List>();
	
	@Transient
	public Set<Friend_List> getFriend_list() {
		return friend_list;
	}

	public void setFriend_list(Set<Friend_List> friend_list) {
		this.friend_list = friend_list;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	public String getGrouptype() {
		return grouptype;
	}
	public void setGrouptype(String grouptype) {
		this.grouptype = grouptype;
	}

}
