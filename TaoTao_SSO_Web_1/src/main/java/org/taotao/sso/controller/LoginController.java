package org.taotao.sso.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.taotao.common.pojo.TaotaoResult;
import org.taotao.common.utils.CookieUtils;
import org.taotao.user.service.LoginService;

/**
 * <p>Title: LoginController</p>
 * <p>Description: 登陆的表现层</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月25日
 * @version 1.0
 */
@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	@Value("${TOKEN_KEY}")
	private String TOKEN_KEY;

//	1.0 用户登陆
	@RequestMapping(value="/user/login", method=RequestMethod.POST)
	public @ResponseBody TaotaoResult login(String username, String password, 
			HttpServletRequest request, HttpServletResponse response) {
//		调用服务
		TaotaoResult taotaoResult = loginService.login(username, password);
//		向cookie中写入token
		CookieUtils.setCookie(request, response, TOKEN_KEY, 
				taotaoResult.getData().toString(), true);
//		返回结果
		return taotaoResult;
	}
	
//	2.0 从cookie中取得用户,外加一个callback参数标示AJAX跨域请求
@RequestMapping("/user/token/{token}")
public @ResponseBody Object getUserByToken(@PathVariable String token,String callback){
//2.1 调用Service服务
	TaotaoResult taotaoResult = loginService.checkUser(token);
//2.2 判断是否需要跨域请求
	if(StringUtils.isBlank(callback)){
		return taotaoResult;
	}	
//2.3 如果判断不是空的话需要返回 jsonp	
	MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(taotaoResult);
	mappingJacksonValue.setJsonpFunction(callback);
//2.4返回结果
	return mappingJacksonValue;
}
	
	
	
	
	
	
	
}
