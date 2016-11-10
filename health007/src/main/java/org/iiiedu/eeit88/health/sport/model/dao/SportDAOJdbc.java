package org.iiiedu.eeit88.health.sport.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import org.iiiedu.eeit88.health.sport.model.SportBean;
import org.iiiedu.eeit88.health.sport.model.SportDAO;


public class SportDAOJdbc implements Serializable, SportDAO {
	//for test by use DriverManager
//	private static final String URL = "jdbc:sqlserver://localhost:1433;database=health";
//	private static final String USERNAME = "sa";
//	private static final String PASSWORD = "passw0rd";
	
	//for test by use DataSource
	private DataSource dataSource;
	public SportDAOJdbc(){
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/health");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}//end of SportDAO
	
	private static final String SELECT_ALL = "SELECT ID,NAME,PIC,CALORIES,SPORTTYPE,CONTENT,SUIT,SPORTSTATUS FROM SPORT";
	@Override
	public List<SportBean> select(){
		List<SportBean> result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SELECT_ALL);
			rs = pstmt.executeQuery();
			result = new ArrayList<SportBean>();
			while (rs.next()){
				SportBean beans = new SportBean();
				beans.setId(rs.getInt("ID"));
				beans.setName(rs.getString("NAME"));
				beans.setPic(rs.getBytes("PIC"));
				beans.setCalories(rs.getFloat("CALORIES"));
				beans.setSportType(rs.getString("SPORTTYPE"));
				beans.setContent(rs.getString("CONTENT"));
				beans.setSuit(rs.getString("SUIT"));
				beans.setSportStatus(rs.getBoolean("SPORTSTATUS"));
				result.add(beans);
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
	}//end of select all
	
	
	private static final String SELECT_SUIT = "SELECT ID FROM SPORT WHERE SUIT=?";
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
				Integer id = rs.getInt("ID");		
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
	
	
	private static final String SELECT_BY_STATUS = "SELECT ID,NAME,PIC,CALORIES,SPORTTYPE,CONTENT,SUIT,SPORTSTATUS FROM SPORT WHERE SPORTSTATUS=?";
	@Override
	public List<SportBean> selectStatus(Boolean status){
		List<SportBean> result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SELECT_BY_STATUS);
			pstmt.setBoolean(1, status);
			rs = pstmt.executeQuery();
			result = new ArrayList<SportBean>();
			while (rs.next()){
				SportBean beans = new SportBean();
				beans.setId(rs.getInt("ID"));
				beans.setName(rs.getString("NAME"));
				beans.setPic(rs.getBytes("PIC"));
				beans.setCalories(rs.getFloat("CALORIES"));
				beans.setSportType(rs.getString("SPORTTYPE"));
				beans.setContent(rs.getString("CONTENT"));
				beans.setSuit(rs.getString("SUIT"));
				beans.setSportStatus(rs.getBoolean("SPORTSTATUS"));
				result.add(beans);
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
	}//end of select sport's status
	
	
	private static final String SELECT_NAME = "SELECT ID,NAME,PIC,CALORIES,SPORTTYPE,CONTENT,SUIT,SPORTSTATUS FROM SPORT WHERE NAME=?";
	@Override
	public SportBean select(String name){
		SportBean result = null;
		
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
				result = new SportBean();
				result.setId(rs.getInt("ID"));
				result.setName(rs.getString("NAME"));
				result.setPic(rs.getBytes("PIC"));
				result.setCalories(rs.getFloat("CALORIES"));
				result.setSportType(rs.getString("SPORTTYPE"));
				result.setContent(rs.getString("CONTENT"));
				result.setSuit(rs.getString("SUIT"));
				result.setSportStatus(rs.getBoolean("SPORTSTATUS"));
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
	}//end of select by name

	
	private static final String SELECT_ID = "SELECT ID,NAME,PIC,CALORIES,SPORTTYPE,CONTENT,SUIT,SPORTSTATUS FROM SPORT WHERE ID=?";
	@Override
	public SportBean select(int id){
		SportBean result = null;
		
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
				result = new SportBean();
				result.setId(rs.getInt("ID"));
				result.setName(rs.getString("NAME"));
				result.setPic(rs.getBytes("PIC"));
				result.setCalories(rs.getFloat("CALORIES"));
				result.setSportType(rs.getString("SPORTTYPE"));
				result.setContent(rs.getString("CONTENT"));
				result.setSuit(rs.getString("SUIT"));
				result.setSportStatus(rs.getBoolean("SPORTSTATUS"));
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
	}//end of select by id
	
	
	private static final String INSERT = "INSERT INTO SPORT (NAME,PIC,CALORIES,SPORTTYPE,CONTENT,SUIT,SPORTSTATUS) VALUES (?,?,?,?,?,?,?)";
	/* (non-Javadoc)
	 * @see model.SportDAO#insert(java.lang.String, byte[], float, java.lang.String, java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public SportBean insert(String name,byte[] pic,float calories,String sportType,String content,String suit,boolean sportStatus){
		SportBean result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, name);
			pstmt.setBytes(2, pic);
			pstmt.setFloat(3, calories);
			pstmt.setString(4, sportType);
			pstmt.setString(5, content);
			pstmt.setString(6, suit);
			pstmt.setBoolean(7, sportStatus);
			
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
	
	
	private static final String UPDATE = "UPDATE SPORT SET NAME=?,PIC=?,CALORIES=?,SPORTTYPE=?,CONTENT=?,SUIT=?,SPORTSTATUS=? WHERE ID=?";
	/* (non-Javadoc)
	 * @see model.SportDAO#update(java.lang.String, byte[], float, java.lang.String, java.lang.String, java.lang.String, boolean, int)
	 */
	@Override
	public SportBean update(String name,byte[] pic,float calories,String sportType,String content,String suit,boolean sportStatus,int id){
		SportBean result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(UPDATE);
			pstmt.setString(1, name);
			pstmt.setBytes(2, pic);
			pstmt.setFloat(3, calories);
			pstmt.setString(4, sportType);
			pstmt.setString(5, content);
			pstmt.setString(6, suit);
			pstmt.setBoolean(7, sportStatus);
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
	
	
	private static final String HIDE = "UPDATE SPORT SET SPORTSTATUS=? WHERE ID=?";
	/* (non-Javadoc)
	 * @see model.SportDAO#hide(boolean, int)
	 */
	@Override
	public boolean hide(boolean sportStatus,int id){
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(HIDE);
			pstmt.setBoolean(1, sportStatus);
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
	}  //end of hide
	
	
	//for test 
	public static void main(String[] args) throws IOException{
		SportDAO test = new SportDAOJdbc();
//	//test by select all
//		System.out.println(test.select());
//	//test select by name
//		System.out.println(test.select("爬樓梯"));
//	//test select by id
//		System.out.println(test.select(5));
//	//test insert
//		//1.讀圖檔
//		File picture = new File("D:/EEIT Project/Health/database/sport/羽球.jpg");
//		int size = (int) picture.length();
//		byte[] inputPictures = new byte[size];
//		InputStream fis = new FileInputStream(picture);
//		fis.read(inputPictures);
//		fis.close();
//		//2.insert
//		SportBean bean = test.insert("羽球", inputPictures, 123, "室內", "羽球羽羽羽球", "過胖", true);
//		System.out.println(bean);
//	//for test update 
//		SportBean bean1 = test.update("呼拉圈", null, 123, "室外", "AAAAA", "適中", false, 1);
//		System.out.println(bean1);
//	//for test hide
//		Boolean hideResult = test.hide(false,2);
//		System.out.println("修改成功？"+hideResult);
//	//test select by suit
//		System.out.println(test.selectSuit("適中"));
	//test select by sport's status
			System.out.println(test.selectStatus(false));

	}//end of main

}//end of class
