package action;

import java.*;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;
import bean.Loginbean;
import service.FindService;
import service.LoginService;

public class findAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Loginbean login=new Loginbean();
		String findid=request.getParameter("id");
		String findname=request.getParameter("name");
		login.setId(findid);
		login.setName(findname); 
		FindService findService=new FindService();
		String FindResult=findService.find(login);
		ActionForward forward=null; 
		
		if(FindResult==null){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out =response.getWriter();
			out.println("<script>");
			out.println("alert('찾기 실패')");
			out.println("location.href='./PwFind.jsp' </script>");
			
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("pw",FindResult);
			forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./Pw.jsp");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out =response.getWriter();
			out.println("<script>");
			out.println("location.href='./Pw.jsp' </script>");
			
		}
		
		return forward;
	}

}
