package com.paragon.quickcast.dao;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.paragon.quickcast.entity.Count_Rsmhandle;
import com.paragon.quickcast.entity.Count_User;
import com.paragon.quickcast.entity.Count_WorkPlace;

//此类为统计数据专用

@Repository
public class CountDAO {
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	
	//统计用户数
	public Count_User queryBycountUserId(int id){
		
		return hibernateTemplate.get(Count_User.class, id);
		
	}
	
	//统计简历处理率
	public Count_Rsmhandle queryByCountRsmhandleEtpId(int etp_id){
		Count_Rsmhandle count_rsmhandle = null;
		String hql = "FROM Count_Rsmhandle as count_rsmhandle WHERE count_rsmhandle.etp_id=?";
		List l = hibernateTemplate.find(hql,etp_id);
		Iterator iter = l.iterator();
		if(iter.hasNext()){
			count_rsmhandle = (Count_Rsmhandle)iter.next();	
		}	
		return count_rsmhandle;
	}
	
	public Count_WorkPlace queryByCountWorkPlaceId(int id){
		
		return hibernateTemplate.get(Count_WorkPlace.class, id);
		
	}
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	

}
