package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;
import bean.BoardBean;
import service.BoardListService;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		String id=(String) session.getAttribute("id");
		
		ActionForward forward = null;
		if(id.equals("admin")) {
			forward=new ActionForward();
			BoardListService boardListService = new BoardListService();
			ArrayList<BoardBean> boardList = boardListService.getBoard();
			request.setAttribute("boardList", boardList);
			forward = new ActionForward();
			forward.setPath("CustomerService_List.jsp");
		}else {
		BoardListService boardListService = new BoardListService();
		ArrayList<BoardBean> boardList = boardListService.getBoardList(id); //세션값 선언 해줘야되고.
		request.setAttribute("boardList", boardList);
		
		forward = new ActionForward();
		forward.setPath("CustomerService_List.jsp");
		}
		return forward;
	}

}
