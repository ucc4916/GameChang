package db;

import javax.naming.Context;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
//db와 관련된 기능들을 static 메소드로 정희해놓은 클래스
public class jdbc {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Context initCtx=new InitialContext();
			Context envCtx=(Context)initCtx.lookup("java:comp/env");
			DataSource ds=(DataSource)envCtx.lookup("jdbc/OracleDB");
			System.out.println("test1");
			con=ds.getConnection();
			System.out.println("test2");
			con.setAutoCommit(false);
			System.out.println("connect success");
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return con;
		
		
		
		
	}
	public static void close(Connection con) {
		try {con.close();}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public static void close(Statement stmt) {
		try {stmt.close();}
		catch(Exception e) {
			e.printStackTrace();
		}}
	public static void close(ResultSet rs) {
		try {rs.close();}
		catch(Exception e) {
			e.printStackTrace();
		}}
	public static void commit(Connection con) {
		try {con.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void rollback(Connection con) {
		try {con.rollback();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
		
	}

