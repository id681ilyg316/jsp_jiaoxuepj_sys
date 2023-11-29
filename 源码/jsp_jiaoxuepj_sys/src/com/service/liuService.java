package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.DB;
import com.orm.TAdmin;
import com.orm.Tstu;
import com.orm.Ttea;

public class liuService
{
	public static void save_pingjia_xuanxiang(int zhibiao_id,int fenshu,String pingjia_id)
	{
		String sql="insert into t_pingxia_xuanxian(zhibiao_id,fenshu,pingjia_id) values(?,?,?)";
		Object[] params={zhibiao_id,fenshu,pingjia_id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
	}
	
	
	public static void save_pingjia(String id,int tea_id,int zongfenshu,String shijian,int stu_id)
	{
		String sql="insert into t_pingjia(id,tea_id,zongfenshu,shijian,stu_id) values(?,?,?,?,?)";
		Object[] params={id,tea_id,zongfenshu,shijian,stu_id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
	}
	
	
	public static String panduan_shifou_pingjia(int tea_id,int stu_id)
	{
		String result="";
		String sql="select * from t_pingjia where tea_id="+tea_id+" and stu_id="+stu_id;
		Object[] params={};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		try 
		{
			ResultSet rs=mydb.getRs();
			if(rs !=null && rs.next()==true)
			{
				result="yipingjia";
			}
			else
			{
				result="weipingjia";
			}
			
			rs.close();
		} 
		catch (SQLException e)
		{
			System.out.println("µÇÂ¼Ê§°Ü£¡");
			e.printStackTrace();
		}
		finally
		{
			mydb.closed();
		}
		System.out.println(result+"$$$$");
		return result;
	}

	
	public static Ttea getTea(int id)
	{
		Ttea tea=new Ttea();
		
		String sql="select * from t_tea where del='no' and id="+id;
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				
				tea.setId(rs.getInt("id"));
				tea.setBianhao(rs.getString("bianhao"));
				tea.setName(rs.getString("name"));
				tea.setSex(rs.getString("sex"));
				tea.setAge(rs.getInt("age"));
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		return tea;
	}
	
	
	
	public static Tstu getStu(int id)
	{
		Tstu stu=new Tstu();
		
		String sql="select * from t_stu where del='no' and id="+id;
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				stu.setId(rs.getInt("id"));
				stu.setXuehao(rs.getString("xuehao"));
				stu.setName1(rs.getString("name1"));
				stu.setSex(rs.getString("sex"));
				stu.setAge(rs.getInt("age"));
				stu.setLoginname(rs.getString("loginname"));
				stu.setLoginpw(rs.getString("loginpw"));
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		return stu;
	}
}
