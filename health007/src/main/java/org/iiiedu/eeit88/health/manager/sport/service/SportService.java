package org.iiiedu.eeit88.health.manager.sport.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.iiiedu.eeit88.health.sport.model.SportBean;
import org.iiiedu.eeit88.health.sport.model.dao.SportDAOJdbc;



public class SportService {
	SportDAOJdbc sportDao = new SportDAOJdbc();
	
	
	//selectOndsport
	public SportBean selece(Integer id){
		SportBean result = null;
		result = sportDao.select(id);
		return result; 
	}
		
	//selectAllSport
	public List<SportBean> selectAll(SportBean bean){	
		List<SportBean> result = null;
		if(bean!=null && bean.getId()!=0){
			SportBean temp = sportDao.select(bean.getId());
			if(temp!=null){
				result = new ArrayList<SportBean>();
				result.add(temp);
			}
		}else{
			result= sportDao.select();
		}		
		return result;
	}
	
	//InsertSport
	public void insert(String name, InputStream inputStream, float calories, String sportType, String content, String suit, boolean sportStatus){
		
		byte[] picbytes = null;
		try {
			picbytes = IOUtils.toByteArray(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sportDao.insert(name, picbytes, calories, sportType, suit, content, sportStatus);
		
	}

	
	//UpdateSport
	public void update(String name,InputStream inputStream,float calories,String sportType,String content,String suit,boolean sportStatus,int id){
				
		byte[] picbytes = null;
		try {
			picbytes = IOUtils.toByteArray(inputStream);				
		} catch (IOException e) {
			e.printStackTrace();
		}			
		sportDao.update(name, picbytes, calories, sportType, content, suit, sportStatus, id);		
		
	}

	//下架(hide)
	public void hide(boolean sportStatus, int id){
		sportDao.hide(sportStatus, id);
	}
	
	public String textReplace(String content){
		String replacedContent = content.replace("\r\n", "<br/>");
		return replacedContent;	
	}
	
}
