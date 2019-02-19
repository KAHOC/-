package com.sp.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;



public class DBHelper {
	private static String driverClass;
	private static String url;
	private static String username;
	private static String password;
	
	//����Դ�ļ�properties�л�ȡ�����������ַ������û���������
	static{
		Properties pro = new Properties();
		InputStream is = DBHelper.class.getClassLoader().getResourceAsStream("mysqljdbc.properties");//��ȡһ��������
		try {
			pro.load(is);  //����������
			driverClass = pro.getProperty("driverClass");//��ȡ��Դ�ļ��е�driverClass
			url = pro.getProperty("url");
			username = pro.getProperty("username");
			password = pro.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//��ȡ���Ӷ���
	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName(driverClass);      //1.��������
			conn = DriverManager.getConnection(url, username, password);  //��ȡ���Ӷ���
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//�ر����Ӷ���
	public static void closeConn(ResultSet rs,PreparedStatement pstmt,Connection conn){
		try{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
}
