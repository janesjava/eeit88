package org.iiiedu.eeit88.health.manager.cook.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.iiiedu.eeit88.health.food.model.CookbookBean;
import org.iiiedu.eeit88.health.manager.cook.service.CookService;



@WebServlet("/Manage/UpdateCook.do")
@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 500, maxRequestSize = 1024 * 1024 * 500 * 5)
public class UpdateCook extends HttpServlet {
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
		
		CookService cookService = new CookService();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// 接收資料
		String tempId = request.getParameter("cookId");
		String name = request.getParameter("cookName");
		String cooking = request.getParameter("cooking");
		String cookbookType = request.getParameter("cookType");
		
        InputStream inputStream = null; // input stream of the upload file      
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("cookPic");	//取得圖片訊息
        if (filePart != null) {
            // prints out some information for debugging
//            System.out.println(filePart.getName());
//            System.out.println(filePart.getSize());
//            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
      
		String tempCalories = request.getParameter("cookCalories");
		String suit = request.getParameter("cooksuit");
		String tempCookbookStatus = request.getParameter("cookStatus");
		
		String cooktion = request.getParameter("cooktion");
		
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
		
		float calories = 0;
		if (tempCalories!=null && tempCalories.trim().length()!=0){
			try {
				calories = Float.parseFloat(tempCalories);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errorMsg.put("calories", "calories必須是數字");
			}
		}

		boolean cookbookStatus = Boolean.parseBoolean(tempCookbookStatus);

		// 驗證資料
		if(name==null || name.length()==0){
			errorMsg.put("name", "Please enter name");
		}
		if(tempCalories==null || tempCalories.length()==0){
			errorMsg.put("calories", "please enter calories");
		}
		if(cooking==null || cooking.length()==0){
			errorMsg.put("cooking", "please enter cooking");
		}
		if(cookbookType==null || cookbookType.length()==0){
			errorMsg.put("cookbookType", "please enter cookbookType");
		}
		if(suit==null || suit.length()==0){
			errorMsg.put("suit", "please enter suit");
		}	
			
		// 呼叫Model
		if(errorMsg!=null && !errorMsg.isEmpty()){
			request.getRequestDispatcher("/managecook/changeonecook.jsp").forward(request, response);
			return;
		}
					
		//根據Model執行結果顯示View		
				
		CookbookBean result = cookService.selece(id);	
		System.out.println(result);
		if(result==null) {
			errorMsg.put("action", "修改資料失敗");
		} else {
			request.setAttribute("update", result);	
		}
		
		
		if("隱藏".equals(cooktion)) {				
			cookbookStatus = !cookbookStatus;			
			cookService.hide(cookbookStatus, id);
			request.getRequestDispatcher(
					"/Manage/ShowAllCook.do").forward(request, response);
		}else if("修改".equals(cooktion)) {			
			request.getRequestDispatcher("/managecook/changeonecook.jsp").forward(request, response);
			return;
		}
		
		

	}//end of doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
