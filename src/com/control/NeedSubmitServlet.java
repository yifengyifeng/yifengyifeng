package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Need;
import com.service.NeedService;
import com.service.impl.NeedServiceImpl;

public class NeedSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static NeedService needService =new NeedServiceImpl();
    public NeedSubmitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Need need=new Need();
		PrintWriter out=response.getWriter();
		String jgmc=URLDecoder.decode((String)request.getParameter("jgmc"),"UTF-8");
		String txdz=URLDecoder.decode((String)request.getParameter("txdz"),"UTF-8");
		String dwwz=URLDecoder.decode((String)request.getParameter("dwwz"),"UTF-8");
		String dzxx=URLDecoder.decode((String)request.getParameter("dzxx"),"UTF-8");
		String frdb=URLDecoder.decode((String)request.getParameter("frdb"),"UTF-8");
		String yzbm=URLDecoder.decode((String)request.getParameter("yzbm"),"UTF-8");
		String lxr=URLDecoder.decode((String)request.getParameter("lxr"),"UTF-8");
		String lxrdh=URLDecoder.decode((String)request.getParameter("lxrdh"),"UTF-8");
		String jgsx=URLDecoder.decode((String)request.getParameter("jgsx"),"UTF-8");
		String jgjj=URLDecoder.decode((String)request.getParameter("jgjj"),"UTF-8");
		String jsxqmc=URLDecoder.decode((String)request.getParameter("jsxqmc"),"UTF-8");
		String xqgs=URLDecoder.decode((String)request.getParameter("xqgs"),"UTF-8");
		String yjlx=URLDecoder.decode((String)request.getParameter("yjlx"),"UTF-8");
		String xkfl=URLDecoder.decode((String)request.getParameter("xkfl"),"UTF-8");
		String ly=URLDecoder.decode((String)request.getParameter("ly"),"UTF-8");
		String yyhy=URLDecoder.decode((String)request.getParameter("yyhy"),"UTF-8");
		String hzms=URLDecoder.decode((String)request.getParameter("hzms"),"UTF-8");
		int xmzj=Integer.parseInt(URLDecoder.decode((String)request.getParameter("xmzj"),"UTF-8"));
		String tjyh=URLDecoder.decode((String)request.getParameter("tjyh"),"UTF-8");
		int qsxqnf=Integer.parseInt(URLDecoder.decode((String)request.getParameter("qsxqnf"),"UTF-8"));
		int jzxqnf=Integer.parseInt(URLDecoder.decode((String)request.getParameter("jzxqnf"),"UTF-8"));
		String gkglbm=URLDecoder.decode((String)request.getParameter("gkglbm"),"UTF-8");
		String szdy=URLDecoder.decode((String)request.getParameter("szdy"),"UTF-8");
		
		Date date = new Date();  
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");  
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss"); 
		String d1 = sdf1.format(date); 
		String d2 = sdf2.format(date); 
		String tjsj=d1;
		String state="未审核";
		String num="HBZDJSXQ"+d2;

		need.setJgmc(jgmc);
		need.setTxdz(txdz);
		need.setDwwz(dwwz);
		need.setDzxx(dzxx);
		need.setFrdb(frdb);
		need.setYzbm(yzbm);
		need.setLxr(lxr);
		need.setLxrdh(lxrdh);
		need.setJgsx(jgsx);
		need.setJgjj(jgjj);
		need.setJsxqmc(jsxqmc);
		need.setXqgs(xqgs);
		need.setYjlx(yjlx);
		need.setXkfl(xkfl);
		need.setLy(ly);
		need.setYyhy(yyhy);
		need.setHzms(hzms);
		need.setXmzj(xmzj);
		need.setTjyh(tjyh);
		need.setTjsj(tjsj);
		need.setState(state);
		need.setNum(num);
		need.setQsxqnf(qsxqnf);
		need.setJzxqnf(jzxqnf);
		need.setGkglbm(gkglbm);
		need.setSzdy(szdy);
		
		try {
			needService.addNeed(need);
			out.flush();
			out.print("填报成功！");
		} 
		catch (Exception e) {
			out.flush();
			out.print("填报失败！"+e.getMessage());
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
