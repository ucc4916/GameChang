package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;
import bean.Loginbean;
import service.JoinService;

public class JoinAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Loginbean login=new Loginbean();
		String id=request.getParameter("id");
	
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phonenum=request.getParameter("phonenum");
		String address=request.getParameter("address");
		String day=request.getParameter("day");
		String pay=request.getParameter("pay");
		String cost=request.getParameter("cost");
		
		login.setId(id);
		login.setPassword(password);
		login.setName(name);
		login.setEmail(email);
		login.setPhonenum(phonenum);
		login.setAddress(address);
		login.setDay(day);
		login.setPay(pay);
		login.setCost(cost);
		boolean joinResult=false;
		JoinService joinService=new JoinService();
	
		joinResult=joinService.join(login);
		ActionForward forward=null;
		if(joinResult==false) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out =response.getWriter();
			out.println("<script>");
			out.println("alert('회원가입 실패')");
			out.println("history.back() </script>");
		}else {
			HttpSession session=request.getSession();
			session.setAttribute("name",login.getName());
			forward=new ActionForward();
			forward.setRedirect(true);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out =response.getWriter();
			out.println("<script>");
			out.println("location.href='./Login.jsp'");
			out.println("</script>");
			forward.setPath("Main.go");
		}
			return forward;
		}

}
