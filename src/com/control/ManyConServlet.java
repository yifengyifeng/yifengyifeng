package com.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.model.Limit;
import com.model.Need;
import com.service.*;
import com.service.impl.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManyConServlet
 */
@WebServlet("/ManyConServlet")
public class ManyConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static NeedService needService=new NeedServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManyConServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String condition=(String)request.getParameter("condition");
		System.out.println(condition);
		List<Need> v = null;
		try {
			v=needService.query(condition);
			
		}catch (Exception e) {
			// TODO 自动生成的 catch 块
			System.out.println(e.getMessage());
		}
		request.setAttribute("v",v);
		request.getRequestDispatcher("/manycon_result.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
