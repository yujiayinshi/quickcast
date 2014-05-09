package com.paragon.quickcast.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.paragon.quickcast.entity.News;

@Service
public interface NewsService {
	
	public boolean insert(News news);
	
	public void update(News news);
	
	public List queryByPubId(int pub_id);
	
	public News queryByNewsId(int news_id);
	
	public void delete(News news);
	
	public void deleteByPubId(int pub_id);
	
	public void deleteByNewsId(int news_id);
	
	public List queryAll();

}
