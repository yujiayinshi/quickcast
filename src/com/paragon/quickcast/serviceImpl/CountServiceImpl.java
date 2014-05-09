package com.paragon.quickcast.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paragon.quickcast.dao.CountDAO;
import com.paragon.quickcast.entity.Count_Rsmhandle;
import com.paragon.quickcast.entity.Count_User;
import com.paragon.quickcast.entity.Count_WorkPlace;
import com.paragon.quickcast.service.CountService;

@Service
public class CountServiceImpl implements CountService {
	
	@Resource
	private CountDAO countdao;

	public Count_User queryBycountUserId(int id) {
		
		return countdao.queryBycountUserId(id);
		
	}
	
	public Count_Rsmhandle queryByCountRsmhandleEtpId(int etp_id){
		
		return countdao.queryByCountRsmhandleEtpId(etp_id);
		
	}
	
	public Count_WorkPlace queryByCountWorkPlaceId(int id){
		
		return countdao.queryByCountWorkPlaceId(id);
		
	}

	public CountDAO getCountdao() {
		return countdao;
	}

	public void setCountdao(CountDAO countdao) {
		this.countdao = countdao;
	}

}
