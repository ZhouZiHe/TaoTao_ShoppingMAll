package org.taotao.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>Title: PageController</p>
 * <p>Description: 登陆和注册页面跳转的方法</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月27日
 * @version 1.0
 */
@Controller
public class PageController {

//	1.0注册页面的额跳转
	@RequestMapping("/page/register")
	public String showRegisterPage(){
		return "register";
	}
	
//	2.0页面登陆的跳转
	@RequestMapping("/page/login")
	public String showLoginPage(String redirectURL, Model model){
		//把回调的url传递给jsp
		model.addAttribute("redirect", redirectURL);
		return "login";
	}
		
}
