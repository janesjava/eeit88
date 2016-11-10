package org.iiiedu.eeit88.health.getimage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iiiedu.eeit88.health.getimage.model.PicBean;
import org.iiiedu.eeit88.health.getimage.model.PicService;



@WebServlet("/AllPic.do")
public class AllPic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PicService ps = new PicService();
			List<PicBean> allpic = ps.select(null);
			request.setAttribute("AllPics", allpic);
			RequestDispatcher rd = request.getRequestDispatcher("/textPic/AllPic.jsp");
			rd.forward(request, response);
			return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
