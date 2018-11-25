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

import action.Action;
import action.BoardDetailAction;
import action.BoardFileDownAction;
import action.BoardListAction;
import action.BoardReplyAction;
import action.BoardReplyFormAction;
import action.BoardWriteAction;
import action.DdayAction;
import action.day2Action;
import action.dayAction;
import bean.ActionForward;

@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public BoardFrontController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String RequestURI=request.getRequestURI();
    	String contextPath=request.getContextPath();
    	String command=RequestURI.substring(contextPath.length());
    	
    	ActionForward forward=null;
    	Action action=null;
    	System.out.println(command);
    	if(command.equals("/boardWritePro.bo")) {
    		action = new BoardWriteAction();
    		try {
    			forward = action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/boardWriteForm.bo")) {
    		forward = new ActionForward();
    		forward.setPath("CustomerService_Q.jsp");
    	} else if(command.equals("/boardList.bo")) {
    		action = new BoardListAction();
    		try {
    			forward = action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/boardDetail.bo")) {
    		action = new BoardDetailAction();
    		try {
    			forward = action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/boardFileDown.bo")) {
    		action = new BoardFileDownAction();
    		try {
    			forward = action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(command.equals("/boardReplyForm.bo")) {
    		action = new BoardReplyFormAction();
    		try {
    			forward = action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/boardReply.bo")) {
    		action = new BoardReplyAction();
    		try {
    			forward = action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}  
    	if(command.equals("/dday2.bo")) {
    		System.out.println("관리자 모드 접속");
    		action=new dayAction();
    		try {
    			forward=action.execute(request,response);
    			System.out.println("성공");
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    		
    	if(command.equals("/dday.bo")) {
    		System.out.println("관리자 모드 접속");
    		action=new day2Action();
    		try {
    			forward=action.execute(request,response);
    			System.out.println("성공");
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    	if(command.equals("/start.bo")) {
            HttpSession session=request.getSession();
            session.invalidate();
            response.setContentType("text/html;charset=UTF-8");
              PrintWriter out =response.getWriter();
              out.println("<script>");
           
              out.println("location.href='./MainForm.jsp'");
              out.println("</script>");
           forward=new ActionForward();
           forward.setPath("./MainForm.jsp");
        }
    		
    	
    	
    	
    	
    	if(forward != null) {
    		if(forward.isRedirect()) {
    			response.sendRedirect(forward.getPath());
    		} else {
    			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
    			dispatcher.forward(request, response);
    		}
    	}

	}
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
