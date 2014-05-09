package com.paragon.quickcast.dao;


import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.paragon.quickcast.entity.Hunter_Info;


@Repository
public class Hunter_InfoDAO{
	@Resource
	private HibernateTemplate hibernateTemplate;
	public boolean insert(Hunter_Info hunter_info){
		hibernateTemplate.save(hunter_info);
		return true;
	}

    public boolean update(Hunter_Info hunter_info){
	    hibernateTemplate.update(hunter_info);
	    return true;
    }
     
     public boolean delete(Hunter_Info hunter_info){
    	 hibernateTemplate.delete(hunter_info);
    	 return true;
     }
     
     public Hunter_Info queryByHunterInfoId(int info_id){
    	 return hibernateTemplate.get(Hunter_Info.class, info_id);
 	}
     
     public Hunter_Info queryByHunterUserId(int user_id){
 		
    	Hunter_Info hunter_info = null;
    	String hql = "FROM Hunter_Info as hunter_info WHERE hunter_info.user_id=?";		
 		List l = hibernateTemplate.find(hql, user_id);
 		Iterator iter = l.iterator();
 		if(iter.hasNext()){
 			hunter_info = (Hunter_Info)iter.next();
 	 		}
 	 		return hunter_info;
 	}
 	
 	public void deleteByUserId(int user_id){
 		
 		String hql = "FROM Hunter_Info as hunter_info WHERE hunter_info.user_id=?";		
 		List l = hibernateTemplate.find(hql, user_id);
 		hibernateTemplate.deleteAll(l);
 	}
 	
 	public void deleteByInfoId(int info_id){
 		
 		hibernateTemplate.delete(hibernateTemplate.get(Hunter_Info.class, info_id));
 	}
}

