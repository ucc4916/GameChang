package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import bean.Ddaybean;
import dao.DdayDAO;

public class DdayService {

	public boolean update(Ddaybean Dday) {
		DdayDAO ddayDAO=DdayDAO.getInstance();
		Connection con=getConnection();
		ddayDAO.setConnection(con);
	boolean DdayRsult=false;
	int result=ddayDAO.update(Dday);
	if(result!=0) {
		DdayRsult=true;
		commit(con);
	} else{
		DdayRsult=false;
		rollback(con);
	}
	close(con);
	return DdayRsult;
		
		
	
	
	}

	public ArrayList<Ddaybean> view(String viewId) {

		DdayDAO ddayDAO=DdayDAO.getInstance();
		Connection con=getConnection();
		ddayDAO.setConnection(con);
		ArrayList<Ddaybean> list=ddayDAO.list(viewId);
		close(con);
		
		
		return list;
	}


}
