package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.Limit;
import com.service.*;
import com.service.impl.*;

/**
 * Servlet implementation class AllLimitServlet
 */
@WebServlet("/AllLimitServlet")
public class AllLimitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static LimitService limitService=new LimitServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllLimitServlet() {
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
		try{
			List<Limit> v=limitService.findAllLimit();
			for(int i=0;i<v.size()-1;i++){
				out.print(v.get(i).getId()+"|");
			}
			out.print(v.get(v.size()-1).getId());
		}
		catch(Exception e){
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
