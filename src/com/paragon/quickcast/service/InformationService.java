package com.paragon.quickcast.service;


import org.springframework.stereotype.Service;

import com.paragon.quickcast.entity.Etp_Info;
import com.paragon.quickcast.entity.Hunter_Info;
import com.paragon.quickcast.entity.Seeker_Info;

@Service
public interface InformationService {
 
	//Seeker_Info
	public boolean insert(Seeker_Info seeker_info);
	
    public boolean update(Seeker_Info seeker_info);
    
    public boolean delete(Seeker_Info seeker_info);
    
	public Seeker_Info queryBySeekerInfoId(int info_id);
	
	public Seeker_Info queryBySeekerUserId(int user_id);
	
	//Hunter_Info
	public boolean insert(Hunter_Info hunter_info);

    public boolean update(Hunter_Info hunter_info);
     
    public boolean delete(Hunter_Info hunter_info);
     
    public Hunter_Info queryByHunterInfoId(int info_id);
     
    public Hunter_Info queryByHunterUserId(int user_id);

    //Etp_Info
    public boolean insert(Etp_Info etp_info);
    
	public boolean update(Etp_Info etp_info);
	
	public boolean delete(Etp_Info etp_info);
	
	public Etp_Info queryByEtpInfoId(int info_id);
	
	public Etp_Info queryByEtpUserId(int user_id);
	
	//Õ®”√
	public void deleteByUserId(int user_id);
		
	public void deleteByInfoId(int info_id);
}
