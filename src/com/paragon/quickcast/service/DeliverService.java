package com.paragon.quickcast.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.paragon.quickcast.entity.Rsm_Deliver;


@Service
public interface DeliverService {
	
	public boolean insert(Rsm_Deliver rsm_deliver);
	
	public void update(Rsm_Deliver rsm_deliver);
	
	public List queryByRsmId(int rsm_id);
	
	public List queryByEtpId(int etp_id);
	
	public List queryByHunterId(int hunter_id);
	
	public Rsm_Deliver queryByDeliverId(int deliver_id);
	
	public void delete(Rsm_Deliver rsm_deliver);
	
	public void deleteByRsmId(int rsm_id);
	
	public void deleteByDeliverId(int deliver_id);
	
	

}
