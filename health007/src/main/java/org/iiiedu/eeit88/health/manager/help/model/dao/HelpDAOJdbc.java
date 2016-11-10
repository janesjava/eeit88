package org.iiiedu.eeit88.health.manager.help.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.iiiedu.eeit88.health.manager.help.model.HelpBean;
import org.iiiedu.eeit88.health.manager.help.model.HelpDAO;

public class HelpDAOJdbc implements HelpDAO {

//	private static final String URL = "jdbc:sqlserver://localhost:1433;database=health";
//	private static final String USERNAME = "sa";
//	private static final String PASSWORD = "passw0rd";


	private DataSource dataSource;
	public HelpDAOJdbc(){
		try {
			Context ctx=new InitialContext();
			dataSource=(DataSource)ctx.lookup("java:comp/env/jdbc/health");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	

	//測試
	public static void main(String[] args) {
		HelpDAOJdbc helpdao = new HelpDAOJdbc();
		System.out.println(helpdao.select(1));
		
//		System.out.println(helpdao.select());
		
//		HelpBean bean = new HelpBean();
//		bean.setKeyword("keyword4");
//		bean.setQuestion("question6");
//		bean.setAnswer("answer6");
//		bean.setHelpStatus(true);
//		helpdao.insert(bean);
//		System.out.println(helpdao.select(6));
//		
//		helpdao.update("keyword99", "question99", "answer9",  6);
//		System.out.println(helpdao.select(6));
		
//		helpdao.changeStatus(false, 1);
//		System.out.println(helpdao.select(1));
		
	}


	private static final String SELECT_ID = "select * from help where id=?";
	@Override
	public HelpBean select(Integer id) {
		HelpBean result = null;
		ResultSet rset = null;
		try (//Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			 Connection conn=dataSource.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(SELECT_ID);
			){
			stmt.setInt(1, id);
			rset = stmt.executeQuery();
			if(rset.next()){
				result = new HelpBean();
				result.setId(rset.getInt("id"));
				result.setKeyword(rset.getString("keyword"));
				result.setQuestion(rset.getString("question"));
				result.setAnswer(rset.getString("answer"));
				result.setHelpStatus(rset.getBoolean("helpStatus"));
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

	private static final String SELECT_ALL = "select * from help";
	@Override
	public List<HelpBean> select() {
		List<HelpBean> result = null;
		
		try (//Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				Connection conn=dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
				ResultSet rset = stmt.executeQuery();){
			
			result = new ArrayList<HelpBean>();
			while(rset.next()){
				HelpBean bean = new HelpBean();
				bean.setId(rset.getInt("id"));
				bean.setKeyword(rset.getString("keyword"));
				bean.setQuestion(rset.getString("question"));
				bean.setAnswer(rset.getString("answer"));
				bean.setHelpStatus(rset.getBoolean("helpStatus"));
				result.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return result;
	}

	private static final String INSERT = "insert into help (keyword, question, answer, helpStatus) values (?,?,?,?)";
	@Override
	public HelpBean insert(HelpBean bean) {
		HelpBean result = null;
		if(bean!=null){
		try (//Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			 Connection conn=dataSource.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(INSERT);
			){			
				stmt.setString(1, bean.getKeyword());
				stmt.setString(2, bean.getQuestion());
				stmt.setString(3, bean.getAnswer());
				stmt.setBoolean(4, bean.getHelpStatus());
				
				int i = stmt.executeUpdate();
				if(i==1){
					result = bean;
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		return result;
	}

	private static String UPDATE ="update help set keyword=?, question=?, answer=? where id=?";
	@Override
	public HelpBean update(String keyword, String question, String answer, Integer id) {
		HelpBean result = null;
		try (//Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			 Connection conn=dataSource.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(UPDATE);){

			stmt.setString(1, keyword);
			stmt.setString(2, question);
			stmt.setString(3, answer);
			
			stmt.setInt(4, id);
			
			int i = stmt.executeUpdate();
			if(i==1){
				result = this.select(id);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private static String changeStatus = "update help set helpStatus=? where id=?";
	@Override
	public HelpBean changeStatus(Boolean helpStatus, Integer id) {
		HelpBean result = null;
		try (//Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(changeStatus);){
			
			stmt.setBoolean(1, helpStatus);
			stmt.setInt(2, id);
			
			
			
			int i = stmt.executeUpdate();
			if(i==1){
				result = this.select(id);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
