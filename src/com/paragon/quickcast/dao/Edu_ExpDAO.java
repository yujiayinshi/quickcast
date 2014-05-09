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

	//插入用户新注册信息；
	//以Edu_Exp类为传递参数；
	public boolean insert(Edu_Exp edu_exp){
		
		hibernateTemplate.save(edu_exp);
		return true;
	}
	
	//更新数据库操作
	//以Edu_Exp类为传递参数
	public void update(Edu_Exp edu_exp){
		hibernateTemplate.update(edu_exp);
	}
	
	//查找用户信息
	//传递参数为User_ID
	//根据User_ID找到Edu_Exp的全部信息；
	//返回List
	public List queryByUserId(int user_id){
		
		String hql = "FROM Edu_Exp as edu_exp WHERE edu_exp.user_id=?";		
		List l = hibernateTemplate.find(hql, user_id);
		return l;
	}
	
	
	//根据信息exp_id查询教育经历
		public Edu_Exp queryByEduexpId(int exp_id){
			
			return hibernateTemplate.get(Edu_Exp.class, exp_id);
		}
		
		
		//删除教育经历，但是传进来的参数是Edu_Exp类，一般使用下面的根据User_ID执行删除；
		public void delete(Edu_Exp edu_exp){
			
			hibernateTemplate.delete(edu_exp);
		}
		
		//根据User_ID为参数，删除教育经历
		public void deleteByUserId(int user_id){
			
			String hql = "FROM Edu_Exp as edu_exp WHERE edu_exp.user_id=?";
			List l = hibernateTemplate.find(hql, user_id);
			hibernateTemplate.deleteAll(l);
		}
		
		public void deleteByExpId(int exp_id){
			
			hibernateTemplate.delete(hibernateTemplate.get(Edu_Exp.class, exp_id));
		}

}
