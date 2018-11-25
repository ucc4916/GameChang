package service;

import java.sql.*;
import static db.JdbcUtil.*;
import bean.Loginbean;
import dao.LoginDAO;

public class UpdateService {


	public Loginbean up(Loginbean login) {
		LoginDAO loginDAO=LoginDAO.getInstance();
		Connection con=getConnection();
		loginDAO.setConnection(con);
		int list=loginDAO.update(login);
		if(list>0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		Loginbean writeUP=	loginDAO.select(login);

		return writeUP;
	}
	
	public String update(String id) {
		LoginDAO loginDAO=LoginDAO.getInstance();
		Connection con=getConnection();
		loginDAO.setConnection(con);
		String pass=loginDAO.passUp(id);
		close(con);
		
		return pass;
	}

}
