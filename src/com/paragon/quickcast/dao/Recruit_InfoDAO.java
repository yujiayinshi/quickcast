package com.paragon.quickcast.dao;


import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.paragon.quickcast.entity.Etp_Info;
import com.paragon.quickcast.entity.Recruit_Info;


@Repository
public class Recruit_InfoDAO{
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	public boolean insert(Recruit_Info recruit_info){
		hibernateTemplate.save(recruit_info);
		return true;
	}
	public boolean update(Recruit_Info recruit_info){
		hibernateTemplate.update(recruit_info);
		return true;
	}

	public Recruit_Info queryByInfoId(int info_id){
		Recruit_Info recruit_info  = null;
 		Iterator iterator = null;
 		List l = (List)this.hibernateTemplate.find("FROM Recruit_Info as recruit_info WHERE recruit_info.info_id=?",new Integer(info_id));
 		iterator = l.iterator();
 		if(iterator.hasNext())
 		{
 			recruit_info = (Recruit_Info)iterator.next();
 		}
 		return recruit_info;
 	}
	
	
	public boolean delete(int info_id){
		Recruit_Info recruit_info = null;
		recruit_info = this.queryByInfoId(info_id);
		hibernateTemplate.delete(recruit_info);
		return true;
	}
	

	public List queryByUserId(int user_id){
		
		String hql = "FROM Recruit_Info as recruit_info WHERE recruit_info.user_id=?";
		List l = hibernateTemplate.find(hql, user_id);
		return l;
	}
	
	
	public List queryAll(){
		
		String hql = "FROM Recruit_Info as recruit_info";
		List l = hibernateTemplate.find(hql);
		return l;
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	
}	
	
