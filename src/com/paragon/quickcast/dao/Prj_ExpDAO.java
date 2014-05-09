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
	
	//插入项目经历；
	//以Prj_Exp类为传递参数；
	public boolean insert(Prj_Exp prj_exp){
		
		hibernateTemplate.save(prj_exp);
		return true;
	}
	
	//更新数据库操作
	//以Prj_Exp类为传递参数
	public void update(Prj_Exp prj_exp){
		hibernateTemplate.update(prj_exp);
	}
	
	//查找用户信息
	//传递参数为User_ID
	//根据User_ID找到Prj_Exp的全部信息；
	//返回List
	public List queryByUserId(int user_id){
		
		String hql = "FROM Prj_Exp as prj_exp WHERE prj_exp.user_id=?";		
		List l = hibernateTemplate.find(hql, user_id);
		return l;
	}
	
	
	//根据信息exp_id查询项目经历
		public Prj_Exp queryByPrjexpId(int exp_id){
			
			return hibernateTemplate.get(Prj_Exp.class, exp_id);
		}
		
		
		//删除项目经历，但是传进来的参数是Edu_Exp类，一般使用下面的根据User_ID执行删除；
		public void delete(Prj_Exp prj_exp){
			
			hibernateTemplate.delete(prj_exp);
		}
		
		//根据User_ID为参数，删除项目经历
		public void deleteByUserId(int user_id){
			
			String hql = "FROM Prj_Exp as prj_exp WHERE prj_exp.user_id=?";
			List l = hibernateTemplate.find(hql, user_id);
			hibernateTemplate.deleteAll(l);
		}
		
		public void deleteByExpId(int exp_id){
			
			hibernateTemplate.delete(hibernateTemplate.get(Prj_Exp.class, exp_id));
		}

}
