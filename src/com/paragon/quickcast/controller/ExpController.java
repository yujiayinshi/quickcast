package com.paragon.quickcast.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.paragon.quickcast.dao.ToJson;
import com.paragon.quickcast.entity.Edu_Exp;
import com.paragon.quickcast.entity.Prj_Exp;
import com.paragon.quickcast.entity.Work_Exp;
import com.paragon.quickcast.serviceImpl.EduexpServiceImpl;
import com.paragon.quickcast.serviceImpl.PrjexpServiceImpl;
import com.paragon.quickcast.serviceImpl.WorkexpServiceImpl;

@Controller
@RequestMapping("/exp.do")
public class ExpController extends MultiActionController{
	
	@Resource
	private WorkexpServiceImpl workexpimpl = new WorkexpServiceImpl();
	@Resource
	private EduexpServiceImpl eduexpimpl = new EduexpServiceImpl();
	@Resource
	private PrjexpServiceImpl prjexpimpl = new PrjexpServiceImpl();
	@Resource
	private Encoding encoding;


	//Work_Exp 工作经历
	@RequestMapping(params="method=workexp_insert")
	public @ResponseBody String workexp_insert(@RequestBody Work_Exp[] work_exp){
		
		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {	
			workexpimpl.deleteByUserId(work_exp[0].getUser_id());
			for(int i=0;i < work_exp.length;i++){
				
					workexpimpl.insert(work_exp[i]);
					
			}
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			temp = "fail";
			String result_temp = tojosn.tojson(temp);
			result_temp = encoding.encoding(result_temp);			
			e.printStackTrace();			
			e.printStackTrace();
			return result_temp;
		}
		String result_temp = tojosn.tojson(temp);
		result_temp = encoding.encoding(result_temp);							
		return result_temp;		

	}
	
	//工作经历更新
	@RequestMapping(params="method=workexp_update")
	public @ResponseBody String workexp_update(@RequestBody Work_Exp work_exp){
		 
		 String temp = "success";
			ToJson tojosn = new ToJson();	
			try {
				workexpimpl.update(work_exp);
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				temp = "fail";
				String result_temp = tojosn.tojson(temp);
				result_temp = encoding.encoding(result_temp);			
				e.printStackTrace();			
				e.printStackTrace();
				return result_temp;
			}
			String result_temp = tojosn.tojson(temp);
			result_temp = encoding.encoding(result_temp);
									
			return result_temp;	
	}
	
	//根据工作经历ID查找工作经历
	@RequestMapping(params="method=queryByWorkexpId")
	public @ResponseBody String queryByWorkexpId(int exp_id){
		 Work_Exp work_exp = workexpimpl.queryByWorkexpId(exp_id);
	     return "queryByWorkexpId OK";
	    }
	
	
	//删除工作经历
	@RequestMapping(params="method=workexp_delete")
	public @ResponseBody String workexp_delete(Work_Exp work_exp){
		 workexpimpl.delete(work_exp);
	     return "workexp_delete OK";
	    }
	
	//根据求职者ID查找工作经历
	@RequestMapping(params="method=queryByWorkuserId")
	public @ResponseBody String queryByWorkuserId(@RequestBody Work_Exp work_exp){
		 List list = workexpimpl.queryByUserId(work_exp.getUser_id());
		 Iterator iter = list.iterator();
		 Map data = new HashMap();
		 JSONArray json_result = new JSONArray();
		 for(int i = 0;i < list.size();i++){
			 Work_Exp work_expIns = (Work_Exp)iter.next();
			 data.put("user_id", work_expIns.getUser_id());
			 data.put("exp_id", work_expIns.getExp_id());
			 data.put("work_place", work_expIns.getWork_place());
			 data.put("end_time", work_expIns.getEnd_time());
			 data.put("etp_desc", work_expIns.getEtp_desc());
			 data.put("etp_industry", work_expIns.getEtp_industry());
			 data.put("etp_name", work_expIns.getEtp_name());
			 data.put("etp_nature", work_expIns.getEtp_nature());
			 data.put("etp_size", work_expIns.getEtp_size());
			 data.put("profession", work_expIns.getProfession());
			 data.put("start_time", work_expIns.getStart_time());
			 data.put("work_duty", work_expIns.getWork_duty());
			 json_result.put(data); 
		 }
		    	
			String result = "{\"work_exp\":"+ json_result + "}";
			String result_temp = "error";
			result_temp = encoding.encoding(result);						
			return result_temp;	
	    }
	 
