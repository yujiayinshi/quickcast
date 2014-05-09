package com.paragon.quickcast.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.paragon.quickcast.entity.Personal_Rsm;


@Repository
public class Personal_RsmDAO{
	// property constants
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	
	//插入新的个人简历；
	//以Personal_Rsm类为传递参数；
	public boolean insert(Personal_Rsm personal_rsm){
		
		   //判断用户信息是否存在			   
		   hibernateTemplate.save(personal_rsm);
		   return true;	   
		   
	}
	
	 public void copyFile(String oldPath , String newPath) { 
		 try { 
	           int bytesum = 0; 
	           int byteread = 0; 
	           File oldfile = new File(oldPath); 
	           if (oldfile.exists()) { //文件存在时 
	               InputStream inStream = new FileInputStream(oldPath); //读入原文件 
	               System.out.println(oldPath);
	               FileOutputStream fs = new FileOutputStream(newPath); 
	               byte[] buffer = new byte[1444]; 
	               int length; 
	               while ( (byteread = inStream.read(buffer)) != -1) { 
	                   bytesum += byteread; //字节数 文件大小 
	                   System.out.println(bytesum); 
	                   fs.write(buffer, 0, byteread); 
	               } 
	               inStream.close(); 
	           } 
	       } 
	       catch (Exception e) { 
	           System.out.println("复制单个文件操作出错"); 
	           e.printStackTrace(); 

	       } 

	   } 
	 
	 
	 public static void Copy(String start,String end)
	    {
	          try { 
	                //要拷贝的图片
	                 BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(start)));
	                 //目标的地址
	                 BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(end))); 
	                 try { 
	                     int val = -1; 
	                     while((val=bis.read())!=-1){ 
	                       
	                         bos.write(val); 
	                     } 
	                     bos.flush(); 
	                     bos.close(); 
	                     bis.close();
	                    
	                } catch (IOException e) { 
	                e.printStackTrace();              } 
	            } catch (FileNotFoundException e) { 
	                e.printStackTrace(); 
	            }
	            
	    }
	
	 
	 
	
	
	public void creatRsm(int user_id){
		Personal_Rsm personal_rsm = null;
		System.out.println(user_id+"+++++++++++++++++++++++++++++++++++++++++++++");
		int temp = user_id;
		personal_rsm.setUser_id(temp);
		hibernateTemplate.save(personal_rsm);	
	}
	
	//更新数据库操作
	//以Personal_Rsm类为传递参数
	public void update(Personal_Rsm personal_rsm){
		
		Personal_Rsm rsm = null;
		String hql = "FROM Personal_Rsm as personal_rsm WHERE personal_rsm.user_id=?";
		List l = hibernateTemplate.find(hql,personal_rsm.getUser_id());	 
		Iterator iter = l.iterator();
		if(iter.hasNext())
		{
			rsm = (Personal_Rsm)iter.next();
		}
		rsm.setLanguage_skill(personal_rsm.getLanguage_skill());
		rsm.setAdd_info(personal_rsm.getAdd_info());
		rsm.setDeliver_status(personal_rsm.getDeliver_status());
		rsm.setEdit_time(personal_rsm.getEdit_time());
		rsm.setExpect_industry(personal_rsm.getExpect_industry());
		rsm.setExpect_job(personal_rsm.getExpect_job());
		rsm.setExpect_place(personal_rsm.getExpect_place());
		rsm.setExpect_salary(personal_rsm.getExpect_salary());
		rsm.setRead_status(personal_rsm.getRead_status());
		rsm.setSelf_evaluate(personal_rsm.getSelf_evaluate());
		rsm.setWork_month(personal_rsm.getWork_month());
		rsm.setMonth_salary(personal_rsm.getMonth_salary());
		hibernateTemplate.update(rsm);	
				
	}
	
	//查找个人简历
	//传递参数为User_ID
	//根据User_ID找到Personal_Rsm的全部信息；
	public Personal_Rsm queryByUserId(int user_id){
		
		Personal_Rsm personal_rsm = null;
		String hql = "FROM Personal_Rsm as personal_rsm WHERE personal_rsm.user_id=?";
		List l = hibernateTemplate.find(hql,user_id);	 
		Iterator iter = l.iterator();
		if(iter.hasNext())
		{
			personal_rsm = (Personal_Rsm)iter.next();
		}
		return personal_rsm;
		
	}
	
	
	//根据rsm_id查询用户信息
	public Personal_Rsm queryByRsmId(int rsm_id){
		
		return hibernateTemplate.get(Personal_Rsm.class, rsm_id);	
		
	}
	
	//删除用户信息，但是传进来的参数是Personal_Rsm类，一般使用下面的根据User_ID执行删除；
	public void delete(Personal_Rsm personal_rsm){
		
		hibernateTemplate.delete(personal_rsm);
	}
	
	//根据user_id为参数，删除个人简历；
	public void deleteByUserId(int user_id){
		
		Personal_Rsm personal_rsm = new Personal_Rsm();
		String hql = "FROM Personal_Rsm as personal_rsm WHERE personal_rsm.user_id=?";	
		List l = hibernateTemplate.find(hql,user_id);	 
		Iterator iter = l.iterator();
		if(iter.hasNext())
		{
			personal_rsm = (Personal_Rsm)iter.next();
		}
		hibernateTemplate.delete(personal_rsm);

	}
	
	//根据rsm_id为参数，删除个人简历；
	public void deleteByRsmId(int rsm_id){
		
		hibernateTemplate.delete(hibernateTemplate.get(Personal_Rsm.class, rsm_id));
		
	}


	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
