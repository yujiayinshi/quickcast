package com.paragon.quickcast.dao;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.paragon.quickcast.entity.Prj_Exp;


@Repository
public class Prj_ExpDAO{
	// property constants
	@Resource
	private HibernateTemplate hibernateTemplate;
	

	public boolean insert(Prj_Exp prj_exp){
		
		hibernateTemplate.save(prj_exp);
		return true;
	}
	

	public void update(Prj_Exp prj_exp){
		hibernateTemplate.update(prj_exp);
	}
	

	public List queryByUserId(int user_id){
		
		String hql = "FROM Prj_Exp as prj_exp WHERE prj_exp.user_id=?";		
		List l = hibernateTemplate.find(hql, user_id);
		return l;
	}
	
	

		public Prj_Exp queryByPrjexpId(int exp_id){
			
			return hibernateTemplate.get(Prj_Exp.class, exp_id);
		}
		
		

		public void delete(Prj_Exp prj_exp){
			
			hibernateTemplate.delete(prj_exp);
		}
		

		public void deleteByUserId(int user_id){
			
			String hql = "FROM Prj_Exp as prj_exp WHERE prj_exp.user_id=?";
			List l = hibernateTemplate.find(hql, user_id);
			hibernateTemplate.deleteAll(l);
		}
		
		public void deleteByExpId(int exp_id){
			
			hibernateTemplate.delete(hibernateTemplate.get(Prj_Exp.class, exp_id));
		}

}