	//根据求职者ID删除工作经历
	@RequestMapping(params="method=deleteByWorkuserId")
	public @ResponseBody String deleteByWorkuserId(@RequestBody Work_Exp work_exp){
		 
		 String temp = "success";
			ToJson tojosn = new ToJson();	
			try {
				workexpimpl.deleteByUserId(work_exp.getUser_id()); 
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				temp = "fail";
				String result_temp = tojosn.tojson(temp);
				result_temp = encoding.encoding(result_temp);			
				e.printStackTrace();			
				e.printStackTrace();
				return result_temp;
			}
			String result_temp = tojosn.tojson(temp);
			result_temp = encoding.encoding(result_temp);
									
			return result_temp;	
	    }
	
	//根据工作经历ID删除工作经历
	@RequestMapping(params="method=deleteByWorkexpId")
	public @ResponseBody String deleteByWorkexpId(int exp_id){
		 workexpimpl.deleteByExpId(exp_id);
	     return "deleteByWorkexpId OK";
	    }
	
	//创建教育经历
	@RequestMapping(params="method=eduexp_insert")
	public @ResponseBody String eduexp_insert(@RequestBody Edu_Exp[] edu_exp){
		
		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {	
			eduexpimpl.deleteByUserId(edu_exp[0].getUser_id());
			for(int i=0;i < edu_exp.length;i++){
				
				eduexpimpl.insert(edu_exp[i]);
					
			}
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			temp = "fail";
			String result_temp = tojosn.tojson(temp);
			result_temp = encoding.encoding(result_temp);			
			e.printStackTrace();			
			e.printStackTrace();
			return result_temp;
		}
		String result_temp = tojosn.tojson(temp);
		result_temp = encoding.encoding(result_temp);							
		return result_temp;	
	}

	
	@RequestMapping(params="method=queryByEduexpId")
    public @ResponseBody String queryByEduexpId(int exp_id){
		Edu_Exp edu_exp = eduexpimpl.queryByEduexpId(exp_id);
		System.out.println("-----------eduexp_id:"+edu_exp.getExp_id()+"---------");
		System.out.println("-----------user_id:"+edu_exp.getUser_id()+"---------");
		return "queryByEduexpId OK";
    }
	
	@RequestMapping(params="method=eduexp_delete")
	public @ResponseBody String eduexp_delete(Edu_Exp edu_exp){
		eduexpimpl.delete(edu_exp);
	    return "eduexp_delete OK";
	}
	
	@RequestMapping(params="method=queryByEduuserId")
	public @ResponseBody String queryByEduuserId(@RequestBody Edu_Exp edu_exp){
		 List list = eduexpimpl.queryByUserId(edu_exp.getUser_id());
		 Iterator iter = list.iterator();
		 Map data = new HashMap();
		 JSONArray json_result = new JSONArray();
		 for(int i = 0;i < list.size();i++){
			 Edu_Exp edu_expIns = (Edu_Exp)iter.next();
			 data.put("user_id", edu_expIns.getUser_id());
			 data.put("exp_id", edu_expIns.getExp_id());
			 data.put("edu_bg", edu_expIns.getEdu_bg());
			 data.put("edu_desc", edu_expIns.getEdu_desc());
			 data.put("major", edu_expIns.getMajor());
			 data.put("school_name", edu_expIns.getSchool_name());
			 data.put("study_end_time", edu_expIns.getStudy_end_time());
			 data.put("study_start_time", edu_expIns.getStudy_start_time());
			 json_result.put(data); 
		 }	    	
			String result = "{\"edu_exp\":"+ json_result + "}";
			String result_temp = "error";
			result_temp = encoding.encoding(result);						
			return result_temp;	
	    }
	 
	@RequestMapping(params="method=deleteByEduuserId")
	public @ResponseBody String deleteByEduuserId(@RequestBody Edu_Exp edu_exp){
		 
		 String temp = "success";
			ToJson tojosn = new ToJson();	
			try {
				eduexpimpl.deleteByUserId(edu_exp.getUser_id());
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				temp = "fail";
				String result_temp = tojosn.tojson(temp);
				result_temp = encoding.encoding(result_temp);			
				e.printStackTrace();			
				e.printStackTrace();
				return result_temp;
			}
			String result_temp = tojosn.tojson(temp);
			result_temp = encoding.encoding(result_temp);							
			return result_temp;	
	    }
	
	@RequestMapping(params="method=deleteByEduexpId")
	public @ResponseBody String deleteByEduexpId(int exp_id){
		 eduexpimpl.deleteByExpId(exp_id);
	     return "deleteByEduexpId OK";
	    }
	
