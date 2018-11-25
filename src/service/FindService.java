package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import javax.servlet.http.HttpSession;

import bean.Loginbean;
import dao.LoginDAO;

public class FindService {

	public String find(Loginbean login) {
		LoginDAO loginDAO=LoginDAO.getInstance();
		Connection con=getConnection();	
		loginDAO.setConnection(con);
		String loginPw=loginDAO.find(login);

		close(con);
		return loginPw;
	}

}
