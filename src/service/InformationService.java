package service;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import bean.Informationbean;
import dao.InformationDAO;

public class InformationService {

	public ArrayList<Informationbean> information() {
		Connection con = getConnection();
		InformationDAO informationDAO = InformationDAO.getInstance();
		informationDAO.setConnection(con);
		
		ArrayList<Informationbean> InformationResult = informationDAO.information();

		return InformationResult;
	}
}
