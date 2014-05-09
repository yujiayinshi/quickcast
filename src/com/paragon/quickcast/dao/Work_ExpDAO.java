package com.paragon.quickcast.dao;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.paragon.quickcast.entity.Work_Exp;


@Repository
public class Work_ExpDAO{
	// property constants
	@Resource
	private HibernateTemplate hibernateTemplate;

	
	public boolean insert(Work_Exp work_exp){
		
		hibernateTemplate.save(work_exp);
		return true;
	}
	
	//更新数据库操作
	//以Work_Exp类为传递参数
	public void update(Work_Exp work_exp){
		
		hibernateTemplate.update(work_exp);
	}
	
	//查找用户信息
	//传递参数为User_ID
	//根据User_ID找到Work_Exp的全部信息；
	//返回List
	public List queryByUserId(int user_id){
		
		String hql = "FROM Work_Exp as work_exp WHERE work_exp.user_id=?";		
		List l = hibernateTemplate.find(hql, user_id);
		return l;
	}
	
	
	//根据信息exp_id查询工作经历
		public Work_Exp queryByWorkexpId(int exp_id){
			
			return hibernateTemplate.get(Work_Exp.class, exp_id);
		}
		
		
		//删除工作经历，但是传进来的参数是Work_Exp类，一般使用下面的根据User_ID执行删除；
		public void delete(Work_Exp work_exp){
			
			hibernateTemplate.delete(work_exp);
		}
		
		//根据User_ID为参数，删除工作经历
		public void deleteByUserId(int user_id){
			String hql = "FROM Work_Exp as work_exp WHERE work_exp.user_id=?";
			List l = hibernateTemplate.find(hql, user_id);
			hibernateTemplate.deleteAll(l);
		}
		
		public void deleteByExpId(int exp_id){
			
			hibernateTemplate.delete(hibernateTemplate.get(Work_Exp.class, exp_id));
		}

}
