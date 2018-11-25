package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import bean.ActionForward;
import bean.BoardBean;
import service.BoardDetailService;

public class BoardReplyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		BoardDetailService boardDetailService = new BoardDetailService();
		BoardBean boardBean = boardDetailService.getArticle(boardNum);
		
		request.setAttribute("boardView", boardBean);
		
		ActionForward forward = new ActionForward();
		forward.setPath("CustomerService_Reply.jsp");
		
		return forward;
	}

}
