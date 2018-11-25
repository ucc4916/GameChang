package service;

import static db.JdbcUtil.*;

import java.sql.*;
import java.util.ArrayList;

import bean.BoardBean;
import dao.BoardDAO;

public class BoardListService {

	public ArrayList<BoardBean> getBoardList(String id){
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		ArrayList<BoardBean> boardList = boardDAO.getBoardList(id);
		close(con);
		
		return boardList;
	}

	public ArrayList<BoardBean> getBoard() {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		ArrayList<BoardBean> boardList = boardDAO.getBoard();
		close(con);
		
		return boardList;

	}
	
}
