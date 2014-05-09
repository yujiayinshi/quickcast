package com.paragon.quickcast.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paragon.quickcast.dao.Friend_ListDAO;
import com.paragon.quickcast.entity.Friend_List;
import com.paragon.quickcast.service.Friend_ListService;

@Service
public class Friend_ListServiceImpl implements Friend_ListService {

	@Resource
	private Friend_ListDAO friend_listdao;
	
	public boolean insert(Friend_List friend_list){
		
		friend_listdao.insert(friend_list);
		return true;
		
	}
	
	public void update(Friend_List friend_list){
		
		friend_listdao.update(friend_list);
		
	}
	
	public List queryByPartnerId(int partner_id){
		
		return friend_listdao.queryByPartnerId(partner_id);
		
	}
	
	public List queryBySelfId(int self_id){
		
		return friend_listdao.queryBySelfId(self_id);
		
	}
	
	public Friend_List queryByRltsId(int rlts_id){
		
		return friend_listdao.queryByRltsId(rlts_id);
		
	}
	
	
	public void delete(int rlts_id){
		
		friend_listdao.delete(rlts_id);
		
	}
	
	public void deleteByPartnerId(int partner_id){
		
		friend_listdao.deleteByPartnerId(partner_id);
		
	}
	
	public void deleteBySelfId(int self_id,int partner_id){
		
		friend_listdao.deleteBySelfId(self_id,partner_id);
		
	}

	public Friend_List[] creat_arraysort(int self_id){
		return friend_listdao.creat_arraysort(self_id);
	}
	
	public Friend_ListDAO getFriend_listdao() {
		return friend_listdao;
	}

	public void setFriend_listdao(Friend_ListDAO friend_listdao) {
		this.friend_listdao = friend_listdao;
	}
	


}
