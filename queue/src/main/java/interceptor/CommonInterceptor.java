package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import entity.User;

public class CommonInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object obj, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object obj, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		System.out.println("请求"+req.getRequestURI());
		if(user==null){
			res.sendRedirect("/queue/user/toLoginView.do");
            return false;
		}else{
			return true;
		}
		
	}

}
