package org.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>Title: PageController</p>
 * <p>Description: 页面跳转</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月13日
 * @version 1.0
 */
@Controller
public class PageController {
	
//	1.0	跳转主页
	@RequestMapping("/")
	private String showIndex(){
		return "index";
	}
//	2.0	展示跳转界面
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}

	
	
}
