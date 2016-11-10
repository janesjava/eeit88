package org.iiiedu.eeit88.health.manager.cook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iiiedu.eeit88.health.food.model.CookbookBean;
import org.iiiedu.eeit88.health.manager.cook.service.CookService;



@WebServlet("/Manage/ShowAllCook.do")
public class ShowAllCook extends HttpServlet {
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
		
		CookService ss = new CookService();
		List<CookbookBean> listCook = ss.selectAll(null);
		
		for(int i=0; i < listCook.size(); i++){
			String changeCooking= listCook.get(i).getCooking();
			String aa= ss.textReplace(changeCooking);
			listCook.get(i).setCooking(aa);
		}	
		
		
		request.setAttribute("AllCooks", listCook);
		RequestDispatcher rd = request.getRequestDispatcher("/managecook/showallcooks.jsp");
		rd.forward(request, response);
		return;		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
