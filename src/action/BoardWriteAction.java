package action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bean.ActionForward;
import bean.BoardBean;
import service.BoardWriteService;

public class BoardWriteAction implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String realPath = "";
		String savePath = "/image"; //파일은 /boardUpload 라는 폴더에 들어감.
		
		int size = 5*1024*1024;
		ServletContext context = request.getServletContext();
		realPath = context.getRealPath(savePath);
		
		MultipartRequest multi = new MultipartRequest(request, realPath, size, "UTF-8", new DefaultFileRenamePolicy());
		
		//boardWrite에서 입력받은 내용을 BoardBean 객체에 저장.
		BoardBean boardBean = new BoardBean();
		
		boardBean.setBOARD_ID(multi.getParameter("BOARD_ID"));
		boardBean.setBOARD_PASS(multi.getParameter("BOARD_PASS"));
		boardBean.setBOARD_TYPE(multi.getParameter("BOARD_TYPE"));
		boardBean.setBOARD_SUBJECT(multi.getParameter("BOARD_SUBJECT"));
		boardBean.setBOARD_CONTENT(multi.getParameter("BOARD_CONTENT"));
		boardBean.setBOARD_FILE(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		
		BoardWriteService boardWriteService = new BoardWriteService();
		boolean WriteResult = boardWriteService.registArticle(boardBean);
		
		ActionForward forward = null;
		
		if(WriteResult) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('문의 완료. 답변을 기달려주세요.')");
			out.println("history.go(-2);");
			out.println("</script>");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록 실패')");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}
}
