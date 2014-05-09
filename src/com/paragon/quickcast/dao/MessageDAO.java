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
	
	//插入用户新注册信息；
	//以Message类为传递参数；
	public boolean insert(Message message){
		
		hibernateTemplate.save(message);
		return true;
		
	}
	
	
	//更新数据库操作
	//以Message类为传递参数
	public void update(Message message){
			
		hibernateTemplate.update(message);
		
	}
	
	//查找站内信
	//传递参数为dispatch_id
	//根据dispatch_id找到Massage的全部信息；
	//返回List
	public List queryByDispatchId(int dispatch_id){
		
		String hql = "FROM Message as message WHERE message.dispatch_id=?";
		List l = hibernateTemplate.find(hql, dispatch_id);
		return l;
		
	}
	
	//查找站内信
	//传递参数为receive_id
	//根据receive_id找到Message的全部信息；
	//返回List
	public List queryByReceiveId(int receive_id){
			
		String hql = "FROM Message as message WHERE message.receive_id=?";
		List l = hibernateTemplate.find(hql, receive_id);
		return l;
		
	}
	
	
	//根据信息msg_id查询站内信
	public Message queryByMsgId(int msg_id){
			
		return hibernateTemplate.get(Message.class, msg_id);

	}
		
		
	//删除站内信，但是传进来的参数是Message类，
	public void delete(Message message){
			
		hibernateTemplate.delete(message);
		
	}
		
	//根据msg_id为参数，删除站内信
	public void deleteByMsgId(int msg_id){
			
		hibernateTemplate.delete(hibernateTemplate.get(Message.class, msg_id));
		
	}
	
	//根据dispatch_id为参数，删除站内信	
	public void deleteByDispatchId(int dispatch_id){
			
		String hql = "FROM Message WHERE dispatch_id=?";
		List l = hibernateTemplate.find(hql, dispatch_id);
		hibernateTemplate.deleteAll(l);
		
	}
	
	//根据dispatch_id为参数，删除站内信	
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
