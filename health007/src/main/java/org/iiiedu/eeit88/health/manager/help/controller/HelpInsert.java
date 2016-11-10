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


@WebServlet("/Manage/HelpInsert.do")
public class HelpInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// 接收資料
		String tempId = request.getParameter("id");
		System.out.println(tempId);
		String keyword = request.getParameter("keyword");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		String tempHelpStatus = request.getParameter("helpStatus");
		String helption = request.getParameter("helption");

		// 轉換資料
		
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

		// 驗證資料
		if(keyword==null || keyword.length()==0){
			errorMsg.put("keyword", "必填");
		}
		if(question==null || question.length()==0){
			errorMsg.put("question", "必填");
		}
		if(answer==null || answer.length()==0){
			errorMsg.put("answer", "必填");
		}
				
		// 呼叫Model
		//根據Model執行結果顯示View
		if(errorMsg!=null && !errorMsg.isEmpty()){
			request.getRequestDispatcher("/managehelp/insertonehelp.jsp").forward(request, response);
			return;
		}else{
			HelpBean bean = new HelpBean();
			bean.setId(id);
			bean.setKeyword(keyword);
			bean.setQuestion(question);
			bean.setAnswer(answer);
			bean.setHelpStatus(helpStatus);
			HelpService helpService = new HelpService();
						
			System.out.println(bean);
			
			if("新增".equals(helption)) {
				System.out.println("insert");
				helpService.insert(bean);
			}else if("確認修改".equals(helption)){
				System.out.println("change");
				helpService.update(bean);
			}			
			
			request.getRequestDispatcher("/Manage/AllHelps.do").forward(request, response);
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
