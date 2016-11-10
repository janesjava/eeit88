package org.iiiedu.eeit88.health.manager.help.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iiiedu.eeit88.health.manager.help.model.HelpBean;
import org.iiiedu.eeit88.health.manager.help.service.HelpService;

@WebServlet("/Manage/AllHelps.do")
public class HelpAll extends HttpServlet {
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
		
		
		HelpService hs = new HelpService();
		List<HelpBean> hbl = hs.select(null);
		
		for(int i=0; i < hbl.size(); i++){
			String changeAnswer= hbl.get(i).getAnswer();
			String aa= hs.textReplace(changeAnswer);
			hbl.get(i).setAnswer(aa);
		}	

		System.out.println("size="+hbl.size());		
		
		request.setAttribute("AllHelps", hbl);
     	RequestDispatcher rd = request.getRequestDispatcher("/managehelp/showallhelps.jsp");
		rd.forward(request, response);
     	return ; 		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
