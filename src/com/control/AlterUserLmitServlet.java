package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.Limit;
import com.model.User;
import com.service.*;
import com.service.impl.*;

/**
 * Servlet implementation class AlterUserLmitServlet
 */
@WebServlet("/AlterUserLmitServlet")
public class AlterUserLmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static LimitService limitService=new LimitServiceImpl();
	private static UserService userService=new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterUserLmitServlet() {
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
			String user=(String)request.getParameter("user");
			int limit=Integer.parseInt((String)request.getParameter("limit"));
			if(limitService.findLimitById(limit)==null){
				out.print("0");
			}
			else{
				System.out.println(user+"|"+limit);
				try{
					User us=userService.getUser(user);
					us.setLimit(limit);
					userService.updateUser(us);
					out.print("1");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
					out.print("0");
				}
			}
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
