package com.paragon.quickcast.dao;



import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.paragon.quickcast.entity.Seeker_Info;
import com.paragon.quickcast.entity.User_Reg;


@Repository
public class Seeker_InfoDAO{
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	private Seeker_Info seeker = new Seeker_Info();
	//插入新的求职者信息；
	//以Seeker_Info类为传递参数；
	public boolean insert(Seeker_Info seeker_info){
		hibernateTemplate.save(seeker_info);
		return true;
	}
	
	//修改求职者个人信息功能
    public boolean update(Seeker_Info seeker_info){
    	hibernateTemplate.update(seeker_info);
    	return true;
    }
    
   //删除个人信息
    public boolean delete(Seeker_Info seeker_info){
    	hibernateTemplate.delete(seeker_info);
    	return true;
    }
    
	public Seeker_Info queryBySeekerInfoId(int info_id){
		return hibernateTemplate.get(Seeker_Info.class, info_id);
	}

	
	//
	public Seeker_Info queryBySeekerUserId(int user_id){
		
		String hql = "FROM Seeker_Info as seeker_info WHERE seeker_info.user_id=?";		
		List l = hibernateTemplate.find(hql,user_id);
		Iterator  iter = l.iterator();
		 
		if(iter.hasNext()){
			
			seeker = (Seeker_Info)iter.next();
		}
		return seeker;
	}
	
	public void deleteByUserId(int user_id){
		
		String hql = "FROM Seeker_Info as seeker_info WHERE seeker_info.user_id=?";		
		List l = hibernateTemplate.find(hql, user_id);
		hibernateTemplate.deleteAll(l);
	}
	
	public void deleteByInfoId(int info_id){
		
		hibernateTemplate.delete(hibernateTemplate.get(Seeker_Info.class, info_id));
	}

}
