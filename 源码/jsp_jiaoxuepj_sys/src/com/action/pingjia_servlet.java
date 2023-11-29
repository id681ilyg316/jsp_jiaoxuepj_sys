package com.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DB;
import com.orm.TAdmin;
import com.orm.Tpingjia;
import com.orm.Tstu;
import com.orm.Ttea;
import com.service.liuService;

public class pingjia_servlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String type = req.getParameter("type");

		if (type.endsWith("pingjiaAdd")) {
			pingjiaAdd(req, res);
		}

		if (type.endsWith("pingjiaMana")) {
			pingjiaMana(req, res);
		}
	}

	public void pingjiaAdd(HttpServletRequest req, HttpServletResponse res) {
		String pingjia_id = String.valueOf(new Date().getTime());
		int tea_id = Integer.parseInt(req.getParameter("tea_id"));
		int zongfenshu = 0;
		String shijian = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		int stu_id = ((Tstu) (req.getSession().getAttribute("stu"))).getId();

		if ("yipingjia".equals(liuService.panduan_shifou_pingjia(tea_id, stu_id))) {
			req.setAttribute("msg", "你已经评价过该老师。不能重发评价");
		}
		if ("weipingjia".equals(liuService.panduan_shifou_pingjia(tea_id, stu_id))) {
			String zhibiao_id = req.getParameter("zhibiao_id");
			String[] zhibiao_id1 = zhibiao_id.split(",");
			for (int i = 0; i < zhibiao_id1.length; i++) {
				int zhibiao_id2 = Integer.parseInt(zhibiao_id1[i]);
				int fenshu = Integer.parseInt(req.getParameter(String.valueOf(zhibiao_id2)));
				zongfenshu += fenshu;

				System.out.println(zhibiao_id2 + "^^" + fenshu);
				liuService.save_pingjia_xuanxiang(zhibiao_id2, fenshu, pingjia_id);
			}

			liuService.save_pingjia(pingjia_id, tea_id, zongfenshu, shijian, stu_id);

			req.setAttribute("msg", "评价完毕");
		}

		String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
	}

	public void pingjiaMana(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List pingjiaList = new ArrayList();
		String sql = "select * from t_pingjia order by tea_id";
		Object[] params = {};
		DB mydb = new DB();
		try {
			mydb.doPstm(sql, params);
			ResultSet rs = mydb.getRs();
			while (rs.next()) {
				Tpingjia pingjia = new Tpingjia();
				pingjia.setId(rs.getString("id"));
				pingjia.setTea_id(rs.getInt("tea_id"));
				pingjia.setZongfenshu(rs.getInt("zongfenshu"));
				pingjia.setShijian(rs.getString("shijian"));
				pingjia.setStu_id(rs.getInt("stu_id"));

				pingjia.setTea(liuService.getTea(rs.getInt("tea_id")));
				pingjia.setStu(liuService.getStu(rs.getInt("stu_id")));
				pingjiaList.add(pingjia);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mydb.closed();

		req.setAttribute("pingjiaList", pingjiaList);
		req.getRequestDispatcher("admin/pingjia/pingjiaMana.jsp").forward(req, res);
	}

	public void dispatch(String targetURI, HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(targetURI);
		try {
			dispatch.forward(request, response);
			return;
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void destroy() {

	}
}
