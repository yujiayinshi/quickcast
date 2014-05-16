package com.paragon.quickcast.dao;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.paragon.quickcast.entity.Edu_Exp;


@Repository
public class Edu_ExpDAO{
	// property constants
	@Resource
	private HibernateTemplate hibernateTemplate;

	public boolean insert(Edu_Exp edu_exp){
		
		hibernateTemplate.save(edu_exp);
		return true;
	}
	
	public void update(Edu_Exp edu_exp){
		hibernateTemplate.update(edu_exp);
	}
	

	public List queryByUserId(int user_id){
		
		String hql = "FROM Edu_Exp as edu_exp WHERE edu_exp.user_id=?";		
		List l = hibernateTemplate.find(hql, user_id);
		return l;
	}
	
	

		public Edu_Exp queryByEduexpId(int exp_id){
			
			return hibernateTemplate.get(Edu_Exp.class, exp_id);
		}
		
		
		public void delete(Edu_Exp edu_exp){
			
			hibernateTemplate.delete(edu_exp);
		}

		public void deleteByUserId(int user_id){
			
			String hql = "FROM Edu_Exp as edu_exp WHERE edu_exp.user_id=?";
			List l = hibernateTemplate.find(hql, user_id);
			hibernateTemplate.deleteAll(l);
		}
		
		public void deleteByExpId(int exp_id){
			
			hibernateTemplate.delete(hibernateTemplate.get(Edu_Exp.class, exp_id));
		}

}
