package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;

public class day2Action implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		int Dprice=Integer.parseInt(request.getParameter("Dprice"));
		session.setAttribute("cost", Dprice);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =response.getWriter();
		out.println("<script>");
		out.println("alert('견적선택이 완료되었습니다. ')");
		out.println("location.href='MainForm.jsp' </script>");
	
		return null;
	}

}
