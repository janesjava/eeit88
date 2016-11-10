package org.iiiedu.eeit88.health.getimage.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

import org.iiiedu.eeit88.health.getimage.model.PicBean;
import org.iiiedu.eeit88.health.getimage.model.PicDAO;


public class PicDAOJdbc implements PicDAO {

//	private static final String URL = "jdbc:sqlserver://localhost:1433;database=health";
//	private static final String USERNAME = "sa";
//	private static final String PASSWORD = "passw0rd";	
	
	private DataSource dataSource;
	public PicDAOJdbc(){
		try {
			Context ctx=new InitialContext();
			dataSource=(DataSource)ctx.lookup("java:comp/env/jdbc/health");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String SELECT_ID = "select * from testPic where id=?";
	@Override
	public PicBean select(Integer id) {
		PicBean result = null;
		ResultSet rset = null;
		try (//Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				Connection conn=dataSource.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(SELECT_ID);
			){
			
			stmt.setInt(1, id);
			rset = stmt.executeQuery();
			if(rset.next()){
				result = new PicBean();
				result.setId(rset.getInt("id"));
				result.setKeyword(rset.getString("keyword"));
				result.setPic(rset.getBytes("pic"));
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset!=null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}	
		return result;
	}

	private static final String SELECT_ALL = "select * from testPic";
	@Override
	public List<PicBean> select() {
		List<PicBean> result = null;
		
		try (//Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				Connection conn=dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
				ResultSet rset = stmt.executeQuery();
			) {
			
			result = new ArrayList<PicBean>();
			while(rset.next()){
				PicBean bean = new PicBean();
				bean.setId(rset.getInt("id"));
				bean.setKeyword(rset.getString("keyword"));
				bean.setPic(rset.getBytes("pic"));
				result.add(bean);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String INSERT="insert into testPic (keyword, pic) values (?,?) ";
	@Override
	public PicBean insert(PicBean bean) {
		PicBean result = null;
		
		if (bean!=null) {
			try (//Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
					Connection conn=dataSource.getConnection();
				 PreparedStatement stmt = conn.prepareStatement(INSERT);
					) {
				
				stmt.setString(1, bean.getKeyword());
				stmt.setBytes(2, bean.getPic());	
								
				int i = stmt.executeUpdate();	
				if(i==1){
					System.out.println("Insert blob is successful!");	
				}
								
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}//end of if
		return result;
	}

	private static final String UPDATE = "update testPic set keyword=?, pic=? where id=?";
	@Override
	public PicBean update(String keyword, byte[] pic, Integer id) {
		PicBean result = null;
		try (//Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				Connection conn=dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(UPDATE);
			){
						
			stmt.setString(1, keyword);
			stmt.setBytes(2, pic);
			stmt.setInt(3, id);
			
			int i = stmt.executeUpdate();
			if(i==1) {
				System.out.println("updata is successful!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return result;
	}
	
	//test
	public static void main(String[] args) throws IOException {
		PicDAOJdbc pic = new PicDAOJdbc();
//		System.out.println(pic.select(1));
		
//		System.out.println(pic.select());
		
		File finput = new File("C:/Users/Student/Desktop/a01.png");	//檔案
		
		int size=(int) finput.length();
		byte[] inputPictures = new byte[size];
		FileInputStream fis = new FileInputStream(finput);
		fis.read(inputPictures);
		fis.close();
//				
//		PicBean bean = new PicBean();
//		bean.setKeyword("keywordx");
//		bean.setPic(inputPictures);
//		pic.insert(bean);
		
		pic.update("keyword22", inputPictures, 1);


	}

}
