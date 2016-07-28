package org.taotao.order.service.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.taotao.common.pojo.TaotaoResult;
import org.taotao.dao.TbOrderItemMapper;
import org.taotao.dao.TbOrderMapper;
import org.taotao.dao.TbOrderShippingMapper;
import org.taotao.jedisclient.JedisClient;
import org.taotao.order.pojo.OrderInfo;
import org.taotao.order.service.OrderService;
import org.taotao.pojo.TbOrder;
import org.taotao.pojo.TbOrderItem;
import org.taotao.pojo.TbOrderShipping;

/**
 * <p>Title: OrderServiceImpl</p>
 * <p>Description: 订单的相关业务操作</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月28日
 * @version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService{
	

	@Autowired//注入订单基本操作
	private TbOrderMapper tbOrderMapper;
	@Autowired//注入订单明细操作
	private TbOrderItemMapper tbOrderItemMapper;
	@Autowired//注入订单物流操作
	private TbOrderShippingMapper tbOrderShippingMapper;
	@Autowired//注入jedisclient
	private JedisClient jedisClient;
//redis中用到的
@Value("${ORDER_ID_GEN_KEY}")//订单的额流水号
private String ORDER_ID_GEN_KEY;
@Value("${ORDER_START_NUM}")//所有订单的第一个流水号
private String ORDER_START_NUM;
@Value("${ORDER_DETAIL_ID_GEN_KEY}")//订单详细信息的流水号
private String  ORDER_DETAIL_ID_GEN_KEY;


//1.0 创建订单
@Override
public TaotaoResult createOrder(OrderInfo orderInfo){
//	1.1 从redis中获取订单流水号
	String orderKey = jedisClient.get(ORDER_ID_GEN_KEY);
//	1.2判断是否为空
	if(StringUtils.isBlank(orderKey)){
//		设置初始值
		jedisClient.set(ORDER_DETAIL_ID_GEN_KEY, ORDER_START_NUM);
	}
//	1.3获取自增的订单号
	Long orderId = jedisClient.incr(ORDER_ID_GEN_KEY);
//	1.4补全订单明细的相关信息
	TbOrder tbOrder=orderInfo.getOrder();
	tbOrder.setOrderId(orderId.toString());
	tbOrder.setPostFee("10");//设置邮费
	//订单状态
	//未付款状态1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭
	tbOrder.setStatus(1);
	Date date = new Date();
	tbOrder.setCreateTime(date);
	tbOrder.setUpdateTime(date);
//1.5向订单表中插入数据
	tbOrderMapper.insert(tbOrder);
//1.6循环向订单明细中插入数据
	for (TbOrderItem tbOrderItem : orderInfo.getItemList()) {
		Long orderItemId=jedisClient.incr(ORDER_DETAIL_ID_GEN_KEY);
//		补全订单明细
		tbOrderItem.setId(orderItemId.toString());
		//设置订单号
		tbOrderItem.setOrderId(orderId.toString());
		//插入数据
		tbOrderItemMapper.insert(tbOrderItem);
	}
//1.7	设置配送信息表
	TbOrderShipping tbOrderShipping = orderInfo.getOrderShipping();
	tbOrderShipping.setOrderId(orderId.toString());
	tbOrderShipping.setCreated(date);
	tbOrderShipping.setUpdated(date);
//	1.8插入数据
	tbOrderShippingMapper.insert(tbOrderShipping);
// 1.9 返回成功。返回TaotaoResult，包含订单号。
			return TaotaoResult.ok(orderId);
}







}
