package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.BoardBean;
import service.BoardReplyService;

public class BoardReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		BoardBean boardBean = new BoardBean();
		
		boardBean.setBOARD_NUM(Integer.parseInt(request.getParameter("BOARD_NUM")));
		boardBean.setBOARD_ID(request.getParameter("BOARD_ID"));
		boardBean.setBOARD_PASS(request.getParameter("BOARD_PASS"));
		boardBean.setBOARD_TYPE(request.getParameter("BOARD_TYPE"));
		boardBean.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
		boardBean.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
		boardBean.setBOARD_RE_REF(Integer.parseInt(request.getParameter("BOARD_RE_REF")));
		boardBean.setBOARD_RE_LEV(Integer.parseInt(request.getParameter("BOARD_RE_LEV")));
		boardBean.setBOARD_RE_SEQ(Integer.parseInt(request.getParameter("BOARD_RE_SEQ")));
		boardBean.setBOARD_ANSER(request.getParameter("BOARD_ANSER"));
		BoardReplyService boardReplyService = new BoardReplyService();
		boolean ReplySuccess = boardReplyService.replyArticle(boardBean);
		
		if(ReplySuccess) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("boardList.bo");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('문의 답글작성 실패')");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;
	}

}
