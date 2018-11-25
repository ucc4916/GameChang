package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.Loginbean;
import service.UpdateService;

public class UpdateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		forward=new ActionForward();
		Loginbean login=new Loginbean();
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		UpdateService updateService=new UpdateService();
		String logpa=updateService.update(id);
		
		if(logpa.equals(password)) {
			
			String name=request.getParameter("name");
			String address=request.getParameter("address");
			String pay=request.getParameter("pay");
			String phonenum=request.getParameter("phonenum");
			String day=request.getParameter("day");
			String email=request.getParameter("email");
			login.setId(id);
			login.setName(name);
			login.setAddress(address);
			login.setPay(pay);
			login.setPhonenum(phonenum);
			login.setDay(day);
			login.setEmail(email);
			
			Loginbean view=updateService.up(login);
			request.setAttribute("login",view);
			forward.setPath("./Mypage.jsp");
			
			
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 틀립니다')");
			out.println("history.back()</script>");
		}
		
		
		
		return forward;
		
		
	}

}
