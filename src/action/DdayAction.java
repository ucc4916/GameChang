package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;
import bean.*;
import service.DdayService;


public class DdayAction implements Action{
	boolean DdayResult=false;
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		
		String id=(String) session.getAttribute("id");
		if(session.getAttribute("money")!=null || session.getAttribute("cost")!=null) {
			
			if(session.getAttribute("cost")==null) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out =response.getWriter();
				out.println("<script>");
				out.println("alert('견적값을 선택해주세요')");
				out.println("location.href='./em_main.jsp' </script>");
			} else if(session.getAttribute("money")==null) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out =response.getWriter();
				out.println("<script>");
				out.println("alert('알바를 선택해주세요')");
				out.println("location.href='./googlemaps.to' </script>");
			} else {
				int cost=(int) session.getAttribute("cost");//견적값
				int pay2=(int) session.getAttribute("money");//월급
				String information=(String)session.getAttribute("information");
				int timer=(int)session.getAttribute("timer");
				int pay=pay2*timer;
				int countday=((cost/pay)+1);
				Ddaybean Dday=new Ddaybean();

				Dday.setId(id);
				Dday.setCost(cost);
				Dday.setPay(pay);
				Dday.setPay2(pay2);
				Dday.setCountday(countday);
				Dday.setInformation(information);
				DdayResult=false;
				DdayService ddayService=new DdayService();
				DdayResult=ddayService.update(Dday);
			}
		}
		
		else {
			 DdayResult=true;	
		}
		
		ActionForward forward=null;
		
		if(DdayResult==false) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out =response.getWriter();
			out.println("<script>");
			out.println("alert('조회실패')");
			out.println("history.back() </script>");
		}
				
		else {
			forward=new ActionForward();
			String viewId=id;
			DdayService ddayService=new DdayService();
			ArrayList<Ddaybean> day=ddayService.view(viewId);
			request.setAttribute("Dday",day);
			forward.setPath("./Dday.jsp");
		}
		return forward;
	}

}
