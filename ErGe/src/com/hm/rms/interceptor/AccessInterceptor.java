package com.hm.rms.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hm.rms.entity.UserInfo;

public class AccessInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object obj) throws Exception {
		HttpSession session=request.getSession();
		UserInfo user=(UserInfo)
				session.getAttribute("user");
		Cookie[] cookies = request.getCookies();
		if(user==null && cookies == null || "/toMain.action".equals(request.getRequestURI())){
			response.getWriter().print(
				"<script>window.top.location.href='"+
				"login/toLogin.action';</script>");
			/*response.sendRedirect(
				request.getContextPath()+
				"/login/toLogin.action");*/
			return false;
		}
		return true;
	}

}
