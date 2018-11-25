package service;

import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.*;

import java.sql.*;

import bean.Loginbean;
import dao.LoginDAO;

public class ViewSerive {

	public Loginbean view(String viewId) {
		LoginDAO loginDAO=LoginDAO.getInstance();
		Connection con=getConnection();
		loginDAO.setConnection(con);
		Loginbean login=loginDAO.view(viewId);
		close(con);
		return login;
	}
}
