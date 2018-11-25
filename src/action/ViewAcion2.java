package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;
import bean.Loginbean;
import service.ViewSerive;

public class ViewAcion2 implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		String id=(String) session.getAttribute("id");
		
		ActionForward forward=null;
		if(id==null) {
			forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./Mypage.jsp");
		}else {
			forward=new ActionForward();
			String viewId2=request.getParameter("id");
			ViewSerive viewService =new ViewSerive();
			Loginbean view=viewService.view(viewId2);
			request.setAttribute("login",view);
			forward.setPath("./info.jsp");
			}
			return forward;
		
		
		
	
	}

}
