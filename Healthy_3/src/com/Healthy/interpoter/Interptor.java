package com.Healthy.interpoter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		System.out.println("处理之前");
		// TODO Auto-generated method stub
		String url = request.getRequestURI();//获取地址栏uri
		
		//toA
		String preurl=request.getServletPath().substring(1);
	/////////////	

		if (!url.isEmpty()) {
			if (request.getSession() != null && request.getSession().getAttribute("user1") != null) {				
				response.sendRedirect(request.getContextPath() + "/ToA1");//重定向至页面a
				System.out.println("1111111");
			} else {
				System.out.println("null");
				return true;
			}
		}
///////////
		if (request.getSession() != null && request.getSession().getAttribute("user1") != null) {
			
			System.out.println("2222222");
			return true;
		}
		response.sendRedirect(request.getContextPath() + "/?preurl="+preurl);

		System.out.println("3333333");
		return false;
	
}
}
