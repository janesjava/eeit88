package org.iiiedu.eeit88.health.manager.food.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.iiiedu.eeit88.health.food.model.FoodBean;
import org.iiiedu.eeit88.health.food.model.dao.FoodDAOJdbc;



public class FoodService {
	FoodDAOJdbc foodDao = new FoodDAOJdbc();
	
	
	//selectOndfood
	public FoodBean selece(Integer id){
		FoodBean result = null;
		result = foodDao.select(id);
		return result; 
	}
		
	//selectAllFood
	public List<FoodBean> selectAll(FoodBean bean){	
		List<FoodBean> result = null;
		if(bean!=null && bean.getId()!=0){
			FoodBean temp = foodDao.select(bean.getId());
			if(temp!=null){
				result = new ArrayList<FoodBean>();
				result.add(temp);
			}
		}else{
			result= foodDao.select();
		}		
		return result;
	}
	
	//InsertFood
	public void insert(String name, String foodType, InputStream inputStream, Float calories, Boolean foodStatus){
		
		byte[] picbytes = null;
		try {
			picbytes = IOUtils.toByteArray(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		foodDao.insert(name, foodType, picbytes, calories, foodStatus);
			
	}

	
	//UpdateFood
	public void update(String name,String foodType, InputStream inputStream,float calories,boolean foodStatus,int id){
				
		byte[] picbytes = null;
		try {
			picbytes = IOUtils.toByteArray(inputStream);				
		} catch (IOException e) {
			e.printStackTrace();
		}			
		foodDao.update(name, foodType, picbytes, calories, foodStatus, id);		

	}

	//下架(hide)
	public void hide(boolean foodStatus, int id){
		foodDao.hide(foodStatus, id);
	}
	
	public String textReplace(String answer){
		String replacedAnswer = answer.replace("\r\n", "<br/>");
		return replacedAnswer;	
	}
	

}
