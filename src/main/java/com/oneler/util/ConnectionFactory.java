package com.oneler.util;

import java.sql.*;
import java.util.Properties;
/**
 * 用来产生Connection对象的工厂类
 * */
public class ConnectionFactory {
	private static String url;
	private static String driver;
	private static Properties prop;
	/**
	 * 初始化获取数据库连接的参数
	 * 通过读取配置文件实现
	 * */
	static{
		try {
			prop=new Properties();
			prop.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			url=prop.getProperty("url");//获取配置文件中指定键的值
			driver=prop.getProperty("driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 产生Connection对象的方法
	 * @return Connection
	 * */
	public static Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(ResultSet rs,Statement stat,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
			if(stat!=null){
				stat.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println(ConnectionFactory.getConnection());
		Connection conn = ConnectionFactory.getConnection();
		int i = 0;
		String sql = "insert into student (Name,Sex,Age) values(?,?,?)";
	/*	PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1,"zhangsan");
			pstmt.setString(2, "nan");
			pstmt.setString(3, "13");
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}
}