package com.paragon.quickcast.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paragon.quickcast.entity.Count_Rsmhandle;
import com.paragon.quickcast.entity.Count_User;
import com.paragon.quickcast.entity.Count_WorkPlace;
import com.paragon.quickcast.entity.Rsm_Deliver;
import com.paragon.quickcast.service.CountService;

@Controller
@RequestMapping("/count.do")
public class CountController {
	
	@Resource
	private CountService countservice;
	@Resource
    private Encoding encoding;
	
	//统计每类用户的人数
	//1 求职者
	//2 猎头
	//3 企业
	//4 未选类别
	@RequestMapping(params="method=imp_count_queryByCountUserId")
	public @ResponseBody String imp_count_queryByCountUserId(){
		
		Count_User count_user = countservice.queryBycountUserId(1);
		int[] count = new int[4];
		count[0] = count_user.getSeeker_num();
		count[1] = count_user.getHunter_num();
		count[2] = count_user.getEtp_num();
		count[3] = count_user.getUser_num();
		count[3] = count[3]-count[2]-count[1]-count[0];
		for(int i = 0;i < 4;i++){
			System.out.println(count[i]);
		}
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		data.put("seeker_num", count[0]);
		data.put("hunter_num", count[1]);
		data.put("etp_num", count[2]);
		data.put("other_num", count[3]);
		json_result.put(data);
		
		String result = "{\"count\":"+ json_result +"}";
		String result_temp = encoding.encoding(result);		
		return result_temp;	
	}
	
	@RequestMapping(params="method=imp_count_queryByCountRsmhandleEtpId")
	public @ResponseBody String imp_count_queryByCountRsmhandleEtpId(Rsm_Deliver rsm_deliver){
		
		Count_Rsmhandle count_rsmhandle = countservice.queryByCountRsmhandleEtpId(rsm_deliver.getEtp_id());
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		data.put("handle_num",count_rsmhandle.getHandle_num());
		data.put("receive_num", count_rsmhandle.getReceive_num());
		json_result.put(data);
		
		String result = "{\"count\":"+ json_result +"}";
		String result_temp = encoding.encoding(result);		
		return result_temp;	
	}
	
	
	@RequestMapping(params="method=imp_count_queryByCountWorkPlaceId")
	public @ResponseBody String imp_count_queryByCountWorkPlaceId(){
		
		Count_WorkPlace count_workplace = countservice.queryByCountWorkPlaceId(1);
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		data.put("anhui_num",count_workplace.getAnhui_num());
		data.put("beijing_num", count_workplace.getBeijing_num());
		data.put("chongqing_num", count_workplace.getChongqing_num());
		data.put("fujian_num", count_workplace.getFujian_num());
		data.put("gansu_num", count_workplace.getGansu_num());
		data.put("guangdong_num", count_workplace.getGuangdong_num());
		data.put("guangxi_num", count_workplace.getGuangxi_num());
		data.put("guizhou_num", count_workplace.getGuizhou_num());
		data.put("hainan_num", count_workplace.getHainan_num());
		data.put("hebei_num", count_workplace.getHebei_num());
		data.put("heilongjiang_num", count_workplace.getHeilongjiang_num());
		data.put("henan_num", count_workplace.getHenan_num());
		data.put("hubei_num", count_workplace.getHubei_num());
		data.put("hunan_num", count_workplace.getHunan_num());
		data.put("jiangsu_num", count_workplace.getJiangsu_num());
		data.put("jiangxi_num", count_workplace.getJiangxi_num());
		data.put("jilin_num", count_workplace.getJilin_num());
		data.put("liaoning_num", count_workplace.getLiaoning_num());
		data.put("neimenggu_num", count_workplace.getNeimenggu_num());
		data.put("ningxia_num", count_workplace.getNingxia_num());
		data.put("qinghai_num", count_workplace.getQinghai_num());
		data.put("shan_num", count_workplace.getShan_num());
		data.put("shandong_num", count_workplace.getShandong_num());
		data.put("shanghai_num", count_workplace.getShanghai_num());
		data.put("shanxi_num", count_workplace.getShanxi_num());
		data.put("sichuan_num", count_workplace.getSichuan_num());
		data.put("tianjin_num", count_workplace.getTianjin_num());
		data.put("xinjiang_num", count_workplace.getXinjiang_num());
		data.put("xizang_num", count_workplace.getXizang_num());
		data.put("yunnan_num", count_workplace.getYunnan_num());
		data.put("zhejiang_num", count_workplace.getZhejiang_num());
		json_result.put(data);
		
		String result = "{\"count\":"+ json_result +"}";
		String result_temp = encoding.encoding(result);		
		return result_temp;	
	}

	public Encoding getEncoding() {
		return encoding;
	}

	public void setEncoding(Encoding encoding) {
		this.encoding = encoding;
	}

	public CountService getCountservice() {
		return countservice;
	}

	public void setCountservice(CountService countservice) {
		this.countservice = countservice;
	}

}
