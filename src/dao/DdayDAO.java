package dao;

import static db.JdbcUtil.close;

import java.net.Authenticator.RequestorType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Ddaybean;

public class DdayDAO {
	private static DdayDAO DdayDAO;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	int insetResult=0;
	private DdayDAO() {
		
	}
	public static DdayDAO getInstance() {
		if(DdayDAO==null) {
			DdayDAO=new DdayDAO();
		}
	return DdayDAO;
	}
	public void setConnection(Connection con) {
		this.con=con;
	}
	public int update(Ddaybean Dday) {
		String sql="insert into Dday values(?,?,?,?,?,sysdate,sysdate+?,?)";
		try {
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,Dday.getId());	
		pstmt.setInt(2,Dday.getCost());
		pstmt.setInt(3,Dday.getPay());
		pstmt.setInt(4,Dday.getCountday());
		pstmt.setString(5,Dday.getInformation());
		pstmt.setInt(6,Dday.getCountday());
		pstmt.setInt(7,Dday.getPay2());
		insetResult=pstmt.executeUpdate();
		
		}catch(Exception e){
			System.out.println("갱신오류!"+e);
		}finally {}
			try {
				close(pstmt);
			}catch(Exception e){
				System.out.println("o");
				e.printStackTrace();
			}
		
		
		return insetResult;
	}
	public Ddaybean view(String viewId) {
		String sql="select * from Dday where id=?";
		Ddaybean day=null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,viewId);
			rs=pstmt.executeQuery();
		if(rs.next()) {
			day=new Ddaybean();
			day.setId(rs.getString("id"));
			day.setCost(rs.getInt("cost"));
			day.setPay(rs.getInt("pay"));
			day.setCountday(rs.getInt("countday"));
			day.setStartday(rs.getDate("startday"));
			day.setEndday(rs.getDate("endday"));
		day.setPay2(rs.getInt("pay2"));
		}
		
		}catch(Exception e) {
			System.out.println("오류!!"+e);
			}finally {
				close(rs);
				close(pstmt);
			}
			
			return day;
		
		
		
	}
	public ArrayList<Ddaybean> list(String viewId) {
		String sql="select * from Dday where id=?";
		ArrayList<Ddaybean> daylist =new ArrayList<Ddaybean>();
		Ddaybean day=null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,viewId);
			rs=pstmt.executeQuery();
		if(rs.next()) {
			do {
		
			day=new Ddaybean();
			day.setId(rs.getString("id"));
			day.setCost(rs.getInt("cost"));
			day.setPay(rs.getInt("pay"));
			day.setCountday(rs.getInt("countday"));
			day.setInformation(rs.getString("information"));
			day.setStartday(rs.getDate("startday"));
			day.setEndday(rs.getDate("endday"));
			day.setPay2(rs.getInt("pay2"));
		daylist.add(day);
		}while(rs.next());
			}
		
		
		
	}catch(Exception e) {
		System.out.println("list 오류!"+e);
	}finally {
		close(rs);
		close(pstmt);
		
	}
		return daylist;
	}
	
	
	
	
}
