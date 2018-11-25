package service;

import static db.JdbcUtil.*;


import java.sql.Connection;

import dao.LoginDAO;

public class DeleteService {

	public boolean deleteon(String delId) {
		LoginDAO loginDAO=LoginDAO.getInstance();
		Connection con=getConnection();
		loginDAO.setConnection(con);
		boolean deleteResult=false;
		int deleteCount=loginDAO.delete(delId);
		
		if(deleteCount>0) {
			commit(con);
			deleteResult=true;
		} else {
			rollback(con);
			deleteResult=false;
		}
		
		close(con);
		return deleteResult;
	}

	public boolean deleteone(String id) {
		LoginDAO loginDAO=LoginDAO.getInstance();
		Connection con=getConnection();
		loginDAO.setConnection(con);
		boolean deleteResult=false;
		int deleteCount=loginDAO.deleteone(id);
		
		if(deleteCount>0) {
			commit(con);
			deleteResult=true;
		} else {
			rollback(con);
			deleteResult=false;
		}
		
		close(con);
		return deleteResult;
	}
}
