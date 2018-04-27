package com.gcockn.connectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.gcockn.pojo.Admin;

public class AdminConnect {

	private static Connection con;
	private static PreparedStatement stm;
	private static ResultSet rSet;
	
	//查询所有的管理员
	public static List<Admin> selectAll(){
	
		return null;
	}
	
	//根据账号密码查询管理员
	public static Admin selectOne(String name,String password){
		
		String sql="select * from admin where (telephone=? and password=?) or (email=? and password=?)";
		Admin admin = new Admin();
		try {
			con = ConnectDatabase.getDatabseConnection();
			stm = con.prepareStatement(sql);
			stm.setString(1,name);
			stm.setString(2,password);
			stm.setString(3,name);
			stm.setString(4,password);
			rSet = stm.executeQuery();
			while(rSet.next()){
				admin.setId(rSet.getInt("id"));
				admin.setName(rSet.getString("name"));
				admin.setPassword(rSet.getString("password"));
				admin.setSex(rSet.getString("sex"));
				admin.setEmail(rSet.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectDatabase.closeConnect(rSet, stm, con);
		}
		return admin;
		
		
	}
}
