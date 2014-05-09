package com.paragon.quickcast.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paragon.quickcast.dao.Work_ExpDAO;
import com.paragon.quickcast.entity.Edu_Exp;
import com.paragon.quickcast.entity.Prj_Exp;
import com.paragon.quickcast.entity.Work_Exp;
import com.paragon.quickcast.service.ExpService;

@Service
public class WorkexpServiceImpl implements ExpService {
	@Resource
	private Work_ExpDAO work_expdao;
	
	//Work_ExpImpl
	public boolean insert(Work_Exp work_exp) {
		work_expdao.insert(work_exp);
		return true;
	}

	public void update(Work_Exp work_exp) {
		work_expdao.update(work_exp);
	}

	public Work_Exp queryByWorkexpId(int exp_id) {
		return work_expdao.queryByWorkexpId(exp_id);
	}

	public void delete(Work_Exp work_exp) {
		work_expdao.delete(work_exp);
	}

	
	//Edu_Exp
	public boolean insert(Edu_Exp edu_exp) {
		// TODO Auto-generated method stub
		return false;
	}

	public void update(Edu_Exp edu_exp) {
		// TODO Auto-generated method stub

	}

	public Edu_Exp queryByEduexpId(int exp_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Edu_Exp edu_exp) {
		// TODO Auto-generated method stub

	}

	//Prj_Exp
	public boolean insert(Prj_Exp prj_exp) {
		// TODO Auto-generated method stub
		return false;
	}

	public void update(Prj_Exp prj_exp) {
		// TODO Auto-generated method stub

	}

	public Prj_Exp queryByPrjexpId(int exp_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Prj_Exp prj_exp) {
		// TODO Auto-generated method stub

	}

	//Õ®”√
	public List queryByUserId(int user_id) {
		return work_expdao.queryByUserId(user_id);
	}

	public void deleteByUserId(int user_id) {
		work_expdao.deleteByUserId(user_id);
	}

	public void deleteByExpId(int exp_id) {
		work_expdao.deleteByExpId(exp_id);
	}

}
