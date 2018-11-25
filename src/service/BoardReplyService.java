package service;

import java.sql.Connection;

import bean.BoardBean;
import dao.BoardDAO;

import static db.JdbcUtil.*;

public class BoardReplyService {
	
	public boolean replyArticle(BoardBean boardBean) {
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		int replyCount = boardDAO.insertReply(boardBean);
		
		boolean replySuccess = false;
		
		if(replyCount>0) {
			replySuccess = true;
			commit(con);
		} else {
			replySuccess = false;
			rollback(con);
		}
		
		return replySuccess;
		
		
	}
}
