package com.paragon.quickcast.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paragon.quickcast.dao.Personal_RsmDAO;
import com.paragon.quickcast.entity.Personal_Rsm;
import com.paragon.quickcast.service.ResumeService;

@Service
public class Personal_RsmServiceImpl implements ResumeService{
	
	@Resource
	private Personal_RsmDAO personal_rsmdao;
	
	
	public boolean insert(Personal_Rsm personal_rsm){
		
		personal_rsmdao.insert(personal_rsm);
		return true;
		
	}
	
	public void update(Personal_Rsm personal_rsm){
		
		personal_rsmdao.update(personal_rsm);
		
	}
	
	
    public Personal_Rsm queryByUserId(int user_id){
    	
    	return personal_rsmdao.queryByUserId(user_id);
    	
    }
	
	public Personal_Rsm queryByRsmId(int rsm_id){
		
		return personal_rsmdao.queryByRsmId(rsm_id);
		
	}
	
	public void delete(Personal_Rsm personal_rsm){
		
		personal_rsmdao.delete(personal_rsm);
		
	}
	
	public void deleteByUserId(int user_id){
		
		personal_rsmdao.deleteByUserId(user_id);
		
	}
	
	public void deleteByRsmId(int rsm_id){
		
		personal_rsmdao.deleteByRsmId(rsm_id);
		
	}


	public Personal_RsmDAO getPersonal_rsmdao() {
		
		return personal_rsmdao;
		
	}


	public void setPersonal_rsmdao(Personal_RsmDAO personal_rsmdao) {
		
		this.personal_rsmdao = personal_rsmdao;
		
	}
	



}