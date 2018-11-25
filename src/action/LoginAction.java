package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;
import bean.Loginbean;
import service.LoginService;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Loginbean login=new Loginbean();
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		login.setId(id);
		login.setPassword(password);
		LoginService loginService=new LoginService();
		boolean LoginResult=loginService.login(login);
		ActionForward forward=null;
		
		if(LoginResult) {
			System.out.println("로그인성공");
			forward=new ActionForward();
			HttpSession session=request.getSession();
			session.setAttribute("id",login.getId());
			forward.setRedirect(true);
			forward.setPath("./MainForm.jsp");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out =response.getWriter();
			out.println("<script>");
			out.println("alert('아이디가 없거나 아이디, 비밀번호가 틀렸습니다.')");
			out.println("location.href='./Login.jsp' </script>");
			
		}
		return forward;
	}

}
