package org.taotao.order.service;

import org.taotao.common.pojo.TaotaoResult;
import org.taotao.order.pojo.OrderInfo;
/**
 * <p>Title: OrderService</p>
 * <p>Description: 订单服务接口</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月28日
 * @version 1.0
 */
public interface OrderService {

//	1.0 创建订单服务
	TaotaoResult createOrder(OrderInfo orderInfo);

}
