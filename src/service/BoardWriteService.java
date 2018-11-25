package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import bean.BoardBean;
import dao.BoardDAO;

public class BoardWriteService {
	
	public boolean registArticle(BoardBean boardBean) {
		//DB접속
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		boolean WriteResult = false;
		
		int insertCount = boardDAO.registArticle(boardBean);
		
		if(insertCount>0) {
			WriteResult = true;
			commit(con); //현재 접속한걸로 commit 함
		} else {
			WriteResult = false;
			rollback(con);
		}
		
		return WriteResult;
		
	}

}
