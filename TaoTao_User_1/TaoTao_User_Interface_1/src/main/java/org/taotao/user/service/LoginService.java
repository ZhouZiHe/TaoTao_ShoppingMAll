package org.taotao.user.service;

import org.taotao.common.pojo.TaotaoResult;

/**
 * <p>Title: LoginService</p>
 * <p>Description: 用户登陆接口</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月25日
 * @version 1.0
 */
public interface LoginService {

//1.0 登陆的方法	
	TaotaoResult login(String userName, String password);
//2.0 从redIs中判断用户登陆所对应的token是否已经失效
	TaotaoResult checkUser(String token);

}
