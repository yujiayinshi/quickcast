package com.paragon.quickcast.service;

import org.springframework.stereotype.Service;

import com.paragon.quickcast.entity.Count_Rsmhandle;
import com.paragon.quickcast.entity.Count_User;
import com.paragon.quickcast.entity.Count_WorkPlace;

@Service
public interface CountService {
	
	public Count_User queryBycountUserId(int id);
	
	public Count_Rsmhandle queryByCountRsmhandleEtpId(int etp_id);
	
	public Count_WorkPlace queryByCountWorkPlaceId(int id);

}