	//Prj_Exp
	@RequestMapping(params="method=prjexp_insert")
	public @ResponseBody String prjexp_insert(@RequestBody Prj_Exp[] prj_exp){
		
		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			prjexpimpl.deleteByUserId(prj_exp[0].getUser_id());
			for(int i=0;i < prj_exp.length;i++){
				
				prjexpimpl.insert(prj_exp[i]);
					
			}
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			temp = "fail";
			String result_temp = tojosn.tojson(temp);
			result_temp = encoding.encoding(result_temp);			
			e.printStackTrace();			
			e.printStackTrace();
			return result_temp;
		}
		String result_temp = tojosn.tojson(temp);
		result_temp = encoding.encoding(result_temp);							
		return result_temp;	
	}
	
	
	@RequestMapping(params="method=queryByPrjexpId")
    public @ResponseBody String queryByPrjexpId(int exp_id){
		Prj_Exp prj_exp = prjexpimpl.queryByPrjexpId(exp_id);
		System.out.println("-----------prjexp_id:"+prj_exp.getExp_id()+"---------");
		System.out.println("-----------user_id:"+prj_exp.getUser_id()+"---------");
		return "queryByPrjexpId OK";
    }
	
	@RequestMapping(params="method=prjexp_delete")
	public @ResponseBody String prjexp_delete(Prj_Exp prj_exp){
		prjexpimpl.delete(prj_exp);
	    return "prjexp_delete OK";
	}
	
	@RequestMapping(params="method=queryByPrjuserId")
	public @ResponseBody String queryByPrjuserId(@RequestBody Prj_Exp prj_exp){
		 List list = prjexpimpl.queryByUserId(prj_exp.getUser_id());
		 Iterator iter = list.iterator();
		 Map data = new HashMap();
		 JSONArray json_result = new JSONArray();
		 for(int i = 0;i < list.size();i++){
			 Prj_Exp prj_expIns = (Prj_Exp)iter.next();
			 data.put("user_id", prj_expIns.getUser_id());
			 data.put("exp_id", prj_expIns.getExp_id());
			 data.put("end_time", prj_expIns.getEnd_time());
			 data.put("etp_name", prj_expIns.getEtp_name());
			 data.put("prj_achievement", prj_expIns.getPrj_achievement());
			 data.put("prj_desc", prj_expIns.getPrj_desc());
			 data.put("prj_duty", prj_expIns.getPrj_duty());
			 data.put("start_time", prj_expIns.getStart_time());
			 data.put("prj_name", prj_expIns.getPrj_name());
			 data.put("prj_profession", prj_expIns.getPrj_profession());
			 json_result.put(data); 
		 }	    	
			String result = "{\"prj_exp\":"+ json_result + "}";
			String result_temp = "error";
			result_temp = encoding.encoding(result);						
			return result_temp;
	    }
	 
	@RequestMapping(params="method=deleteByPrjuserId")
	public @ResponseBody String deleteByPrjuserId(Prj_Exp prj_exp){
		 
		 prjexpimpl.update(prj_exp); 
			String temp = "success";
			ToJson tojosn = new ToJson();	
			try {
				prjexpimpl.deleteByUserId(prj_exp.getUser_id());

			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				temp = "fail";
				String result_temp = tojosn.tojson(temp);
				result_temp = encoding.encoding(result_temp);			
				e.printStackTrace();			
				e.printStackTrace();
				return result_temp;
			}
			String result_temp = tojosn.tojson(temp);
			result_temp = encoding.encoding(result_temp);							
			return result_temp;	
	    }
	
	@RequestMapping(params="method=deleteByPrjexpId")
	public @ResponseBody String deleteByPrjexpId(int exp_id){
		 prjexpimpl.deleteByExpId(exp_id);
	     return "deleteByPrjexpId OK";
	    }

	
	
	
	public WorkexpServiceImpl getWorkexpimpl() {
		return workexpimpl;
	}

	public void setWorkexpimpl(WorkexpServiceImpl workexpimpl) {
		this.workexpimpl = workexpimpl;
	}

	public EduexpServiceImpl getEduexpimpl() {
		return eduexpimpl;
	}

	public void setEduexpimpl(EduexpServiceImpl eduexpimpl) {
		this.eduexpimpl = eduexpimpl;
	}

	public PrjexpServiceImpl getPrjexpimpl() {
		return prjexpimpl;
	}

	public void setPrjexpimpl(PrjexpServiceImpl prjexpimpl) {
		this.prjexpimpl = prjexpimpl;
	}
	

	public Encoding getEncoding() {
		return encoding;
	}

	public void setEncoding(Encoding encoding) {
		this.encoding = encoding;
	}
	
}
