package com.paragon.quickcast.entity;


import java.util.Comparator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Index;

/**
 * 
 * 接下来的任务就是实现好友圈
 * 遍历partner_id，找到并缓存记录partner_id的好友，统计每个好友出现的次数，找出次数最多的前20位
 * 算法实现：hash_map以好友_id作为key值，value值是好友_id出现的次数
 * 
 * **/
@Entity
public class Friend_List implements Comparator {
	
	private int rlts_id;
	
	private int partner_id;
	private int self_id;
	
	private String reason;
	private String status;
  
	private FriendsGroup friendsgroup;
	
	public final int compare(Object oFirst, Object oSecond){
		int rlts_idFirst = ((Friend_List)oFirst).getRlts_id();
		int rlts_idSecond = ((Friend_List)oSecond).getRlts_id(); 
		int diff = rlts_idFirst - rlts_idSecond;
		if(diff  > 0 )
			return 1;
		if(diff < 0)
			return -1;
		else 
			return 0;
		//Friend_List f = (Friend_List)o;
		//return rlts_id>f.getRlts_id()?1:(rlts_id==f.getRlts_id()?0:-1);
	}
	@ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="deptid")
	public FriendsGroup getFriendsgroup() {
		return friendsgroup;
	}
		
	public void setFriendsgroup(FriendsGroup friendsgroup) {
		this.friendsgroup = friendsgroup;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getRlts_id() {
		return rlts_id;
	}

	public void setRlts_id(int rlts_id) {
		this.rlts_id = rlts_id;
	}

	@Column(nullable=false)
	public int getPartner_id() {
		return partner_id;
	}

	public void setPartner_id(int partner_id) {
		this.partner_id = partner_id;
	}

	@Column(nullable=false)
	@Index(name="SelfID_Index")
	public int getSelf_id() {
		return self_id;
	}

	public void setSelf_id(int self_id) {
		this.self_id = self_id;
	}

	@Column(nullable=false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
