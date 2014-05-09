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
	
	//�������ݿ����
	//��Work_Exp��Ϊ���ݲ���
	public void update(Work_Exp work_exp){
		
		hibernateTemplate.update(work_exp);
	}
	
	//�����û���Ϣ
	//���ݲ���ΪUser_ID
	//����User_ID�ҵ�Work_Exp��ȫ����Ϣ��
	//����List
	public List queryByUserId(int user_id){
		
		String hql = "FROM Work_Exp as work_exp WHERE work_exp.user_id=?";		
		List l = hibernateTemplate.find(hql, user_id);
		return l;
	}
	
	
	//������Ϣexp_id��ѯ��������
		public Work_Exp queryByWorkexpId(int exp_id){
			
			return hibernateTemplate.get(Work_Exp.class, exp_id);
		}
		
		
		//ɾ���������������Ǵ������Ĳ�����Work_Exp�࣬һ��ʹ������ĸ���User_IDִ��ɾ����
		public void delete(Work_Exp work_exp){
			
			hibernateTemplate.delete(work_exp);
		}
		
		//����User_IDΪ������ɾ����������
		public void deleteByUserId(int user_id){
			String hql = "FROM Work_Exp as work_exp WHERE work_exp.user_id=?";
			List l = hibernateTemplate.find(hql, user_id);
			hibernateTemplate.deleteAll(l);
		}
		
		public void deleteByExpId(int exp_id){
			
			hibernateTemplate.delete(hibernateTemplate.get(Work_Exp.class, exp_id));
		}

}
