package org.iiiedu.eeit88.health.food.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.iiiedu.eeit88.health.food.model.FoodBean;
import org.iiiedu.eeit88.health.food.model.FoodDAO;




public class FoodDAOJdbc implements Serializable, FoodDAO {
	//for test by use DriverManager
//	private static final String URL = "jdbc:sqlserver://localhost:1433;database=health";
//	private static final String USERNAME = "sa";
//	private static final String PASSWORD = "passw0rd";
	
	//for test by use DataSource
	private DataSource dataSource;
	public FoodDAOJdbc(){
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/health");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	} // end of FoodDAO
	
	private static final String SELECT_ALL = "SELECT ID,NAME,FOODTYPE,PIC,CALORIES,FOODSTATUS FROM FOOD";
	@Override
	public List<FoodBean> select(){
		
		List<FoodBean> result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			conn = DriverManager.getConnection(URL , USERNAME , PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SELECT_ALL);
			rs = pstmt.executeQuery();
			result = new ArrayList<FoodBean>();
			while(rs.next()){
				FoodBean beans = new FoodBean();
				beans.setId(rs.getInt("ID"));
				beans.setName(rs.getString("NAME"));
				beans.setFoodType(rs.getString("FOODTYPE"));
				beans.setPic(rs.getBytes("PIC"));
				beans.setCalories(rs.getFloat("CALORIES"));
				beans.setFoodStatus(rs.getBoolean("FOODSTATUS"));
			
				result.add(beans);		
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
		return result;	
	}//end of select all
	
	
	private static final String SELECT_BY_STATUS = "SELECT ID,NAME,FOODTYPE,PIC,CALORIES,FOODSTATUS FROM FOOD WHERE FOODSTATUS=?";
	@Override
	public List<FoodBean> selectStatus(boolean status){
		
		List<FoodBean> result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			conn = DriverManager.getConnection(URL , USERNAME , PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SELECT_BY_STATUS);
			pstmt.setBoolean(1, status);
			rs = pstmt.executeQuery();
			result = new ArrayList<FoodBean>();
			while(rs.next()){
				FoodBean beans = new FoodBean();
				beans.setId(rs.getInt("ID"));
				beans.setName(rs.getString("NAME"));
				beans.setFoodType(rs.getString("FOODTYPE"));
				beans.setPic(rs.getBytes("PIC"));
				beans.setCalories(rs.getFloat("CALORIES"));
				beans.setFoodStatus(rs.getBoolean("FOODSTATUS"));
			
				result.add(beans);		
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
		return result;	
	}//end of select all by look status
	
	
	
	
	private static final String SELECT_NAME = "SELECT ID,NAME,FOODTYPE,PIC,CALORIES,FOODSTATUS FROM FOOD WHERE NAME=?";
	@Override
	public FoodBean select(String name){
		FoodBean result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SELECT_NAME);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				result = new FoodBean();
				result.setId(rs.getInt("ID"));
				result.setName(rs.getString("NAME"));
				result.setFoodType(rs.getString("FOODTYPE"));
				result.setPic(rs.getBytes("PIC"));
				result.setCalories(rs.getFloat("CALORIES"));
				result.setFoodStatus(rs.getBoolean("FOODSTATUS"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} 
			}
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}	
		return result;
	}//end of select by name
	
	
	private static final String SELECT_ID = "SELECT ID,NAME,FOODTYPE,PIC,CALORIES,FOODSTATUS FROM FOOD WHERE ID=?";
	@Override
	public FoodBean select(int id){
		FoodBean result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SELECT_ID);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				result = new FoodBean();
				result.setId(rs.getInt("ID"));
				result.setName(rs.getString("NAME"));
				result.setFoodType(rs.getString("FOODTYPE"));
				result.setPic(rs.getBytes("PIC"));
				result.setCalories(rs.getFloat("CALORIES"));
				result.setFoodStatus(rs.getBoolean("FOODSTATUS"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} 
			}
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}	
		return result;
	}//end of select by id 
	
	
	private static final String INSERT = "INSERT INTO FOOD(NAME,FOODTYPE,PIC,CALORIES,FOODSTATUS) VALUES (?,?,?,?,?)";
	@Override
	public FoodBean insert(String name,String foodType,byte[] pic,float calories,boolean foodStatus){
		FoodBean result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, name);
			pstmt.setString(2, foodType);
			pstmt.setBytes(3, pic);
			pstmt.setFloat(4, calories);
			pstmt.setBoolean(5, foodStatus);
			
			int i = pstmt.executeUpdate();			
				if(i==1){		
					result = this.select(name);	
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}	
		return result;	
	}//end of insert
	
	
	private static final String UPDATE = "UPDATE FOOD SET NAME=?,FOODTYPE=?,PIC=?,CALORIES=?,FOODSTATUS=? WHERE ID=? ";
	/* (non-Javadoc)
	 * @see model.FoodDAO#update(java.lang.String, java.lang.String, byte[], float, boolean, int)
	 */
	@Override
	public FoodBean update(String name,String foodType,byte[] pic,float calories,boolean foodStatus,int id){
		FoodBean result = new FoodBean();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(UPDATE);
			pstmt.setString(1, name);
			pstmt.setString(2, foodType);
			pstmt.setBytes(3, pic);
			pstmt.setFloat(4, calories);
			pstmt.setBoolean(5, foodStatus);
			pstmt.setInt(6, id);
			
			int i = pstmt.executeUpdate();
			if(i==1){
				result = this.select(name);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}	
		return result;
	}//end of update 
	
	
	private static final String HIDE = "UPDATE FOOD SET FOODSTATUS=? WHERE ID=?";
	/* (non-Javadoc)
	 * @see model.FoodDAO#hide(boolean, int)
	 */
	@Override
	public boolean hide(boolean foodStatus,int id){
		boolean result = false ;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(HIDE);
			pstmt.setBoolean(1, foodStatus);
			pstmt.setInt(2, id);
			
			int i = pstmt.executeUpdate();
			if(i==1){
				return true;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}	
		return result;
	}//end of hide
	
	
	
	//for test 
	public static void main(String[] args) throws IOException{
		FoodDAO test = new FoodDAOJdbc();
	//test select all
		System.out.println(test.select());
	//test select
		System.out.println(test.select("玉米"));
	//test id 
		System.out.println(test.select(5));
	//test insert
		//1.讀圖檔
		File picture = new File("D:/EEIT Project/Health/database/food/櫻桃.jpg");
		int size = (int) picture.length();
		byte[] inputPictures = new byte[size];
		InputStream fis = new FileInputStream(picture);
		fis.read(inputPictures);
		fis.close();
//		//2.insert
		FoodBean bean = test.insert("櫻桃", "水果", inputPictures, 123, true);
		System.out.println(bean);	
	//test update
		FoodBean bean2 = test.update("芭樂", "水果", null, 321, false, 62);
		System.out.println(bean2);
	//test hide
		Boolean hideResult = test.hide(false, 48);
		System.out.println("修改成功？"+hideResult);
	//test by select foodStatus
			System.out.println(test.selectStatus(false));

	}//end of main

}//end of class
