package com.gcockn.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gcockn.pojo.Admin;

public interface AdminService {

	int insertAdmin(Admin admin);
	
	int deleteAdmin(Integer id);
	
	int updateAdmin(Admin admin);
	
	void selectAll();
	
	void selectOne(String name, String password, HttpServletRequest req, HttpServletResponse resp);
}
