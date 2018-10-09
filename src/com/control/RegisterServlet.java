package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import com.model.User;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService=new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
    	
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		User user=new User();
		PrintWriter out=response.getWriter();
		user.setUsername(URLDecoder.decode((String)request.getParameter("username"),"UTF-8"));
		user.setPassword(URLDecoder.decode((String)request.getParameter("password"),"UTF-8"));
		user.setTruename(URLDecoder.decode((String)request.getParameter("truename"),"UTF-8"));
		user.setSex(URLDecoder.decode((String)request.getParameter("sex"),"UTF-8"));
		user.setProvince(URLDecoder.decode((String)request.getParameter("province"),"UTF-8"));
		user.setCity(URLDecoder.decode((String)request.getParameter("city"),"UTF-8"));
		user.setUnit(URLDecoder.decode((String)request.getParameter("unit"),"UTF-8"));
		user.setDirect(URLDecoder.decode((String)request.getParameter("direct"),"UTF-8"));
		user.setProfession(URLDecoder.decode((String)request.getParameter("profession"),"UTF-8"));
		user.setEdu(URLDecoder.decode((String)request.getParameter("edu"),"UTF-8"));
		user.setTtp(URLDecoder.decode((String)request.getParameter("ttp"),"UTF-8"));
		user.setAddr(URLDecoder.decode((String)request.getParameter("addr"),"UTF-8"));
		user.setPostcode(URLDecoder.decode((String)request.getParameter("postcode"),"UTF-8"));
		user.setMobilephone(URLDecoder.decode((String)request.getParameter("mobilephone"),"UTF-8"));
		user.setStatephone(URLDecoder.decode((String)request.getParameter("statephone"),"UTF-8"));
		user.setEmail(URLDecoder.decode((String)request.getParameter("email"),"UTF-8"));
		user.setQq(URLDecoder.decode((String)request.getParameter("qq"),"UTF-8"));
		user.setMsn(URLDecoder.decode((String)request.getParameter("msn"),"UTF-8"));
		
		System.out.println(user.getUsername()+"||"+user.getPassword());
		try {
			if(userService.isExitName(user.getUsername())){
				out.print("已存在该用户！");
			}
			else{
				userService.addUser(user);
				out.print(1);
			}
			
		}
		catch (Exception e) {
			// TODO 自动生成的 catch 块
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
