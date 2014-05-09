package com.paragon.quickcast.serviceImpl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paragon.quickcast.dao.NewsDAO;
import com.paragon.quickcast.entity.News;
import com.paragon.quickcast.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService{
	
	@Resource
	private NewsDAO newsdao;
	
    public boolean insert(News news){
    	
    	return newsdao.insert(news);
    	
    }
	
	public void update(News news){
		
		newsdao.update(news);
		
	}
	
    public List queryByPubId(int pub_id){
    	
    	return newsdao.queryByPubId(pub_id);
    	
    }
    
    public List queryAll(){
    	return newsdao.queryAll();
    }
	
	public News queryByNewsId(int news_id){
		
		return newsdao.queryByNewsId(news_id);
		
	}
	
	public void delete(News news){
		
		newsdao.delete(news);
		
	}
	
	public void deleteByPubId(int pub_id){
		
		newsdao.deleteByPubId(pub_id);
		
	}
	
	public void deleteByNewsId(int news_id){
		
		newsdao.deleteByNewsId(news_id);
		
	}

	public NewsDAO getNewsdao() {
		return newsdao;
	}

	public void setNewsdao(NewsDAO newsdao) {
		this.newsdao = newsdao;
	}
	

}
