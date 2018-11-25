package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.*;

import bean.ActionForward;

@WebServlet("*.go")
public class Logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Logincontroller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		
		ActionForward forward=null;
		Action action=null;
		
		
		if(command.equals("/Login.go")) {
			action=new LoginAction();
			try {
				forward=action.execute(request,response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(command.equals("/Join.go")) {
			action=new JoinAction();
			try {
				forward=action.execute(request,response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}	
		if(command.equals("/paylist.go")) {
			action=new paylistAction();
			try {
				forward=action.execute(request,response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}	
		if(command.equals("/Main.go")) {
			forward=new ActionForward();
			forward.setPath("./Login.jsp");
		}
		if(command.equals("/d.go")) {
			 HttpSession session=request.getSession();
			 String id=(String) session.getAttribute("id");
			 session.invalidate();
			 session = request.getSession();
			 session.setAttribute("id", id);
			 forward=new ActionForward();
			 forward.setPath("./MainForm.jsp");
		}
		if(command.equals("/find.go")) {
			action=new findAction();
			try {
				forward=action.execute(request,response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/View.go")) {
			action=new ViewAcion2();
			try {
				forward=action.execute(request,response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}	
		if(command.equals("/Dday.go")) {
			action=new DdayAction();
			try {
				forward=action.execute(request,response);
			} catch(Exception e) {
				 HttpSession session=request.getSession();
				 session.invalidate();
				 response.setContentType("text/html;charset=UTF-8");
					PrintWriter out =response.getWriter();
					out.println("<script>");
					out.println("alert('오류로인해 재로그인후 다시 시도바랍니다')");
					out.println("location.href='./MainForm.jsp'");
					out.println("</script>");
			}
		}
		if(command.equals("/Delete2.go")) {
			action=new DeleteAction2();
			try {
				forward=action.execute(request,response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}if(command.equals("/list.go")) {
			action=new ViewAction();
			try {
				forward=action.execute(request,response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/Pw.go")) {
			forward=new ActionForward();
			forward.setPath("./Pw.jsp");
		}
		
		if(command.equals("/Delete.go")) {
			action=new DeleteAction();
			try {
				forward=action.execute(request,response);
			} catch(Exception e) {
				response.setContentType("text/html;charset=UTF-8");
	            PrintWriter out =response.getWriter();
	            out.println("<script>");
	            out.println("alert('입력정보 오류로 인한 삭제 실패')");
	            out.println("location.href='./Delete.jsp'");
	            out.println("</script>");
			}
		}
		if(command.equals("/Loginde.go")) {
			 HttpSession session=request.getSession();
			 session.invalidate();
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out =response.getWriter();
			out.println("<script>");
			out.println("alert('삭제성공')");
			out.println("location.href='./MainForm.jsp'");
			out.println("</script>");	
		}
		if(command.equals("/admin.go")) {
		
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out =response.getWriter();
			out.println("<script>");
			out.println("alert('관리자님 어서오세요')");
			out.println("location.href='./MainForm.jsp'");
			out.println("</script>");	
		}
		if(command.equals("/logout.go")) {
			HttpSession session=request.getSession();
			session.invalidate();
			response.sendRedirect("MainForm.jsp");
			}
		
		if(command.equals("/Mypage.go")) {
			forward=new ActionForward();
			forward.setPath("./Mypage.jsp");
		}
		
		if(command.equals("/view.go")) {
			action=new ViewAction();
			try {
				forward=action.execute(request,response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}	
		
		if(command.equals("/ReWrite.go")) {
			action=new rewriteAction();
			try {
				forward=action.execute(request,response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(command.equals("/Update.go")) {
			action=new UpdateAction();
			try {
				forward=action.execute(request,response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}	
		
		if(command.equals("/Loginde.go")) {
	          HttpSession session=request.getSession();
	          session.invalidate();
	         response.setContentType("text/html;charset=UTF-8");
	         PrintWriter out =response.getWriter();
	         out.println("<script>");
	         out.println("alert('회원 탈퇴 성공')");
	         out.println("location.href='./MainForm.jsp'");
	         out.println("</script>");   
	      }
		
		if(forward != null) {
    		if(forward.isRedirect()) {
    			response.sendRedirect(forward.getPath());
    		} else {
    			RequestDispatcher dispatcher= request.getRequestDispatcher(forward.getPath());
    			dispatcher.forward(request,response);
    		}
    	}
	}

}
