package org.iiiedu.eeit88.health.sport.model;

import java.util.List;

public interface SportDAO {

	List<SportBean> select();//end of select all
	
	List<Integer> selectSuit(String suit);
	
	List<SportBean> selectStatus(Boolean status);

	SportBean select(String name);//end of select by name
	
	SportBean select(int id);

	SportBean insert(String name, byte[] pic, float calories, String sportType, String content, String suit,
			boolean sportStatus);//end of insert

	SportBean update(String name, byte[] pic, float calories, String sportType, String content, String suit,
			boolean sportStatus, int id);//end of update 

	boolean hide(boolean sportStatus, int id); //end of hide

}