package com.util;

import java.io.IOException; 

import javax.servlet.FilterChain; 
import javax.servlet.FilterConfig; 
import javax.servlet.ServletException; 
import javax.servlet.ServletRequest; 
import javax.servlet.ServletResponse; 

public class Filter implements javax.servlet.Filter { 

	public void destroy() {
		
	} 

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException { 
		request.setCharacterEncoding("utf-8"); 
		chain.doFilter(request, response); 
	} 
	public void init(FilterConfig arg0) throws ServletException { 
		System.out.println("filter--------init?"); 
		} 

} 