package com.paragon.quickcast.dao;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.paragon.quickcast.entity.Message;


@Repository
public class MessageDAO{
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	//�����û���ע����Ϣ��
	//��Message��Ϊ���ݲ�����
	public boolean insert(Message message){
		
		hibernateTemplate.save(message);
		return true;
		
	}
	
	
	//�������ݿ����
	//��Message��Ϊ���ݲ���
	public void update(Message message){
			
		hibernateTemplate.update(message);
		
	}
	
	//����վ����
	//���ݲ���Ϊdispatch_id
	//����dispatch_id�ҵ�Massage��ȫ����Ϣ��
	//����List
	public List queryByDispatchId(int dispatch_id){
		
		String hql = "FROM Message as message WHERE message.dispatch_id=?";
		List l = hibernateTemplate.find(hql, dispatch_id);
		return l;
		
	}
	
	//����վ����
	//���ݲ���Ϊreceive_id
	//����receive_id�ҵ�Message��ȫ����Ϣ��
	//����List
	public List queryByReceiveId(int receive_id){
			
		String hql = "FROM Message as message WHERE message.receive_id=?";
		List l = hibernateTemplate.find(hql, receive_id);
		return l;
		
	}
	
	
	//������Ϣmsg_id��ѯվ����
	public Message queryByMsgId(int msg_id){
			
		return hibernateTemplate.get(Message.class, msg_id);

	}
		
		
	//ɾ��վ���ţ����Ǵ������Ĳ�����Message�࣬
	public void delete(Message message){
			
		hibernateTemplate.delete(message);
		
	}
		
	//����msg_idΪ������ɾ��վ����
	public void deleteByMsgId(int msg_id){
			
		hibernateTemplate.delete(hibernateTemplate.get(Message.class, msg_id));
		
	}
	
	//����dispatch_idΪ������ɾ��վ����	
	public void deleteByDispatchId(int dispatch_id){
			
		String hql = "FROM Message WHERE dispatch_id=?";
		List l = hibernateTemplate.find(hql, dispatch_id);
		hibernateTemplate.deleteAll(l);
		
	}
	
	//����dispatch_idΪ������ɾ��վ����	
		public void deleteByReceiveId(int receive_id){
				

			String hql = "FROM Message WHERE receive_id=?";
			List l = hibernateTemplate.find(hql, receive_id);
			hibernateTemplate.deleteAll(l);
			
		}


		public HibernateTemplate getHibernateTemplate() {
			return hibernateTemplate;
		}


		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}
}
