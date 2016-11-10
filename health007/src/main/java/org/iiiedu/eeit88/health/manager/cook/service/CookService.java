package org.iiiedu.eeit88.health.manager.cook.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.iiiedu.eeit88.health.food.model.CookbookBean;
import org.iiiedu.eeit88.health.food.model.dao.CookbookDAOJdbc;



public class CookService {

	CookbookDAOJdbc cookDao = new CookbookDAOJdbc();
		
	//selectOndsport
	public CookbookBean selece(Integer id){
		CookbookBean result = null;
		result = cookDao.select(id);
		return result; 
	}
		
	//selectAllSport
	public List<CookbookBean> selectAll(CookbookBean bean){	
		List<CookbookBean> result = null;
		if(bean!=null && bean.getId()!=0){
			CookbookBean temp = cookDao.select(bean.getId());
			if(temp!=null){
				result = new ArrayList<CookbookBean>();
				result.add(temp);
			}
		}else{
			result= cookDao.select();
		}		
		return result;
	}
	
	//InsertSport
	public void insert(String name, String cooking, String cookbookType, InputStream inputStream, float calories, String suit, boolean cookbookStatus){
		
		byte[] picbytes = null;
		try {
			picbytes = IOUtils.toByteArray(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		cookDao.insert(name, cooking, cookbookType, picbytes, calories, suit, cookbookStatus);
		
	}

	
	//UpdateSport
	public void update(String name, String cooking, String cookbookType, InputStream inputStream, float calories, String suit, boolean cookbookStatus,int id){
				
		byte[] picbytes = null;
		try {
			picbytes = IOUtils.toByteArray(inputStream);				
		} catch (IOException e) {
			e.printStackTrace();
		}					
		cookDao.update(name, cooking, cookbookType, picbytes, calories, suit, cookbookStatus, id);
	}

	//下架(hide)
	public void hide(boolean cookbookStatus, int id){
		cookDao.hide(cookbookStatus, id);
	}
	
	public String textReplace(String answer){
		String replacedAnswer = answer.replace("\r\n", "<br/>");
		return replacedAnswer;	
	}
	
}
