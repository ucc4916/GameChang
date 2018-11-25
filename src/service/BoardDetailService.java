package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import bean.BoardBean;
import dao.BoardDAO;

public class BoardDetailService {
	
	public BoardBean getArticle(int boardNum) {
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		BoardBean article = null;
		
		//조회수 올리기
		int updateCount = boardDAO.updateCount(boardNum);
		
		if(updateCount>0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		//선택된 게시글 정보 가져오기
		article = boardDAO.selectArticle(boardNum);
		close(con);
		
		return article;
	}
}
