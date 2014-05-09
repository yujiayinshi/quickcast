package com.paragon.quickcast.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paragon.quickcast.dao.Prj_ExpDAO;
import com.paragon.quickcast.entity.Edu_Exp;
import com.paragon.quickcast.entity.Prj_Exp;
import com.paragon.quickcast.entity.Work_Exp;
import com.paragon.quickcast.service.ExpService;

@Service
public class PrjexpServiceImpl implements ExpService {
	@Resource
	private Prj_ExpDAO prj_expdao;
	
	//Work_Exp
	public boolean insert(Work_Exp work_exp) {
		// TODO Auto-generated method stub
		return false;
	}

	public void update(Work_Exp work_exp) {
		// TODO Auto-generated method stub

	}

	public Work_Exp queryByWorkexpId(int exp_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Work_Exp work_exp) {
		// TODO Auto-generated method stub

	}

	//Edu_Edu
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

	//Prj_ExpImpl
	public boolean insert(Prj_Exp prj_exp) {
		prj_expdao.insert(prj_exp);
		return true;
	}

	public void update(Prj_Exp prj_exp) {
		prj_expdao.update(prj_exp);
	}

	public Prj_Exp queryByPrjexpId(int exp_id) {
		return prj_expdao.queryByPrjexpId(exp_id);
	}

	public void delete(Prj_Exp prj_exp) {
		prj_expdao.delete(prj_exp);
	}

	//Õ®”√
	public List queryByUserId(int user_id) {
		return prj_expdao.queryByUserId(user_id);
	}

	public void deleteByUserId(int user_id) {
		prj_expdao.deleteByUserId(user_id);
	}

	public void deleteByExpId(int exp_id) {
		prj_expdao.deleteByExpId(exp_id);
	}

}
