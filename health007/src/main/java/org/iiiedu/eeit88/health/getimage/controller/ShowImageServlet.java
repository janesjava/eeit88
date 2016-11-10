package org.iiiedu.eeit88.health.getimage.controller;

import java.io.*;
import java.sql.*;
import javax.naming.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.*;

@WebServlet("/getImage")
public class ShowImageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		InputStream photoInputStream = null;
		OutputStream os = null;
		
		try {
			String id = request.getParameter("id");
			String type = request.getParameter("type");
			//System.out.println("ID:" + id);
			//System.out.println("TYPE:"+type);
			
			
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/health");
			conn = dataSource.getConnection();
					
			if(type.equalsIgnoreCase("RECOMMAND")){
				pstmt = conn.prepareStatement("SELECT NAME,PIC FROM COOKBOOK WHERE ID=?");
			}else if(type.equalsIgnoreCase("FOOD")){
				pstmt = conn.prepareStatement("SELECT NAME,PIC FROM FOOD WHERE ID=?");
			}else if(type.equalsIgnoreCase("SPORT")){
				pstmt = conn.prepareStatement("SELECT NAME,PIC FROM SPORT WHERE ID=?");
			}
			
			pstmt.setString(1, id);
			
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				photoInputStream = rs.getBinaryStream("pic");
				
								
//				String mimeType = getServletContext().getMimeType("xxx.jpg");  // 設定輸出資料的型態(在table加一欄檔案名稱"圖檔名.jpg"取得它的type)
//				response.setContentType(mimeType);	
				response.setContentType("image/png");
				
				
				os = response.getOutputStream();  // 取得能寫出非文字資料的OutputStream物件
				byte[] buffer = new byte[4*1024];
				int len = photoInputStream.read(buffer);
				while(len!=-1) {
					os.write(buffer, 0, len);
					len = photoInputStream.read(buffer);
				}
			}
		} catch (NamingException e) {
			throw new ServletException(e);
		} catch (SQLException e) {
			throw new ServletException(e);
		} finally {
			os.close();
			photoInputStream.close();
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
	}// end of doGet

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
}
