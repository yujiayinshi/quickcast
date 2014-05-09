package com.paragon.quickcast.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.paragon.quickcast.entity.News;


@Repository
public class NewsDAO{
	// property constants
	@Resource
	private HibernateTemplate hibernateTemplate;

	
	public boolean insert(News news){
		
			hibernateTemplate.save(news);
			return true;
		
	}
	
	
	public void update(News news){
			
		hibernateTemplate.update(news);
		
	}
	

	public List queryByPubId(int pub_id){
		String hql = "FROM News as news WHERE news.pub_id=? ";		
		List l = hibernateTemplate.find(hql, pub_id);
		return l;		
	}
	

	
	public News queryByNewsId(int news_id){
			
		return hibernateTemplate.get(News.class, news_id);
		
	}
		
	public List queryAll(){
		String hql = "FROM News as news order by news.pub_time";
		List l = hibernateTemplate.find(hql);
		return l;
	}
		
	public void delete(News news){
			
		hibernateTemplate.delete(news);
		
	}
		
	public void deleteByPubId(int pub_id){
			
		String hql = "FROM News WHERE pub_id=?";
		List l = hibernateTemplate.find(hql, pub_id);
		hibernateTemplate.deleteAll(l);
	}
	
	public void deleteByNewsId(int news_id){
		
		hibernateTemplate.delete(hibernateTemplate.get(News.class, news_id));
		
	}
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
