package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
public class LoginCheckServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7122098912443819995L;
	private UserService userService=new UserServiceImpl();
	public LoginCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");  
		PrintWriter out=response.getWriter();
		String userName=(String)request.getParameter("username");
		String passWord=(String)request.getParameter("password");
		userName=URLDecoder.decode(userName,"UTF-8");
		passWord=URLDecoder.decode(passWord,"UTF-8");
		try {
			if(userService.isLogin(userName, passWord)){
				out.flush();
				out.print("1");
			}
			else{
				out.flush();
				out.print("用户名或密码错误！");
				
				
			}
		} 
		catch (Exception e) {
		
			System.out.println(e.getMessage());
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
