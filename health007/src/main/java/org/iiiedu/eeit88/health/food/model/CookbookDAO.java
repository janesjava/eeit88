package org.iiiedu.eeit88.health.food.model;

import java.util.List;

public interface CookbookDAO {

	List<CookbookBean> select(); //end of select(All)
	
	List<Integer> selectSuit(String suit); //end of select by suit

	CookbookBean select(String name);//end of select by name
	
	CookbookBean select(int id);//end of select by id
	

	CookbookBean insert(String name, String cooking, String cookbookType, byte[] pic, float calories, String suit,
			boolean cookbookStatus);//end of insert

	CookbookBean update(String name, String cooking, String cookbookType, byte[] pic, float calories, String suit,
			boolean cookbookStatus, int id);//end of update 

	boolean hide(boolean cookbookStatus, int id);//end of hide

}