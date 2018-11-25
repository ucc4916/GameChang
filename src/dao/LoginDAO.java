package dao;

import static db.JdbcUtil.close;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Loginbean;

public class LoginDAO {
	private static LoginDAO LoginDAO;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	int insetResult=0;

	private LoginDAO() {
		
	}
	
	public static LoginDAO getInstance() {
		if(LoginDAO==null) {
			LoginDAO=new LoginDAO();
		}
	return LoginDAO;
	}
	
	public void setConnection(Connection con) {
		this.con=con;
	}
	
	//로그인 용
	public String login(Loginbean login) {
		String loginId=null;
		String sql="select * from login where id=? and password=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,login.getId());
			pstmt.setString(2,login.getPassword());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				loginId=rs.getString("id");
			}
		} catch(Exception e) {
			System.out.println("Login오류!"+e);
		} finally {
			close(pstmt);
		}
		return loginId;
	}
	//회원가입용
	public int join(Loginbean login) {
		String sql="insert into login values(?,?,?,?,?,?,?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,login.getId());
			pstmt.setString(2,login.getPassword());
			pstmt.setString(3,login.getName());
			pstmt.setString(4,login.getEmail());
			pstmt.setString(5,login.getPhonenum());
			pstmt.setString(6,login.getAddress());
			pstmt.setString(7,login.getDay());
			pstmt.setString(8,login.getPay());
			pstmt.setString(9,login.getCost());
			insetResult=pstmt.executeUpdate();
		} catch(Exception e){
			System.out.println("join오류!"+e);
		} finally {
			try {
				close(pstmt);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return insetResult;
		
	}
	
	public String find(Loginbean login) {
		String loginPw=null;
		String sql="select password from login where id=? and name=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,login.getId());
			pstmt.setString(2,login.getName());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				loginPw=rs.getString("password");
			}
		} catch(Exception e) {
			System.out.println("찾기오류!"+e);
		} finally {
			close(pstmt);
		}
		
		return loginPw;
	}
	
	public int delete(String delId) {
		String sql="delete login where id=?";
		int deleteResult=0;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, delId);
	
			deleteResult=pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("delete 오류!!"+e);
		} finally {
			close(pstmt);
		}
		return deleteResult;	
	}
	
	public Loginbean view(String viewId) {
		String sql="select * from login where id=?";
		Loginbean lo=null;
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, viewId);
			rs=pstmt.executeQuery();
		if(rs.next()) {
			lo=new Loginbean();
			lo.setId(rs.getString("id"));
			lo.setName(rs.getString("name"));
			lo.setEmail(rs.getString("email"));
			lo.setPhonenum(rs.getString("phonenum"));
			lo.setAddress(rs.getString("address"));
			lo.setDay(rs.getString("day"));
			lo.setPay(rs.getString("pay"));
		}
		
		} catch(Exception e) {
			System.out.println("오류!!"+e);
			} finally {
				close(rs);
				close(pstmt);
			}
			
			return lo;
	}
	
	public int update(Loginbean login) {
		int update=0;
		
		String sql="update login set name=?,email=?,pay=?,day=?,phonenum=?,address=? where id=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(7, login.getId());
			pstmt.setString(1,login.getName());
			pstmt.setString(2,login.getEmail());
			pstmt.setString(3,login.getPay());
			pstmt.setString(4,login.getDay());
			pstmt.setString(5, login.getPhonenum());
			pstmt.setString(6, login.getAddress());
	
			update=pstmt.executeUpdate();
		
		
		} catch(Exception e) {
			System.out.println("수정 오류"+e);
		} finally {
			close(pstmt);
		}
		return update;
		
	}

	
	public String passUp(String id) {

		String sql="select password from login where id=?";
		String password=null;
	
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				password=rs.getString("password");
			}
		} catch(Exception e) {
			System.out.println("비밀번호 오류"+e);
		} finally {
			close(pstmt);
		}
	return password;

	}
	
	public Loginbean select(Loginbean login) {

		String sql="select * from login where id=?";
		Loginbean lo=null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, login.getId());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				lo=new Loginbean();
				lo.setId(rs.getString("id"));
				lo.setName(rs.getString("name"));
				lo.setEmail(rs.getString("email"));
				lo.setPhonenum(rs.getString("phonenum"));
				lo.setAddress(rs.getString("address"));
				lo.setDay(rs.getString("day"));
				lo.setPay(rs.getString("pay"));
				
			}
	
		} catch(Exception e) {
			System.out.println("오류!!"+e);
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return lo;
	}
	public ArrayList<Loginbean> list() {
		String sql="select * from login";
		ArrayList<Loginbean> loginlist=new ArrayList<Loginbean>();
		Loginbean lb=null;
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					lb=new Loginbean();
					lb.setId(rs.getString("id"));
					lb.setName(rs.getString("name"));
					lb.setEmail(rs.getString("email"));
					lb.setPhonenum(rs.getString("phonenum"));
					lb.setAddress(rs.getString("address"));
					lb.setDay(rs.getString("day"));
					lb.setPay(rs.getString("pay"));
					loginlist.add(lb);
					
					
					
					
			}while(rs.next());
		}
		}
	catch(Exception e) {
		System.out.println("list 오류!"+e);
	}finally {
		close(rs);
		close(pstmt);
		
	}
		return loginlist;
	}
	public int deleteone(String id) {
		String sql="delete login where id=?";
		int deleteResult=0;
		try {
	pstmt=con.prepareStatement(sql);
	pstmt.setString(1, id);
	//Delete,update,insert는 executeUpdate사용
	deleteResult=pstmt.executeUpdate();
		}catch(Exception e) {
	System.out.println("deleteMember 오류!!"+e);
	}finally {
		
		close(pstmt);
		
		
	}
		return deleteResult;
	}
		

			
		

			
}
