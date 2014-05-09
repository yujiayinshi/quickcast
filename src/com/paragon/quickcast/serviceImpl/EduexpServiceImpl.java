package com.paragon.quickcast.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paragon.quickcast.dao.Edu_ExpDAO;
import com.paragon.quickcast.entity.Edu_Exp;
import com.paragon.quickcast.entity.Prj_Exp;
import com.paragon.quickcast.entity.Work_Exp;
import com.paragon.quickcast.service.ExpService;

@Service
public class EduexpServiceImpl implements ExpService {
	@Resource
	private Edu_ExpDAO edu_expdao;
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

	//Edu_ExpImpl
	public boolean insert(Edu_Exp edu_exp) {
		edu_expdao.insert(edu_exp);
		return true;
	}

	public void update(Edu_Exp edu_exp) {
		edu_expdao.update(edu_exp);
	}

	public Edu_Exp queryByEduexpId(int exp_id) {
		return edu_expdao.queryByEduexpId(exp_id);
	}

	public void delete(Edu_Exp edu_exp) {
		edu_expdao.delete(edu_exp);
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
		return edu_expdao.queryByUserId(user_id);
	}

	public void deleteByUserId(int user_id) {
		edu_expdao.deleteByUserId(user_id);
	}

	public void deleteByExpId(int exp_id) {
		edu_expdao.deleteByExpId(exp_id);
	}

}
