package org.taotao.user.service.impl;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.taotao.common.pojo.TaotaoResult;
import org.taotao.common.utils.JsonUtils;
import org.taotao.dao.TbUserMapper;
import org.taotao.pojo.TbUser;
import org.taotao.pojo.TbUserExample;
import org.taotao.pojo.TbUserExample.Criteria;
import org.taotao.user.service.LoginService;
import org.taotao.user.service.jedisclient.JedisClient;

/**
 * <p>Title: LoginServiceImpl</p>
 * <p>Description: 用户登陆的服务</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月25日
 * @version 1.0
 */
@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired//注入一个用户的dao操作类
	private TbUserMapper tbUserMapper;
	@Value("${SESSION_KEY}")//在这里注入一个session_key
	private String SESSION_KEY;
	@Value("${SESSION_EXPIE}")
	private int SESSION_EXPIE;
	@Autowired//需要注入一个jedisclient
	private JedisClient jedisClient;
	
	
	
//	1.0 添加一个登陆的方法
@Override
public TaotaoResult login(String userName,String password){
//	1.1首先根据用户的名称查询出用户的信息
	TbUserExample tbUserExample=new  TbUserExample();
//	1.2创建查询条件
    Criteria criteria = tbUserExample.createCriteria();
//	1.3添加查询条件
    criteria.andUsernameEqualTo(userName);
// 1.4 执行查询条件
    List<TbUser> list = tbUserMapper.selectByExample(tbUserExample);
//1.5  判断是否可以取出结果
    if (list==null || list.isEmpty() ) {
		return TaotaoResult.build(400, "用户名或者密码不正确");
	}
//1.6得到第一个元素
    TbUser tbUser = list.get(0);
//1.7取出密码,判断密码是否匹配
    if(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()).equals(password)){
    	return TaotaoResult.build(400, "用户名或者密码不正确");
    }
//1.8    匹配正确之后开始生合token
    String token=UUID.randomUUID().toString();
//1.9将密码设置空
    tbUser.setPassword(null);
//    将token写入到redis中
    jedisClient.set(SESSION_KEY + ":" + token, JsonUtils.objectToJson(tbUser));
//    设置有效期
    jedisClient.expire(SESSION_KEY + ":" + token, SESSION_EXPIE);
//    返回结果
    return TaotaoResult.ok(token);
}    
    
//2.0根据token来查询用户的登陆状态
@Override
public TaotaoResult checkUser(String token){
//	2.1从redis中获取登陆的用户信息
	String userJson =jedisClient.get(SESSION_KEY+":"+token);
//	2.2判断得出的结果
	if (StringUtils.isNotBlank(userJson)) {
//	2.3将这个json对象转换成user对象
		TbUser tbUser = JsonUtils.jsonToPojo(userJson, TbUser.class);
// 2.4重新设置有效时间
		jedisClient.expire(SESSION_KEY+":"+token, SESSION_EXPIE);
//	2.5返回结果
	 return	TaotaoResult.ok(tbUser);
	}
//	2.6如果取不到的话就说明用户已过期
	return TaotaoResult.build(201, "用户已失效");
	
}







    
}
	
	
	
	
	
	
	
	
