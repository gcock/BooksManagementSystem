package com.gcockn.connectDatabase;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectDatabase {
	private static String driverName;
	private static String url;
	private static String urlSecond;
	private static String userName;
	private static String password;

	static {
		try {
			InputStream in = ConnectDatabase.class.getClassLoader().getResourceAsStream("database.properties");
			Properties properties = new Properties();
			properties.load(in);
			driverName = properties.getProperty("driverName");
			url = properties.getProperty("url");
			urlSecond = properties.getProperty("urlSecond");
			userName = properties.getProperty("userName");
			password = properties.getProperty("password");
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 根据database.properties连接默认数据库
	public static Connection getDatabseConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库连接失败");
		}
		return connection;

	}

	// 根据数据库名连接数据库
	public static Connection getConnection(String databaseName) {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(urlSecond + ";DatabaseName=" + databaseName, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库连接失败");
		}
		return connection;

	}

	// 释放资源
	public static void closeConnect(ResultSet rSet, PreparedStatement stm, Connection con) {
		try {
			if (rSet != null) {
				rSet.close();
			}
			if (stm != null) {
				stm.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("关闭失败");
		}
	}

	// 释放资源
	public static void closeConnect(PreparedStatement stm, Connection con) {
		try {
			if (stm != null) {
				stm.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
