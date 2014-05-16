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
	

	public boolean insert(Rsm_Deliver rsm_deliver){
		
		hibernateTemplate.save(rsm_deliver);
		return true;
	}
	

	public void update(Rsm_Deliver rsm_deliver){
			
		hibernateTemplate.update(rsm_deliver);
	}
	

	public List queryByRsmId(int rsm_id){
		
		String hql = "FROM Rsm_Deliver as rsm_deliver WHERE rsm_deliver.rsm_id=?";
		List l = hibernateTemplate.find(hql,rsm_id);	 
		return l;
	}
	

		public List queryByEtpId(int etp_id){
			

			String hql = "FROM Rsm_Deliver as rsm_deliver WHERE rsm_deliver.etp_id=?";
			List l = hibernateTemplate.find(hql,etp_id);	 
			return l;
		}
	

		public List queryByHunterId(int hunter_id){
			
			String hql = "FROM Rsm_Deliver as rsm_deliver WHERE rsm_deliver.hunter_id=?";
			List l = hibernateTemplate.find(hql,hunter_id);			
			return l;
		}
		

		public Rsm_Deliver queryByDeliverId(int deliver_id){
			
			return hibernateTemplate.get(Rsm_Deliver.class, deliver_id);
		}
		 
		

		public void delete(Rsm_Deliver rsm_deliver){
			
			hibernateTemplate.delete(rsm_deliver);
		}
		

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
