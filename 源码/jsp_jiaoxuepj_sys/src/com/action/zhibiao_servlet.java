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
import com.orm.Ttea;
import com.orm.Tzhibiao;

public class zhibiao_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		if(type.endsWith("zhibiaoMana"))
		{
			zhibiaoMana(req, res);
		}
		if(type.endsWith("zhibiaoAdd"))
		{
			zhibiaoAdd(req, res);
		}
		if(type.endsWith("zhibiaoDel"))
		{
			zhibiaoDel(req, res);
		}
		
		if(type.endsWith("zhibiaoAll"))
		{
			zhibiaoAll(req, res);
		}
	}
	
	
	public void zhibiaoAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String mingcheng=req.getParameter("mingcheng");
		int fenshu=Integer.parseInt(req.getParameter("fenshu"));
		String del="no";
		
		String sql="insert into t_zhibiao(mingcheng,fenshu,del) values(?,?,?)";
		Object[] params={mingcheng,fenshu,del};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "zhibiao?type=zhibiaoMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void zhibiaoDel(HttpServletRequest req,HttpServletResponse res)
	{
		String sql="update t_zhibiao set del='yes' where id="+Integer.parseInt(req.getParameter("id"));
		Object[] params={};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "zhibiao?type=zhibiaoMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void zhibiaoMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List zhibiaoList=new ArrayList();
		String sql="select * from t_zhibiao where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tzhibiao zhibiao=new Tzhibiao();
				zhibiao.setId(rs.getInt("id"));
				zhibiao.setMingcheng(rs.getString("mingcheng"));
				zhibiao.setFenshu(rs.getInt("fenshu"));
				zhibiao.setDel(rs.getString("del"));
				zhibiaoList.add(zhibiao);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("zhibiaoList", zhibiaoList);
		req.getRequestDispatcher("admin/zhibiao/zhibiaoMana.jsp").forward(req, res);
	}
	
	public void zhibiaoAll(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List zhibiaoList=new ArrayList();
		String sql="select * from t_zhibiao where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tzhibiao zhibiao=new Tzhibiao();
				zhibiao.setId(rs.getInt("id"));
				zhibiao.setMingcheng(rs.getString("mingcheng"));
				zhibiao.setFenshu(rs.getInt("fenshu"));
				zhibiao.setDel(rs.getString("del"));
				zhibiaoList.add(zhibiao);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("zhibiaoList", zhibiaoList);
		req.getRequestDispatcher("astu/zhibiao/zhibiaoAll.jsp").forward(req, res);
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
