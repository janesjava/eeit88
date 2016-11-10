package org.iiiedu.eeit88.health.food.model;

import java.util.List;

public interface FoodDAO {

	List<FoodBean> select();//end of select all
	
	List<FoodBean> selectStatus(boolean status);

	FoodBean select(String name);//end of select by name
	
	FoodBean select(int id);

	FoodBean insert(String name, String foodType, byte[] pic, float calories, boolean foodStatus);//end of insert

	FoodBean update(String name, String foodType, byte[] pic, float calories, boolean foodStatus, int id);//end of update 

	boolean hide(boolean foodStatus, int id);//end of hide

}