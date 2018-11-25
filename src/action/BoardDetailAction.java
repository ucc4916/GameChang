package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.BoardBean;
import service.BoardDetailService;

public class BoardDetailAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int boardNum = Integer.parseInt(request.getParameter("boardNum")); //"boardNum"가
																//boardList.jsp의 a 태그 링크값(boardDetail.bo?boardNum)과 같아야됌
		BoardDetailService boardDetailService = new BoardDetailService();
		BoardBean boardView = boardDetailService.getArticle(boardNum);
		request.setAttribute("boardView", boardView);
		ActionForward forward = new ActionForward();
		forward.setPath("CustomerService_View.jsp");
		
		return forward;
	}
}
