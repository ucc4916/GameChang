package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.Loginbean;
import service.DeleteService;

public class DeleteAction2 implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Loginbean login=new Loginbean();
		ActionForward forward=null;
		
		forward=new ActionForward();
		
		String id=request.getParameter("id");
		DeleteService deleteService=new DeleteService();
		boolean deleteResult=deleteService.deleteone(id);
		if(deleteResult) {
			forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./list.go");
			
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out =response.getWriter();
			out.println("<script>");
			out.println("alert('삭제 실패')");
			out.println("location.href='./list.go'");
			out.println("</script>");
		}
		return forward;
	}

}
