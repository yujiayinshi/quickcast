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

	//�����û���ע����Ϣ��
	//��Edu_Exp��Ϊ���ݲ�����
	public boolean insert(Edu_Exp edu_exp){
		
		hibernateTemplate.save(edu_exp);
		return true;
	}
	
	//�������ݿ����
	//��Edu_Exp��Ϊ���ݲ���
	public void update(Edu_Exp edu_exp){
		hibernateTemplate.update(edu_exp);
	}
	
	//�����û���Ϣ
	//���ݲ���ΪUser_ID
	//����User_ID�ҵ�Edu_Exp��ȫ����Ϣ��
	//����List
	public List queryByUserId(int user_id){
		
		String hql = "FROM Edu_Exp as edu_exp WHERE edu_exp.user_id=?";		
		List l = hibernateTemplate.find(hql, user_id);
		return l;
	}
	
	
	//������Ϣexp_id��ѯ��������
		public Edu_Exp queryByEduexpId(int exp_id){
			
			return hibernateTemplate.get(Edu_Exp.class, exp_id);
		}
		
		
		//ɾ���������������Ǵ������Ĳ�����Edu_Exp�࣬һ��ʹ������ĸ���User_IDִ��ɾ����
		public void delete(Edu_Exp edu_exp){
			
			hibernateTemplate.delete(edu_exp);
		}
		
		//����User_IDΪ������ɾ����������
		public void deleteByUserId(int user_id){
			
			String hql = "FROM Edu_Exp as edu_exp WHERE edu_exp.user_id=?";
			List l = hibernateTemplate.find(hql, user_id);
			hibernateTemplate.deleteAll(l);
		}
		
		public void deleteByExpId(int exp_id){
			
			hibernateTemplate.delete(hibernateTemplate.get(Edu_Exp.class, exp_id));
		}

}
