package dao;

import static db.JdbcUtil.*;

import java.sql.*;
import java.util.ArrayList;

import javax.sql.*;

import bean.BoardBean;

public class BoardDAO {
	
	DataSource ds;
	Connection con;
	private static BoardDAO boardDAO;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private BoardDAO() {
		
	}
	
	public static BoardDAO getInstance() {
		if(boardDAO==null) {
			boardDAO = new BoardDAO();
		}
		return boardDAO;
	}
	
	public void setConnection(Connection con) {
		this.con=con;
	}
	
	public int registArticle(BoardBean boardBean) {
		int num = 0;
		int insertCount = 0;
		
		String sql1 = "select max(BOARD_NUM) from BOARD";
		String sql2 = "insert into BOARD Values(?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?)";
		
		try {
			//글번호를 1씩 증가시키기 위한 부분
			pstmt = con.prepareStatement(sql1);
			rs = pstmt.executeQuery(); //BOARD_NUM 의 MAX 값이 나옴
			if(rs.next()) {
				num = rs.getInt(1) + 1; //보드넘버 맥스값에 +1 를 해서 num에 넣어라 ex) 12이면 12 + 1 = 13 (num 값)
			} else {
				num = 1; //(아무것도 없으면 1)
			}
			
			//글등록을 위한 부분
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, num);
			pstmt.setString(2, boardBean.getBOARD_ID());
			pstmt.setString(3, boardBean.getBOARD_PASS());
			pstmt.setString(4, boardBean.getBOARD_TYPE());
			pstmt.setString(5, boardBean.getBOARD_SUBJECT());
			pstmt.setString(6, boardBean.getBOARD_CONTENT());
			pstmt.setString(7, boardBean.getBOARD_FILE()); //파일이 들어가는게 아니라 파일이름이 들어감
			pstmt.setInt(8, num);
			pstmt.setInt(9, 0);
			pstmt.setInt(10, 0);
			pstmt.setInt(11, 0);
			pstmt.setString(12,"0");
			
			insertCount = pstmt.executeUpdate();
			System.out.println("글쓰기 성공");
		} catch(Exception e) {
			System.out.println("글 쓰기 오류!! : " + e);
		} finally {
			close(rs);
			close(pstmt);
		} 
		
