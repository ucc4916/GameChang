package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;
import bean.Informationbean;
import service.PaylistSerive;

public class paylistAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		String money=request.getParameter("JOB_MONEY");
		String info=request.getParameter("COMPANY_INFORMATION");
		session.setAttribute("info", info);
		session.setAttribute("money",money);
		System.out.println(info);
		System.out.println(money);
		ActionForward forward=null;
		
		PaylistSerive paylistSerive=new PaylistSerive();
		ArrayList<Informationbean> information=paylistSerive.pay(info,money);
		forward=new ActionForward();
		request.setAttribute("ALBA",information);
		forward.setPath("./paylist.jsp");
		
		
		return forward;
	}

}
