package service;

import java.util.ArrayList;
import static db.JdbcUtil.*;
import bean.Loginbean;
import dao.LoginDAO;
import java.sql.Connection;
public class ListService {

	public ArrayList<Loginbean> list(String viewId) {
LoginDAO loginDAO=LoginDAO.getInstance();
Connection con=getConnection();
loginDAO.setConnection(con);
ArrayList<Loginbean> Loginlist=loginDAO.list();	
		
close(con);

		
		return Loginlist;
	}

}
