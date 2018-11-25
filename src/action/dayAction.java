package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;
import bean.Informationbean;

public class dayAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		String information=request.getParameter("information");
		String family=request.getParameter("family");
		String gestalt=request.getParameter("gestalt");
		String period=request.getParameter("period");
		String day=request.getParameter("day");
		String time=request.getParameter("time");
		String kindofpay=request.getParameter("kindofpay");
		int timer=Integer.parseInt(request.getParameter("timer"));
		int money=Integer.parseInt(request.getParameter("money"));
		session.setAttribute("information",information);
		session.setAttribute("family",family);
		session.setAttribute("gestalt",gestalt);
		session.setAttribute("period",period);
		session.setAttribute("day",day);
		session.setAttribute("time",time);
		session.setAttribute("kindofpay",kindofpay);
		session.setAttribute("money",money);
		session.setAttribute("timer",timer);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =response.getWriter();
		out.println("<script>");
		out.println("alert('알바선택이 완료되었습니다. ')");
		out.println("location.href='MainForm.jsp' </script>");
		
		if(session.getAttribute("id")==null) {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('로그인을 해주세요.')");
			out.println("location.href='Login.jsp' </script>");}
		
		
		return null;
	}

}
