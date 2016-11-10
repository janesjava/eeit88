package org.iiiedu.eeit88.health.manager.sport.controller;

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

import org.iiiedu.eeit88.health.manager.sport.service.SportService;
import org.iiiedu.eeit88.health.sport.model.SportBean;




@WebServlet("/Manage/UpdateSport.do")
@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 500, maxRequestSize = 1024 * 1024 * 500 * 5)
public class UpdateSport extends HttpServlet {
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
		
		
		SportService sportService = new SportService();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// 接收資料
		String tempId = request.getParameter("sportId");
		String name = request.getParameter("sportName");
		
        InputStream inputStream = null; // input stream of the upload file        
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("sportPic");	//取得圖片訊息
        if (filePart != null) {
            // prints out some information for debugging
//            System.out.println(filePart.getName());
//            System.out.println(filePart.getSize());
//            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
      
		String tempCalories = request.getParameter("sportCalories");
		String sportType = request.getParameter("sportType");
		String sportcontent = request.getParameter("sportcontent");
		String sportsuit = request.getParameter("sportsuit");		
		String tempSportStatus = request.getParameter("sportStatus");

		String sporttion = request.getParameter("sporttion");
		
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

		boolean sportStatus = Boolean.parseBoolean(tempSportStatus);

		// 驗證資料
		if(name==null || name.length()==0){
			errorMsg.put("name", "Please enter name");
		}
		if(tempCalories==null || tempCalories.length()==0){
			errorMsg.put("calories", "please enter calories");
		}
		if(sportType==null || sportType.length()==0){
			errorMsg.put("sportType", "please enter sportType");
		}
		if(sportcontent==null || sportcontent.length()==0){
			errorMsg.put("content", "please enter content");
		}
		if(sportsuit==null || sportsuit.length()==0){
			errorMsg.put("suit", "please enter suit");
		}		
			
		// 呼叫Model
		if(errorMsg!=null && !errorMsg.isEmpty()){
			request.getRequestDispatcher("/managesport/changeonehelp.jsp").forward(request, response);
			return;
		}
					
		//根據Model執行結果顯示View		
				
		SportBean result = sportService.selece(id);	
		System.out.println(result);
		if(result==null) {
			errorMsg.put("action", "修改資料失敗");
		} else {
			request.setAttribute("update", result);	
		}
		
		
		if("隱藏".equals(sporttion)) {				
			sportStatus = !sportStatus;			
			sportService.hide(sportStatus, id);
			request.getRequestDispatcher(
					"/Manage/ShowAllSport.do").forward(request, response);
		}else if("修改".equals(sporttion)) {			
			request.getRequestDispatcher("/managesport/changeonesport.jsp").forward(request, response);
			return;
		}
		
		

	}//end of doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
