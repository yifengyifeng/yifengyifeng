package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.NeedService;
import com.service.impl.NeedServiceImpl;

/**
 * Servlet implementation class DeleteNeedServlet
 */
@WebServlet("/DeleteNeedServlet")
public class DeleteNeedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static NeedService needService=new NeedServiceImpl();
    public DeleteNeedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		String num=(String)request.getParameter("num");
		try{
			needService.deleteNeed(num);
			out.print("1");
		}
		catch(Exception e){
			out.print("0");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
