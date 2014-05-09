package com.paragon.quickcast.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.paragon.quickcast.entity.Edu_Exp;
import com.paragon.quickcast.entity.Prj_Exp;
import com.paragon.quickcast.entity.Work_Exp;

@Service
public interface ExpService {

	//Work_Exp(QueryBy与DeleteBy通用)
	public boolean insert(Work_Exp work_exp);
		
	public void update(Work_Exp work_exp);
		
	public Work_Exp queryByWorkexpId(int exp_id);
					
	public void delete(Work_Exp work_exp);
			

	
	//Edu_Exp
	public boolean insert(Edu_Exp edu_exp);
	
	public void update(Edu_Exp edu_exp);
	
	public Edu_Exp queryByEduexpId(int exp_id);
		
	public void delete(Edu_Exp edu_exp);
	
	//Prj_Exp
	public boolean insert(Prj_Exp prj_exp);
	
	public void update(Prj_Exp prj_exp);
	
	public Prj_Exp queryByPrjexpId(int exp_id);
	
	public void delete(Prj_Exp prj_exp);
		
	//通用
	public List queryByUserId(int user_id);
	
	public void deleteByUserId(int user_id);
	
	public void deleteByExpId(int exp_id);
}
