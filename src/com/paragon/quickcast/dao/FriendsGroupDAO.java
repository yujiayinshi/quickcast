package com.paragon.quickcast.dao;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.paragon.quickcast.entity.FriendsGroup;
import com.paragon.quickcast.entity.User_Reg;

@Repository
public class FriendsGroupDAO {
	
	@Resource
	HibernateTemplate hibernateTemplate;
	
	public FriendsGroup findFriendsGroup(String grouptype){
		FriendsGroup friendsgroup = null;
		Iterator iterator = null;
 		List l = (List)this.hibernateTemplate.find("FROM FriendsGroup as friendsgroup WHERE friendsgroup.grouptype=?",new String(grouptype));
 		iterator = l.iterator();
 		if(iterator.hasNext())
 		{
 			friendsgroup = (FriendsGroup)iterator.next();
 		}
 		return friendsgroup;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
   
 
}
