package com.paragon.quickcast.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paragon.quickcast.dao.Rsm_DeliverDAO;
import com.paragon.quickcast.entity.Rsm_Deliver;
import com.paragon.quickcast.service.DeliverService;

@Service
public class DeliverServiceImpl implements DeliverService {
	
	@Resource
	private Rsm_DeliverDAO rsm_deliverdao;

	
    public boolean insert(Rsm_Deliver rsm_deliver){
    	
    	return rsm_deliverdao.insert(rsm_deliver);
    	
    }
	
	public void update(Rsm_Deliver rsm_deliver){
		
		rsm_deliverdao.update(rsm_deliver);
		
	}
	
	public List queryByRsmId(int rsm_id){
		
		return rsm_deliverdao.queryByRsmId(rsm_id);
		
	}
	
	public List queryByEtpId(int etp_id){
		
		return rsm_deliverdao.queryByEtpId(etp_id);
		
	}
	
	public List queryByHunterId(int hunter_id){
		
		return rsm_deliverdao.queryByHunterId(hunter_id);
		
	}
	
	public Rsm_Deliver queryByDeliverId(int deliver_id){
		
		return rsm_deliverdao.queryByDeliverId(deliver_id);
		
	}
	
	public void delete(Rsm_Deliver rsm_deliver){
		
		rsm_deliverdao.delete(rsm_deliver);
		
	}
	
	public void deleteByRsmId(int rsm_id){
		
		rsm_deliverdao.deleteByRsmId(rsm_id);
		
	}
	
	public void deleteByDeliverId(int deliver_id){
		
		rsm_deliverdao.deleteByDeliverId(deliver_id);
		
	}

	public Rsm_DeliverDAO getRsm_deliverdao() {
		return rsm_deliverdao;
	}

	public void setRsm_deliverdao(Rsm_DeliverDAO rsm_deliverdao) {
		this.rsm_deliverdao = rsm_deliverdao;
	}


}