		return insertCount;
	}

	public ArrayList<BoardBean> getBoardList(String id) {
		String sql = "select * from BOARD where BOARD_ID=? order by BOARD_RE_REF DESC, BOARD_RE_SEQ ASC";
		
		ArrayList<BoardBean> boardList = new ArrayList<BoardBean>();
		
		BoardBean boardBean = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					boardBean = new BoardBean();
					boardBean.setBOARD_NUM(rs.getInt("BOARD_NUM"));
					boardBean.setBOARD_ID(rs.getString("BOARD_ID"));
					boardBean.setBOARD_PASS(rs.getString("BOARD_PASS"));
					boardBean.setBOARD_TYPE(rs.getString("BOARD_TYPE"));
					boardBean.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
					boardBean.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
					boardBean.setBOARD_FILE(rs.getString("BOARD_FILE"));
					boardBean.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
					boardBean.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
					boardBean.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
					boardBean.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
					boardBean.setBOARD_DATE(rs.getDate("BOARD_DATE"));
					boardBean.setBOARD_ANSER(rs.getString("BOARD_ANSER"));
					boardList.add(boardBean);
				}while(rs.next());
			}
		} catch(Exception e) {
			System.out.println("boardList 오류!! : " + e);
		}finally {
			close(rs);
			close(pstmt);
		}
		return boardList;
		
	}
	
	//조회수 올리기 메소드
	public int updateCount(int boardNum) {
		int updateCount = 0;
		String sql = "update BOARD set BOARD_READCOUNT = BOARD_READCOUNT+1 where BOARD_NUM=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			updateCount = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("조회수 올리기 오류 : " + e);
		} finally {
			close(pstmt);
		} return updateCount;
		
	}
	
	//글 상세보기 메소드
	public BoardBean selectArticle(int boardNum) {
		
		BoardBean boardBean = null;
		String  sql = "select * from BOARD where BOARD_NUM = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				boardBean = new BoardBean();
				boardBean.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				boardBean.setBOARD_ID(rs.getString("BOARD_ID"));
				boardBean.setBOARD_PASS(rs.getString("BOARD_PASS"));
				boardBean.setBOARD_TYPE(rs.getString("BOARD_TYPE"));
				boardBean.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				boardBean.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				boardBean.setBOARD_FILE(rs.getString("BOARD_FILE"));
				boardBean.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
				boardBean.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
				boardBean.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
				boardBean.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
				boardBean.setBOARD_DATE(rs.getDate("BOARD_DATE"));
				boardBean.setBOARD_ANSER(rs.getString("BOARD_ANSER"));
			}
		
		} catch(Exception e) {
			System.out.println("글 상세보기 오류  : " + e);
		} finally {
			close(rs);
			close(pstmt);		
		}
		return boardBean;
	}

	public int insertReply(BoardBean boardBean) {
		
		
		 /* 1. BOARD_NUM을 위한 MAX(BOARD_NUM)을 얻어오기. 
		 * 2. BOARD_RE_SEQ을 재조정
		 * 3. 답글 등록
		 */
		
		String sql1 = "select MAX(BOARD_NUM) from BOARD"; //1번째용 쿼리
		String sql2 = "update BOARD set BOARD_RE_SEQ=BOARD_RE_SEQ+1 where BOARD_RE_REF=? and BOARD_RE_SEQ>?"; //2번째용 쿼리. seq값을 업데이트 하겟다. 조건이 re_ref과 re_seq보다 클때.
						//새로등록되는 값들이 기본에 있던 값보다 위에 놓기 위해. ex)원본 - 3번째 작성 답글 - 2번째 작성 답글 - 1번째 작성 답글
		String sql3 = "insert into BOARD Values(?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?)"; //3번째용 쿼리
		
		int num=0;
		int insertCount = 0;
		int re_ref = boardBean.getBOARD_RE_REF();
		int re_lev = boardBean.getBOARD_RE_LEV();
		int re_seq = boardBean.getBOARD_RE_SEQ();
		
		try {
			pstmt = con.prepareStatement(sql1);
			rs = pstmt.executeQuery(); //가장 큰값을 가져와라
			if(rs.next()) {
				num = rs.getInt(1)+1; // 가장 큰값에 +1
			} else {
				num=1;
			}
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, re_ref);
			pstmt.setInt(2, re_seq);
			int updateCount = pstmt.executeUpdate();
			if(updateCount>0) {
				commit(con);
			}
			
			re_seq = re_seq + 1;
			re_lev = re_lev + 1; //re_lev값은 기존 lev이 가지고 있는 값. 1차 답글이다.
			
			pstmt = con.prepareStatement(sql3);
			pstmt.setInt(1, num);
			pstmt.setString(2, boardBean.getBOARD_ID());
			pstmt.setString(3, boardBean.getBOARD_PASS());
			pstmt.setString(4, boardBean.getBOARD_TYPE());
			pstmt.setString(5, boardBean.getBOARD_SUBJECT());
			pstmt.setString(6, boardBean.getBOARD_CONTENT());
			pstmt.setString(7, ""); //파일 업로드 x
			pstmt.setInt(8, re_ref);
			pstmt.setInt(9, re_lev);
			pstmt.setInt(10, re_seq);
			pstmt.setInt(11, 0);
			pstmt.setString(12, boardBean.getBOARD_ANSER());
			insertCount = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("답글 작성 오류 : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return insertCount;
	}

	public ArrayList<BoardBean> getBoard() {
String sql = "select * from BOARD order by BOARD_RE_REF DESC, BOARD_RE_SEQ ASC";
		
		ArrayList<BoardBean> boardList = new ArrayList<BoardBean>();
		
		BoardBean boardBean = null;
		try {
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					boardBean = new BoardBean();
					boardBean.setBOARD_NUM(rs.getInt("BOARD_NUM"));
					boardBean.setBOARD_ID(rs.getString("BOARD_ID"));
					boardBean.setBOARD_PASS(rs.getString("BOARD_PASS"));
					boardBean.setBOARD_TYPE(rs.getString("BOARD_TYPE"));
					boardBean.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
					boardBean.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
					boardBean.setBOARD_FILE(rs.getString("BOARD_FILE"));
					boardBean.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
					boardBean.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
					boardBean.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
					boardBean.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
					boardBean.setBOARD_DATE(rs.getDate("BOARD_DATE"));
					boardBean.setBOARD_ANSER(rs.getString("BOARD_ANSER"));
					boardList.add(boardBean);
				}while(rs.next());
			}
		} catch(Exception e) {
			System.out.println("boardList 오류!! : " + e);
		}finally {
			close(rs);
			close(pstmt);
		}
		return boardList;	
		
		
	}
	
}
