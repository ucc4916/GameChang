package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;

import java.io.PrintWriter;

import javax.servlet.*;
import been.*;

public class em_adminmode implements Action{
	//관리자모드 관리자페이지로 이동안내
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		HttpSession session=request.getSession();
		
		String id=(String)session.getAttribute("id");
		if(id.equals("admin")) {
			System.out.println("관리자모드 접속완료 아이디 일치 action");
			forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath("adminmode/admin_partselect.jsp");
		}
		else {
			System.out.println("관리자모드 접속시랲 아이디 불일치 action");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('잘못된 접근입니다.')");
			out.println("history.back()</script>");
		}
		
		return forward;
	}
	
	

}
