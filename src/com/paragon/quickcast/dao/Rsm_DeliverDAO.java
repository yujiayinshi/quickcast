package com.paragon.quickcast.dao;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.paragon.quickcast.entity.Rsm_Deliver;


@Repository
public class Rsm_DeliverDAO{
	// property constants
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	//插入用户新注册信息；
	//以Rsm_Deliver类为传递参数；
	public boolean insert(Rsm_Deliver rsm_deliver){
		
		hibernateTemplate.save(rsm_deliver);
		return true;
	}
	
	//更新数据库操作
	//以Rsm_Deliver类为传递参数
	public void update(Rsm_Deliver rsm_deliver){
			
		hibernateTemplate.update(rsm_deliver);
	}
	
	//查找投递信息
	//传递参数为rsm_id
	//根据rsm_id找到Rsm_Deliver的全部信息；
	//返回List
	public List queryByRsmId(int rsm_id){
		
		String hql = "FROM Rsm_Deliver as rsm_deliver WHERE rsm_deliver.rsm_id=?";
		List l = hibernateTemplate.find(hql,rsm_id);	 
		return l;
	}
	
	//查找投递信息
		//传递参数为etp_id
		//根据etp_id找到Rsm_Deliver的全部信息；
		//返回List
		public List queryByEtpId(int etp_id){
			

			String hql = "FROM Rsm_Deliver as rsm_deliver WHERE rsm_deliver.etp_id=?";
			List l = hibernateTemplate.find(hql,etp_id);	 
			return l;
		}
	
		//查找投递信息
		//传递参数为hunter_id
		//根据hunter_id找到Rsm_Deliver的全部信息；
		//返回List
		public List queryByHunterId(int hunter_id){
			
			String hql = "FROM Rsm_Deliver as rsm_deliver WHERE rsm_deliver.hunter_id=?";
			List l = hibernateTemplate.find(hql,hunter_id);			
			return l;
		}
		
	    //根据信息deliver_id查询投递信息
		//使用此种方法是第二个参数必须是主键
		public Rsm_Deliver queryByDeliverId(int deliver_id){
			
			return hibernateTemplate.get(Rsm_Deliver.class, deliver_id);
		}
		 
		
		//删除简历投递信息，但是传进来的参数是Rsm_Deliver类
		public void delete(Rsm_Deliver rsm_deliver){
			
			hibernateTemplate.delete(rsm_deliver);
		}
		
		//根据rsm_id为参数，删除简历投递信息
		public void deleteByRsmId(int rsm_id){
			
			String hql = "FROM Rsm_Deliver as rsm_deliver WHERE rsm_id=?";
			List l = hibernateTemplate.find(hql,rsm_id);	 
			hibernateTemplate.deleteAll(l);
			
		}
		
		public void deleteByDeliverId(int deliver_id){
			
			hibernateTemplate.delete(hibernateTemplate.get(Rsm_Deliver.class, deliver_id));
		}

		public HibernateTemplate getHibernateTemplate() {
			return hibernateTemplate;
		}

		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}

}
