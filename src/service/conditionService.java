package service;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import bean.Informationbean;
import dao.InformationDAO;

public class conditionService {

	public ArrayList<Informationbean> condition(
			String[] village,
			String[] calendar,
			String[] dayofweek,
			String[] day) {
		
		Connection con = getConnection();
		InformationDAO informationDAO = InformationDAO.getInstance();
		informationDAO.setConnection(con);
		ArrayList<Informationbean> conditionResult = informationDAO.condition(village,calendar,dayofweek,day);

		return conditionResult;
	}
	

}
