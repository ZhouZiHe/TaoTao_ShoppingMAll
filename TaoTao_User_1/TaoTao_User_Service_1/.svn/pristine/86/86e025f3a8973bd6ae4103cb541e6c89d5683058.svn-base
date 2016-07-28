package org.taotao.user.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.taotao.common.pojo.TaotaoResult;
import org.taotao.dao.TbUserMapper;
import org.taotao.pojo.TbUser;
import org.taotao.pojo.TbUserExample;
import org.taotao.pojo.TbUserExample.Criteria;
import org.taotao.user.service.RegisterService;


/**
 * <p>
 * Title: RegisterServiceImpl
 * </p>
 * <p>
 * Description: 用户注册的服务
 * </p>
 * <p>
 * Email: zhouzihe@hotmail.com
 * </p>
 * 
 * @author Zack
 * @date 2015年12月25日
 * @version 1.0
 */
@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired // 在这里注入一个用户的逆行工程的操作mapper
	private TbUserMapper tbUserMapper;

	// 1.0 用户注册的检查方法,传递两个参数,第一个参数是数据的内容,第二个是数据的类型
	@Override
	public TaotaoResult registerDataCheck(String param, int type) {
// 1.1创建一个example对象
		TbUserExample tbUserExample = new TbUserExample();
// 1.2创建查询条件对象
		Criteria criteria = tbUserExample.createCriteria();
//1.3 判断添加查询条件
		// 1、2、3分别代表username、phone、email
		if (type == 1) {
			criteria.andUsernameEqualTo(param);
		} else if (type == 2) {
			criteria.andPhoneEqualTo(param);
		}else if(type==3){
			criteria.andEmailEqualTo(param);
		}
//	1.4执行查询
		List<TbUser> list = tbUserMapper.selectByExample(tbUserExample);
//	1.5判断执行的查询条件的结果是否和法,如果为false则表示用户没有被注册过
		if (list==null || list.isEmpty()) {
			return TaotaoResult.ok(true) ;
		}
//	1.6 当被用过的时候返回一个结果
		return TaotaoResult.ok(false);
	}

//	2.0添加注册的用户
	@Override
	public TaotaoResult register(TbUser tbUser){
//2.1补全注册的信息
		Date  date=new Date();
		tbUser.setCreated(date);
		tbUser.setUpdated(date);
//		对密码进行加密
		tbUser.setPassword( DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
//		将数据插入数据库
		tbUserMapper.insert(tbUser);
//		返回结果
		return TaotaoResult.ok();
} 
	
	
	
}
