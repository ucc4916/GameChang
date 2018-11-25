package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;
import bean.Loginbean;
import service.ListService;
import service.ViewSerive;

public class ViewAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		String id=(String) session.getAttribute("id");
		
		ActionForward forward=null;
		if(id==null) {
			forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./Mypage.jsp");
		}
		else if(id.equals("admin")) {
			forward=new ActionForward();
			String viewId=id;
			ListService listService =new ListService();
			ArrayList<Loginbean> view2=listService.list(viewId);
			request.setAttribute("login",view2);
			forward.setPath("./list.jsp");
		}
		else {
			forward=new ActionForward();
			String viewId=id;
			ViewSerive viewService =new ViewSerive();
			Loginbean view=viewService.view(viewId);
			request.setAttribute("login",view);
			forward.setPath("./info.jsp");
			}
			return forward;
		
		

	
	}

}
