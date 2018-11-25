package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;

public interface Action {
	//리턴타입:ActionForward
	//액션이름:execute
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response)throws Exception;
}
