package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import bean.Loginbean;
import dao.LoginDAO;

public class LoginService {

	public boolean login(Loginbean login) {
		LoginDAO loginDAO=LoginDAO.getInstance();
		Connection con=getConnection();	
		loginDAO.setConnection(con);
		String loginId=loginDAO.login(login);
	
		boolean LoginRsult=false;
		if(loginId!=null) {
			LoginRsult=true;
		} else{
			LoginRsult=false;
		}
		close(con);
		return LoginRsult;
	}

}
