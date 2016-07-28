package org.taotao.order.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.taotao.common.pojo.TaotaoResult;
import org.taotao.common.utils.CookieUtils;
import org.taotao.common.utils.JsonUtils;
import org.taotao.user.service.LoginService;

/**
 * <p>Title: LoginInterceptor</p>
 * <p>Description: 创建一个登陆的拦截器</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月27日
 * @version 1.0
 */

public class LoginInterceptor implements HandlerInterceptor{

	@Value("${TOKEN_KEY}")//注入cookie中登陆用户的key
	private String TOKEN_KEY;
	@Value("${SSO_LOGIN_URL}")//校验用户失败跳转的登陆的url
	private String SSO_LOGIN_URL;
	@Autowired//注入一个登陆的用户的重定向链接
	private LoginService   loginService;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		从cookie中获取token
		String token = CookieUtils.getCookieValue(request, TOKEN_KEY);
//		判断token是否为空
		if(StringUtils.isBlank(token)){
//			取出当前的访问的url
			String url=request.getRequestURL().toString();
			response.sendRedirect(SSO_LOGIN_URL + "?redirectURL=" + url);
		return false;
		}
//		判断用户是否过期
		TaotaoResult taotaoResult = loginService.checkUser(token);
		if(taotaoResult.getStatus()!=200){
//			取出当前访问的url
			String url=request.getRequestURL().toString();
			response.sendRedirect(SSO_LOGIN_URL + "?redirectURL=" + url);
			return false;
		}
		//把用户信息写入request
		request.setAttribute("user", taotaoResult.getData());
//		最后判断结束成功之后,返回true
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
