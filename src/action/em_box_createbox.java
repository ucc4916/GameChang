package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;
import service.boxservice;

public class em_box_createbox  implements Action{
	//관리자모드 관리자페이지로 이동안내
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		ActionForward forward=new ActionForward();
		String id=request.getParameter("id");
		boxservice mc=new boxservice();
		boolean result=mc.createbox((String)session.getAttribute("id"));
		
		if(result) {
			System.out.println("추천 받은 견적에 있는 정보 입력 성공");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('견적함에 입력성공')");
			out.println("</script>");
		
		}
		else {
			System.out.println("추천받은 견적 입력 실패");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('입력실패')");
			out.println("history.back()</script>");
		}
		if(request.getParameter("path").equals("box")){
		forward.setRedirect(false);
		forward.setPath("em_first_main/em_box_main.jsp");
	}else {
		forward.setRedirect(false);
		forward.setPath("em_first_main/em_cho.jsp");
	}

		//반환값이 리턴이기에 놔둠
		return forward;
	}

}

