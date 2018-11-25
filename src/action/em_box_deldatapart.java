package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import service.boxservice;

public class em_box_deldatapart implements Action{
	//관리자모드 관리자페이지로 이동안내
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward();
		int em_num=Integer.parseInt(request.getParameter("em_num"));
		String part=request.getParameter("part");
		String part_num=request.getParameter("part_num");
		//반환값이 리턴이기에 놔둠
		boxservice bsv=new boxservice();
		
		boolean result=false;
		result=bsv.deleteboxpart(part,em_num,part_num);
		
		if(result) {
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('견적함 삭제성공')");
			out.println("</script>");
			
		}
		else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('삭제실패')");
			out.println("history.back()</script>");
		}

		
		return forward;
	}

}
