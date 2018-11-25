package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.Loginbean;

import service.DeleteService;
import service.FindService;

public class DeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Loginbean login=new Loginbean();
		ActionForward forward=null;
		
		forward=new ActionForward();
		Loginbean loginbean=new Loginbean();
	
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		login.setId(id);
		login.setName(name); 
		FindService deleteService=new FindService();
		String id2=deleteService.find(login);
		String pw=request.getParameter("password");
		
		if(id2.equals(pw)) {
		
			String delId=request.getParameter("id");
			DeleteService delete=new DeleteService();
			boolean deleteResult=delete.deleteon(delId);
			if(deleteResult) {
			
				forward=new ActionForward();
				forward.setRedirect(true);
				forward.setPath("./Loginde.go");
				}
			
			} else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out =response.getWriter();
				out.println("<script>");
				out.println("alert('삭제 실패')");
				out.println("location.href='./Login.jsp'");
				out.println("</script>");
			}
			return forward;
	}

}
