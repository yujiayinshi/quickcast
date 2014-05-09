package com.paragon.quickcast.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.paragon.quickcast.entity.Friend_List;
import com.paragon.quickcast.entity.FriendsGroup;

@Repository
public class Friend_ListDAO{
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@Resource
	private User_RegDAO user_regdao;
	
	@Resource
	private FriendsGroupDAO friendsgroupdao;

    //全局变量 Array记录HashMap中的前20大元素个数和好友的ID
	int[] hash_list = new int[20];
	Friend_List getfriend_list[] = new Friend_List[5];
	//插入用户新注册信息；
	//以Friend_List类为传递参数；
	public boolean insert(Friend_List friend_list){
		FriendsGroup friendsgroup = new FriendsGroup();
		//User_Reg user_reg = null;
		String Tempgrouptype = user_regdao.queryByUserId(friend_list.getPartner_id()).getUser_type();
		System.out.println("----"+Tempgrouptype+"------");
		friendsgroup.setGrouptype(Tempgrouptype);
		hibernateTemplate.save(friendsgroup);
		friend_list.setFriendsgroup(friendsgroup);	
		hibernateTemplate.save(friend_list);
		
		//List<Friend_List> friendl = (List)friendsgroupdao.findFriendsGroup(Tempgrouptype);
		return true;
		
	}
	
	
	public void update(Friend_List friend_list){
		Object[] args = {friend_list.getSelf_id(),friend_list.getPartner_id()};
		String hql = "FROM Friend_List as friend_list WHERE friend_list.partner_id=? AND friend_list.self_id=?";
		List l = hibernateTemplate.find(hql,args);
		Iterator iter = l.iterator();
		if(iter.hasNext()){
			Friend_List list = (Friend_List)iter.next();
		    list.setStatus("2");
		    hibernateTemplate.update(list);
		    Friend_List friend_list2 = new Friend_List();
		    friend_list2.setPartner_id(list.getSelf_id());
		    friend_list2.setSelf_id(list.getPartner_id());
		    friend_list2.setReason(list.getReason());
		    friend_list2.setStatus(list.getStatus());
		    FriendsGroup friendsgroup = new FriendsGroup();
			String Tempgrouptype = user_regdao.queryByUserId(friend_list.getPartner_id()).getUser_type();
			friendsgroup.setGrouptype(Tempgrouptype);
			hibernateTemplate.save(friendsgroup);
			friend_list2.setFriendsgroup(friendsgroup);	
		    hibernateTemplate.save(friend_list2);
		}
	}
	
	
	public List queryByPartnerId(int partner_id){
		
		String hql = "FROM Friend_List as friend_list WHERE friend_list.partner_id=?";
		List l = hibernateTemplate.find(hql, partner_id);
		return l;
		
	}
	
	
	public List queryBySelfId(int self_id){
			
		String hql = "FROM Friend_List as friend_list WHERE friend_list.self_id=?";
		List l = hibernateTemplate.find(hql, self_id);
		return l;
			
	}
		
	public Friend_List queryByRltsId(int rlts_id){
			
		return hibernateTemplate.get(Friend_List.class, rlts_id);
			
	}
		
		
	public void delete(int rlts_id){
			
		hibernateTemplate.delete(hibernateTemplate.get(Friend_List.class, rlts_id));
			
	}
		
	public void deleteByPartnerId(int partner_id){
			
		String hql = "FROM Friend_List WHERE partner_id=?";
		List l = hibernateTemplate.find(hql, partner_id);
		hibernateTemplate.deleteAll(l);
			
	}
		
	public void deleteBySelfId(int self_id,int partner_id){
		Object[] args = {self_id,partner_id};
		String hql1 = "FROM Friend_List as friend_list WHERE friend_list.self_id=? AND friend_list.partner_id=?";
		List list1 = hibernateTemplate.find(hql1,args);
		String hql2 = "FROM Friend_List as friend_list WHERE friend_list.partner_id=? AND friend_list.self_id=?";
		List list2 = hibernateTemplate.find(hql2,args);
		hibernateTemplate.deleteAll(list1);
		hibernateTemplate.deleteAll(list2);
	}
	
