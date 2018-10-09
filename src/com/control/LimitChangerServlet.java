package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.LimitService;
import com.service.impl.LimitServiceImpl;
import com.model.Limit;
import com.service.*;
import com.service.impl.*;


/**
 * Servlet implementation class LimitChangerServlet
 */
@WebServlet("/LimitChangerServlet")
public class LimitChangerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static LimitService limitService=new LimitServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LimitChangerServlet() {
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
		try{
			Limit limit=limitService.findLimitById(id);
			out.print(limit.isAllneed()+"|");
			out.print(limit.isAddneed()+"|");
			out.print(limit.isCheckneed()+"|");
			out.print(limit.isUppwd()+"|");
			out.print(limit.isQueryneed()+"|");
			out.print(limit.isStaneed());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
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
