package org.taotao.user.service;

import org.taotao.common.pojo.TaotaoResult;
import org.taotao.pojo.TbUser;

/**
 * <p>Title: RegisterService</p>
 * <p>Description: 用户注册服务接口</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月25日
 * @version 1.0
 */
public interface RegisterService {

//	注册的的时候,检查用户是否可以用
	TaotaoResult registerDataCheck(String param, int type);
//	 注册用户
	TaotaoResult register(TbUser tbUser);

}
