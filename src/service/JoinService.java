package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import bean.Loginbean;
import dao.LoginDAO;

public class JoinService {

	public boolean join(Loginbean login) {
		LoginDAO loginDAO=LoginDAO.getInstance();
		Connection con=getConnection();
		loginDAO.setConnection(con);
		boolean joinRsult=false;
		int result=loginDAO.join(login);

		if(result!=0) {
			joinRsult=true;
			commit(con);
		} else{
			joinRsult=false;
			rollback(con);
		}
		close(con);
		return joinRsult;
	}

}
