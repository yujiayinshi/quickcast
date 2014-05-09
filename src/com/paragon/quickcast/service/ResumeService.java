package com.paragon.quickcast.service;

import org.springframework.stereotype.Service;
import com.paragon.quickcast.entity.Personal_Rsm;

@Service
public interface ResumeService {
	
	public boolean insert(Personal_Rsm personal_rsm);
	
	public void update(Personal_Rsm personal_rsm);
	
	public Personal_Rsm queryByUserId(int user_id);
	
	public Personal_Rsm queryByRsmId(int rsm_id);
	
	public void delete(Personal_Rsm personal_rsm);
	
	public void deleteByUserId(int user_id);
	
	public void deleteByRsmId(int rsm_id);

}
