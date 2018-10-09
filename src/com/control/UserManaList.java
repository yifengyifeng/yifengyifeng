package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UserManaList
 */
@WebServlet("/UserManaList")
public class UserManaList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static UserService userService=new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManaList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		List<User> v=null;
		try{
			
			v=userService.findAllUser();
	        
	        out.print("[");
	        for(int i=0;i<v.size();i++){
	        	Map map = new HashMap(); 
		        map.put( "user", v.get(i).getUsername());  
		        map.put( "userlimit", v.get(i).getLimit());  
		        map.put( "userunit", v.get(i).getUnit() ); 
		        JSONObject jsonObject = JSONObject.fromObject( map ); 
		        out.print(jsonObject);
		        if(i<v.size()-1){
		        	out.print(",");
		        }
		        
	        }
	        out.print("]");
		}
		catch (Exception e) {
			System.out.println("服务器异常！");
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
