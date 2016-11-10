package org.iiiedu.eeit88.health.manager.sport.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iiiedu.eeit88.health.manager.sport.service.SportService;
import org.iiiedu.eeit88.health.sport.model.SportBean;


@WebServlet("/Manage/ShowAllSport.do")
public class ShowAllSport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		// 先取出session物件
//		HttpSession session = request.getSession(false);
//		// 紀錄目前請求的RequestURI,以便使用者登入成功後能夠回到原本的畫面
//		String requestURI = request.getRequestURI();
//		// System.out.println("requestURI=" + requestURI);
//		// 如果session物件不存在
//		if (session == null || session.isNew()) {
//			// 請使用者登入
//			response.sendRedirect(response.encodeRedirectURL("login.jsp"));
//			return;
//		}
//		session.setAttribute("requestURI", requestURI);
//		// 此時session物件存在，讀取session物件內的LoginOK
//		// 以檢查使用者是否登入。
//		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
//		if (mb == null) {
//			response.sendRedirect(response.encodeRedirectURL("/login.jsp"));
//			return;
//		}
		
		
		SportService ss = new SportService();
		List<SportBean> listSport = ss.selectAll(null);
		
		for(int i=0; i < listSport.size(); i++){
			String changeContent= listSport.get(i).getContent();
			String aa= ss.textReplace(changeContent);
			listSport.get(i).setContent(aa);
		}	
		
		
		request.setAttribute("AllSports", listSport);
		RequestDispatcher rd = request.getRequestDispatcher("/managesport/showallsports.jsp");
		rd.forward(request, response);
		return;		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
