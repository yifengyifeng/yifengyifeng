package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.Limit;
import com.service.*;
import com.service.impl.*;

/**
 * Servlet implementation class UpdateLimitServlet
 */
@WebServlet("/UpdateLimitServlet")
public class UpdateLimitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static LimitService limitService=new LimitServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLimitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt((String)request.getParameter("id"));
		System.out.println(getServletName()+":::"+id);
		boolean allneed=((String)request.getParameter("allneed")).equalsIgnoreCase("true");
		boolean addneed=((String)request.getParameter("addneed")).equalsIgnoreCase("true");
		boolean checkneed=((String)request.getParameter("checkneed")).equalsIgnoreCase("true");
		boolean uppwd=((String)request.getParameter("uppwd")).equalsIgnoreCase("true");
		boolean queryneed=((String)request.getParameter("queryneed")).equalsIgnoreCase("true");
		boolean staneed=((String)request.getParameter("staneed")).equalsIgnoreCase("true");
		Limit limit=new Limit(id,allneed,addneed,checkneed,uppwd,queryneed,staneed);
		try{
			limitService.updateLimit(limit);
			out.print("1");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			out.print("0");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
