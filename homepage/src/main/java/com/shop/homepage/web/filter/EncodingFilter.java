package com.shop.homepage.web.filter;


import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 
 * 解决URI有中文字符时，无法访问到系统资源问题 例如图片名称有中文时，不加这个过滤器将无法访问到图片
 *
 * @author lh
 *
 */
public class EncodingFilter implements HandlerInterceptor {

	private final String encoding = "UTF-8";
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		//System.out.println("uri:"+uri);
		String ch = URLDecoder.decode(uri, encoding);
		//System.out.println("解码后的uri："+ch);
		if (uri.equals(ch)) {
			return true;
		}
		ch = ch.substring(req.getContextPath().length());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
