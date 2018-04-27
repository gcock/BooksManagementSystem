package com.gcockn.sevice.imp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gcockn.connectDatabase.AdminConnect;
import com.gcockn.pojo.Admin;
import com.gcockn.service.AdminService;

public class AdminServiceImp implements AdminService{

	@Override
	public int insertAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAdmin(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void selectOne(String name, String password,HttpServletRequest req, HttpServletResponse resp){
		if(name==null||password==null||name==""||password==""){
			req.setAttribute("msg", "请输入账号密码");
			try {
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}else{
			Admin admin = AdminConnect.selectOne(name, password);
			if(admin.getName()==null){
				try {
					req.setAttribute("msg","用户名或密码错误");
					req.getRequestDispatcher("login.jsp").forward(req, resp);
					return;
				} catch (IOException | ServletException e) {
					e.printStackTrace();
				}
				
			}		
			try {
				HttpSession session = req.getSession();
				session.setAttribute("admin", admin);
				req.getRequestDispatcher("main.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			System.out.println("管理员的信息是:"+admin.getName()+admin.getEmail());
				
			}
		}
		

	@Override
	public void selectAll() {
		// TODO Auto-generated method stub
		
	}
}
