package com.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DB;
import com.orm.TAdmin;
import com.orm.Tstu;

public class stu_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		if(type.endsWith("stuAdd"))
		{
			stuAdd(req, res);
		}
		if(type.endsWith("stuDel"))
		{
			stuDel(req, res);
		}
		if(type.endsWith("stuMana"))
		{
			stuMana(req, res);
		}
		
		if(type.endsWith("stuEdit_stu"))
		{
			stuEdit_stu(req, res);
		}
	}
	
	
	public void stuAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String xuehao=req.getParameter("xuehao");
		String name1=req.getParameter("name1");
		String sex=req.getParameter("sex");
		int age=Integer.parseInt(req.getParameter("age"));
		String loginname=req.getParameter("loginname");
		String loginpw=req.getParameter("loginpw");
		String del="no";
		
		String sql="insert into t_stu(xuehao,name1,sex,age,loginname,loginpw,del) values(?,?,?,?,?,?,?)";
		Object[] params={xuehao,name1,sex,age,loginname,loginpw,del};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "stu?type=stuMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void stuDel(HttpServletRequest req,HttpServletResponse res)
	{
		String sql="update t_stu set del='yes' where id="+Integer.parseInt(req.getParameter("id"));
		Object[] params={};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "stu?type=stuMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void stuMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List stuList=new ArrayList();
		String sql="select * from t_stu where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tstu stu=new Tstu();
				stu.setId(rs.getInt("id"));
				stu.setXuehao(rs.getString("xuehao"));
				stu.setName1(rs.getString("name1"));
				stu.setSex(rs.getString("sex"));
				stu.setAge(rs.getInt("age"));
				stu.setLoginname(rs.getString("loginname"));
				stu.setLoginpw(rs.getString("loginpw"));
				stuList.add(stu);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("stuList", stuList);
		req.getRequestDispatcher("admin/stu/stuMana.jsp").forward(req, res);
	}
	
	
	public void stuEdit_stu(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String xuehao=req.getParameter("xuehao");
		String name1=req.getParameter("name1");
		String sex=req.getParameter("sex");
		int age=Integer.parseInt(req.getParameter("age"));
		String loginname=req.getParameter("loginname");
		String loginpw=req.getParameter("loginpw");
		
		String sql="update t_stu set xuehao=?,name1=?,sex=?,age=?,loginname=?,loginpw=? where id="+Integer.parseInt(req.getParameter("id"));
		Object[] params={xuehao,name1,sex,age,loginname,loginpw};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("msg", "修改成功。重新登录后生效");
        String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void dispatch(String targetURI,HttpServletRequest request,HttpServletResponse response) 
	{
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(targetURI);
		try 
		{
		    dispatch.forward(request, response);
		    return;
		} 
		catch (ServletException e) 
		{
                    e.printStackTrace();
		} 
		catch (IOException e) 
		{
			
		    e.printStackTrace();
		}
	}
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
	}
	
	public void destroy() 
	{
		
	}
}
