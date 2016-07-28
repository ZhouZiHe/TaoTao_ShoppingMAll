package org.taotao.sso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.taotao.common.pojo.TaotaoResult;
import org.taotao.pojo.TbUser;
import org.taotao.user.service.RegisterService;

/**
 * <p>Title: RegisterController</p>
 * <p>Description: 注册服务的表现层</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月25日
 * @version 1.0
 */
@Controller
public class RegisterController {

	@Autowired//在这里得到一个Service服务
	private RegisterService registerService;
	
//	1.0 检查用户注册的时候是否护合法
	@RequestMapping("/user/check/{param}/{type}")
	public @ResponseBody TaotaoResult registerDataCheck(
		    @PathVariable	String param ,@PathVariable int type){
//		调用Service的方法的到结果
		TaotaoResult taotaoResult = registerService.registerDataCheck(param, type);
//		返回结果
		return taotaoResult;
	}
	
//	2.0 用户注册添加用户
	@RequestMapping(value="/user/register",method=RequestMethod.POST)
	public@ResponseBody TaotaoResult register(TbUser tbUser){
		TaotaoResult taotaoResult = registerService.register(tbUser);
		return taotaoResult;
	}
	
	
	
	
	
}
