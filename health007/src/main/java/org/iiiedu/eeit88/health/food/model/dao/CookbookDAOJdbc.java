package org.iiiedu.eeit88.health.food.model.dao;

import java.io.File;
import java.io.FileInputStream;
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

import org.iiiedu.eeit88.health.food.model.CookbookBean;
import org.iiiedu.eeit88.health.food.model.CookbookDAO;





public class CookbookDAOJdbc implements Serializable, CookbookDAO {
	//test for DriverManager
//	private static final String URL = "jdbc:sqlserver://localhost:1433;database=health";
//	private static final String USERNAME = "sa";
//	private static final String PASSWORD = "passw0rd";
	
	//test for DataSource
	private DataSource dataSource;
	public CookbookDAOJdbc(){
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/health");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}  //end of CookBookDAO
	
	
	private static final String SELECT_ALL = "SELECT ID,NAME,COOKING,COOKBOOKTYPE,PIC,CALORIES,SUIT,COOKBOOKSTATUS FROM COOKBOOK";
	@Override
	public List<CookbookBean> select(){
		List<CookbookBean> result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SELECT_ALL);
			rs = pstmt.executeQuery();
			
			result = new ArrayList<CookbookBean>();
			while(rs.next()){
				CookbookBean beans = new CookbookBean();
				beans.setId(rs.getInt("ID"));
				beans.setName(rs.getString("NAME"));
				beans.setCooking(rs.getString("COOKING"));
				beans.setCookbookType(rs.getString("COOKBOOKTYPE"));
				beans.setPic(rs.getBytes("PIC"));
				beans.setCalories(rs.getFloat("CALORIES"));
				beans.setSuit(rs.getString("SUIT"));
				beans.setCookbookStatus(rs.getBoolean("COOKBOOKSTATUS"));
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
	}  //end of select(All)
	
	
	
	
	private static final String SELECT_SUIT = "SELECT ID FROM COOKBOOK WHERE SUIT=?";
	public List<Integer> selectSuit(String suit){
		List<Integer> result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SELECT_SUIT);
			pstmt.setString(1, suit);
			rs = pstmt.executeQuery();
			
			result = new ArrayList<Integer>();
			while(rs.next()){
				int id = rs.getInt("id");		
				result.add(id);
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
	}  //end of select by suit
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static final String SELECT_NAME = "SELECT ID,NAME,COOKING,COOKBOOKTYPE,PIC,CALORIES,SUIT,COOKBOOKSTATUS FROM COOKBOOK WHERE NAME=?";
	@Override
	public CookbookBean select(String name){
		CookbookBean result = null;
		
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
				result = new CookbookBean();
				result.setId(rs.getInt("ID"));
				result.setName(rs.getString("NAME"));
				result.setCooking(rs.getString("COOKING"));
				result.setCookbookType(rs.getString("COOKBOOKTYPE"));
				result.setPic(rs.getBytes("PIC"));
				result.setCalories(rs.getFloat("CALORIES"));
				result.setSuit(rs.getString("SUIT"));
				result.setCookbookStatus(rs.getBoolean("COOKBOOKSTATUS"));
			}
			
		} catch (Exception e) {
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
	}//end of select by name

	
	private static final String SELECT_ID = "SELECT ID,NAME,COOKING,COOKBOOKTYPE,PIC,CALORIES,SUIT,COOKBOOKSTATUS FROM COOKBOOK WHERE ID=?";
	@Override
	public CookbookBean select(int id){
		CookbookBean result = null;
		
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
				result = new CookbookBean();
				result.setId(rs.getInt("ID"));
				result.setName(rs.getString("NAME"));
				result.setCooking(rs.getString("COOKING"));
				result.setCookbookType(rs.getString("COOKBOOKTYPE"));
				result.setPic(rs.getBytes("PIC"));
				result.setCalories(rs.getFloat("CALORIES"));
				result.setSuit(rs.getString("SUIT"));
				result.setCookbookStatus(rs.getBoolean("COOKBOOKSTATUS"));
			}
			
		} catch (Exception e) {
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
	}//end of select by id
	
	
	private static final String INSERT = "INSERT INTO COOKBOOK (NAME,COOKING,COOKBOOKTYPE,PIC,CALORIES,SUIT,COOKBOOKSTATUS) VALUES (?,?,?,?,?,?,?)";
	/* (non-Javadoc)
	 * @see model.CookbookDAO#insert(java.lang.String, java.lang.String, java.lang.String, byte[], float, java.lang.String, boolean)
	 */
	@Override
	public CookbookBean insert(String name,String cooking,String cookbookType,byte[] pic,float calories,String suit,boolean cookbookStatus){
		CookbookBean result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, name);
			pstmt.setString(2, cooking);
			pstmt.setString(3, cookbookType);
			pstmt.setBytes(4, pic);
			pstmt.setFloat(5, calories);
			pstmt.setString(6, suit);
			pstmt.setBoolean(7, cookbookStatus);
			
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
	
	
	private static final String UPDATE = "UPDATE COOKBOOK SET NAME=?,COOKING=?,COOKBOOKTYPE=?,PIC=?,CALORIES=?,SUIT=?,COOKBOOKSTATUS=? WHERE ID=?" ;
	/* (non-Javadoc)
	 * @see model.CookbookDAO#update(java.lang.String, java.lang.String, java.lang.String, byte[], float, java.lang.String, boolean, int)
	 */
	@Override
	public CookbookBean update(String name,String cooking,String cookbookType,byte[] pic,float calories,String suit,boolean cookbookStatus,int id){
		CookbookBean result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(UPDATE);
			pstmt.setString(1, name);
			pstmt.setString(2, cooking);
			pstmt.setString(3, cookbookType);
			pstmt.setBytes(4, pic);
			pstmt.setFloat(5,calories);
			pstmt.setString(6, suit);
			pstmt.setBoolean(7, cookbookStatus);
			pstmt.setInt(8, id);
			
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
	
	
	private static final String HIDE = "UPDATE COOKBOOK SET COOKBOOKSTATUS=? WHERE ID=?";
	/* (non-Javadoc)
	 * @see model.CookbookDAO#hide(boolean, int)
	 */
	@Override
	public boolean hide(boolean cookbookStatus, int id){
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(HIDE);
			pstmt.setBoolean(1, cookbookStatus);
			pstmt.setInt(2, id);
			
			int i = pstmt.executeUpdate();
			if(i==1){
				result = true;
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
	}//end of hide
	
	
	
	//for test 
	public static void main(String[] args) throws IOException{
		CookbookDAO test = new CookbookDAOJdbc();
	//test select all
		System.out.println(test.select());
	//test select by name
		System.out.println(test.select("日清炸雞"));
	//test insert
		//1.讀圖檔
		File picture = new File("D:/EEIT Project/Health/database/cookbook/麻油雞飯.jpg");
		int size = (int) picture.length();
		byte[] inputPictures = new byte[size];
		InputStream fis = new FileInputStream(picture);
		fis.read(inputPictures);
		fis.close();
		//2.insert
		CookbookBean bean = test.insert("AA", "1.AA<br/>2.BB<br/>", "配菜", inputPictures, 123, "過胖", true);
		System.out.println(bean);
	//test update 
		CookbookBean bean1 = test.update("青醬", "AAAAA", "配菜", null, 456, "適中", false, 1);
		System.out.println(bean1);
	//test hide
		Boolean hideResult = test.hide(true, 1);
		System.out.println("修改成功?"+hideResult);
	//test by select id where suit=""
			System.out.println(test.selectSuit("過胖"));
	}
}//end of class
