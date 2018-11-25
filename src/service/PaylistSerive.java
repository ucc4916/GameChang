package service;

import bean.Informationbean;
import dao.InformationDAO;
import java.sql.*;
import java.util.ArrayList;

import static db.JdbcUtil.*;
public class PaylistSerive {

	public ArrayList<Informationbean> pay(String info, String money) {
InformationDAO inforDAO=InformationDAO.getInstance();
Connection con=getConnection();
inforDAO.setConnection(con);
ArrayList<Informationbean> list=inforDAO.list(info,money);
close(con);
		
		
		
		return list;
	}

	

	

}
