package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import been.actionforward;
import service.boxservice;

public class em_box_deldata implements Action{
	//관리자모드 관리자페이지로 이동안내
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward();


int em_num=Integer.parseInt(request.getParameter("em_num"));

boxservice bsv=new boxservice();
boolean result=false;
result=bsv.deletebox(em_num);

if(result) {
	
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out=response.getWriter();
	out.println("<script>");
	out.println("alert('견적함에 입력성공')");
	out.println("</script>");
	
}
else {
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out=response.getWriter();
	out.println("<script>");
	out.println("alert('삭제실패')");
	out.println("history.back()</script>");
}
forward.setRedirect(false);
forward.setPath("em_first_main/em_box_main.jsp");

//반환값이 리턴이기에 놔둠
return forward;
}

}