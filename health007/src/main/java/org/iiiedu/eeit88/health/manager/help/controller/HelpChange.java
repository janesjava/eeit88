package org.iiiedu.eeit88.health.manager.help.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iiiedu.eeit88.health.manager.help.model.HelpBean;
import org.iiiedu.eeit88.health.manager.help.service.HelpService;



@WebServlet("/Manage/HelpChange.do")
public class HelpChange extends HttpServlet {
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
		
		HelpService helpService = new HelpService();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//接收資料
		String tempId = request.getParameter("helpID");
		String keyword = request.getParameter("helpKEYWORD");
		String question = request.getParameter("helpQUESTION");
		String answer = request.getParameter("helpANSWER");
		String tempHelpStatus = request.getParameter("helpHelpStatus");
		String helption = request.getParameter("helption");

		//轉換資料
			// 準備存放錯誤訊息
		Map<String, String> errorMsg = new HashMap<String, String>();
		request.setAttribute("error", errorMsg);		
		
		int id = 0;
		if(tempId!=null && tempId.trim().length()!=0){
			try {
				id = Integer.parseInt(tempId);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errorMsg.put("id", "Id必須是整數");
			}
		}
	
		boolean helpStatus = Boolean.parseBoolean(tempHelpStatus);		

		//驗證資料
		if(errorMsg!=null && !errorMsg.isEmpty()) {
			request.getRequestDispatcher(
					"/managehelp/showallhelps.jsp").forward(request, response);
			return;
		}		
		
		//呼叫Model, 根據Model執行結果顯示View
		HelpBean bean = new HelpBean();
		bean.setId(id);
		bean.setKeyword(keyword);
		bean.setQuestion(question);		
		bean.setAnswer(answer);	
		bean.setHelpStatus(helpStatus);		
		
		
			System.out.println(bean);
		
		if("修改".equals(helption)) {
			HelpBean result = helpService.update(bean);
			//System.out.println(result);
			if(result==null) {
				errorMsg.put("action", "修改資料失敗");
			} else {
				request.setAttribute("update", result);
			}
			request.getRequestDispatcher(
					"/managehelp/changeonehelp.jsp").forward(request, response);
		}else if("隱藏".equals(helption)) {
			
			if ( helpStatus == true){
				bean.setHelpStatus(false);
			}else if ( helpStatus == false){
				bean.setHelpStatus(true);
			}		
			System.out.println("hide" + bean);
			
			HelpBean result = helpService.changeStatus(bean);
			request.setAttribute("hide", result);
			request.getRequestDispatcher(
					"/Manage/AllHelps.do").forward(request, response);
		}		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
