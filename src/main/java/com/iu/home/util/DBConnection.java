package com.iu.home.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	
	
	//getConnection
	public static Connection getConnection() throws Exception{
		
		
		//1.연결 정보
		String user= "user02";
		
		String password = "user02";
		
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		
		String driver ="oracle.jdbc.driver.OracleDriver";
		//2. Driver를 메모리에 로딩
		
		Class.forName(driver);
		
		//3.DB 연결
		return DriverManager.getConnection(url,user,password);
		
		
		
	}
public static Connection getConnection1() throws Exception{
		
		
		//1.연결 정보
		String user= "user01";
		
		String password = "user01";
		
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		
		String driver ="oracle.jdbc.driver.OracleDriver";
		//2. Driver를 메모리에 로딩
		
		Class.forName(driver);
		
		//3.DB 연결
		return DriverManager.getConnection(url,user,password);
		
		
		
	}
	
	//배포전 삭제
//	public static void main(String[] args) {
//		
//		try {
//			Connection con = DBConnection.getConnection();
//			System.out.println(con != null);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	public static void disConnection(PreparedStatement st,Connection con) throws Exception{
		st.close();
		con.close();
	}
	
	public static void disConnection(ResultSet rs,PreparedStatement st,Connection con) throws Exception{
		rs.close();
		st.close();
		con.close();
	}
	
	
	
}
