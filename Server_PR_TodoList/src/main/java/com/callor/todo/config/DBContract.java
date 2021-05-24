package com.callor.todo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {
	
	private static Connection dbConn;
	
	static {
		
		String jdbcDriver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "mytodo";
		String password = "mytodo";
		
		if(dbConn == null) {
			try {
				Class.forName(jdbcDriver);
				dbConn = DriverManager.getConnection(url,username,password);
				System.out.println("오라클 접속 완료");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static Connection getDBConnection() {
		
		return dbConn;
	}

}
