package com.paragon.quickcast.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paragon.quickcast.dao.Recruit_InfoDAO;
import com.paragon.quickcast.entity.Recruit_Info;
import com.paragon.quickcast.service.RecruitService;

@Service
public class RecruitinfoServiceImpl implements RecruitService {

	@Resource
	private Recruit_InfoDAO recruit_infodao;
	public boolean delete(int info_id) {
		recruit_infodao.delete(info_id);
		return false;
	}

	public boolean insert(Recruit_Info recruit_info) {
		recruit_infodao.insert(recruit_info);
		return false;
	}

	public Recruit_Info queryByInfoId(int info_id) {
		return recruit_infodao.queryByInfoId(info_id);
		
	}

	public boolean update(Recruit_Info recruit_info) {
	    recruit_infodao.update(recruit_info);
		return false;
	}
	
	public List queryByUserId(int user_id){
		
		return recruit_infodao.queryByUserId(user_id);
		
	}
	
	public List queryAll(){
		
		return recruit_infodao.queryAll();
		
	}

}
