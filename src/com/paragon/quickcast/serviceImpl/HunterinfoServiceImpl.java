package com.paragon.quickcast.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paragon.quickcast.dao.Hunter_InfoDAO;
import com.paragon.quickcast.dao.User_RegDAO;
import com.paragon.quickcast.entity.Etp_Info;
import com.paragon.quickcast.entity.Hunter_Info;
import com.paragon.quickcast.entity.Seeker_Info;
import com.paragon.quickcast.service.InformationService;

@Service
public class HunterinfoServiceImpl implements InformationService {

	@Resource
	private Hunter_InfoDAO hunter_infodao;
	@Resource
	private User_RegDAO user_reg;
	
	//Seeker_Info
	public boolean insert(Seeker_Info seeker_info) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Seeker_Info seeker_info) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Seeker_Info seeker_info) {
		// TODO Auto-generated method stub
		return false;
	}

	public Seeker_Info queryBySeekerInfoId(int info_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Seeker_Info queryBySeekerUserId(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	//Hunter_InfoImpl
	public boolean insert(Hunter_Info hunter_info) {
		hunter_infodao.insert(hunter_info);
		user_reg.update_type(hunter_info.getUser_id(), "2");
		return true;
	}

	public boolean update(Hunter_Info hunter_info) {
		hunter_infodao.update(hunter_info);
		return true;
	}

	public boolean delete(Hunter_Info hunter_info) {
		hunter_infodao.delete(hunter_info);
		return true;
	}

	public Hunter_Info queryByHunterInfoId(int info_id) {
		return hunter_infodao.queryByHunterInfoId(info_id);
	}

	public Hunter_Info queryByHunterUserId(int user_id) {
		return hunter_infodao.queryByHunterUserId(user_id);
	}

	
	//Etp_Info
	public boolean insert(Etp_Info etp_info) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Etp_Info etp_info) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Etp_Info etp_info) {
		// TODO Auto-generated method stub
		return false;
	}

	public Etp_Info queryByEtpInfoId(int info_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Etp_Info queryByEtpUserId(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	//Õ®”√
	public void deleteByUserId(int user_id) {
		hunter_infodao.deleteByUserId(user_id);
	}

	public void deleteByInfoId(int info_id) {
		hunter_infodao.deleteByInfoId(info_id);
	}

	public Hunter_InfoDAO getHunter_infodao() {
		return hunter_infodao;
	}

	public void setHunter_infodao(Hunter_InfoDAO hunter_infodao) {
		this.hunter_infodao = hunter_infodao;
	}

	public User_RegDAO getUser_reg() {
		return user_reg;
	}

	public void setUser_reg(User_RegDAO user_reg) {
		this.user_reg = user_reg;
	}

}