	/********
	 * 
	 * 以下是hash_map实现过程
	 * 1.根据self_id查找partner_id，返回值是partner_id
	 * 
	 * 
	 * *********/
	public List queryBySelf_ReturnParID(int self_id){
		String hql = "Select partner_id FROM Friend_List  as friend_list WHERE friend_list.self_id=?";
		List l = hibernateTemplate.find(hql, self_id);
		return l;
		
	}
	public List queryBySelf_ReturnPar_PartID(int partner_id){
		List<Integer> LPartner_ID = (List)this.queryBySelf_ReturnParID(partner_id);
		Iterator iter = LPartner_ID.iterator();		
		List Temp_part1= new ArrayList();
		
		for(int i = 0 ; i < LPartner_ID.size() ; i ++){
			List Temp_part2 = this.queryBySelf_ReturnParID(LPartner_ID.get(i));
			for(int ii = 0 ; ii < Temp_part2.size(); ii ++){
				Temp_part1.add(Temp_part2.get(ii));
				System.out.println(Temp_part2.get(ii));
			}
		}
		return Temp_part1;
	}
	//按照对象的Rlts_id排序
	
		public HashMap hash_indexSelfID(int self_id){
		HashMap<Integer, Integer> friendscircle = new HashMap<Integer,Integer>();
		List<Integer> Lfriendlist = (List)this.queryBySelf_ReturnPar_PartID(self_id);
		List<Integer> Lfriend     = (List)this.queryBySelf_ReturnParID(self_id);
		Lfriend.add(self_id);
		Lfriendlist.removeAll(Lfriend);
		for(int i = 0; i < Lfriendlist.size() ; i++)
			System.out.println("-------------- " +Lfriendlist.get(i) +" -----------");
		Iterator iter = Lfriendlist.iterator();
		int count_list = 0;
		while(iter.hasNext()){
			Integer key = (Integer)iter.next();
			if(!friendscircle.containsKey(key)){
				friendscircle.put(key, 1);
				System.out.println("好友ID"+key);
			}
			else{
				Integer count_friends = friendscircle.get(key);
				++count_friends;
				friendscircle.put(key,count_friends);
			}
			//Iterator iter1 = friendscircle.values().iterator();
		}
		Set<Map.Entry<Integer,Integer>> set = friendscircle.entrySet();
		Iterator<Map.Entry<Integer, Integer>> iter1 = set.iterator();
		while( count_list < 5 && (count_list < set.size())){
			Map.Entry<Integer, Integer> entry = iter1.next();
			//setPartner_id得到的是间接好友的ID，setSelf_id得到的是共同好友的个数
			getfriend_list[count_list] = new Friend_List();
			getfriend_list[count_list].setRlts_id(entry.getValue());
			getfriend_list[count_list].setPartner_id(entry.getKey());
			++count_list;
		}
		int temp3 = count_list;
		while(temp3 < 5){
			getfriend_list[temp3] = new Friend_List();
			getfriend_list[temp3].setRlts_id(0);
			getfriend_list[temp3].setPartner_id(self_id);
			++temp3;
		}
		Arrays.sort(getfriend_list, new Friend_List());
		//for(int i = 0; i < 5&&(i<set.size()); i++){
		for(int i = 0; i < 5; i++){
			if(getfriend_list[i].getRlts_id() != 0){
				System.out.println("好友圈的间接好友的个数和好友ID");
				System.out.println(" "+getfriend_list[i].getRlts_id()+" ");
				System.out.println(" "+getfriend_list[i].getPartner_id()+" ");
			}
		}
		return friendscircle;
	}
		
		public Friend_List[] creat_arraysort(int self_id){
			Map temp_friendscircle = hash_indexSelfID(self_id);
			Iterator iter2 = temp_friendscircle.entrySet().iterator();
			int count_list2 = 0; 
			while(iter2.hasNext()){
			    Map.Entry entry = (Map.Entry)iter2.next();
			    ++count_list2;
			    Object key1 = entry.getKey();
			    Integer val = (Integer)entry.getValue();
			    if(count_list2 >= 5){
			    	/*if(hash_list[0] < val){
			    		hash_list[0] = val;
			    		Arrays.sort(hash_list);
			    	}*/
	 		    	if(getfriend_list[0].getRlts_id() < val){
			    		getfriend_list[0].setRlts_id(val);
			    		Arrays.sort(getfriend_list,new Friend_List());
			    	}
			    }
			}
			return getfriend_list;
		}
		
		public void maxFriendscount(HashMap tempfriend){
			
		}
		
		/*************************************/
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public User_RegDAO getUser_regdao() {
		return user_regdao;
	}


	public void setUser_regdao(User_RegDAO user_regdao) {
		this.user_regdao = user_regdao;
	}


	public FriendsGroupDAO getFriendsgroupdao() {
		return friendsgroupdao;
	}


	public void setFriendsgroupdao(FriendsGroupDAO friendsgroupdao) {
		this.friendsgroupdao = friendsgroupdao;
	}
}
