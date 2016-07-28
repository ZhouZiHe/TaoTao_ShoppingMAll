package org.taotao.order.pojo;

import java.io.Serializable;
import java.util.List;

import org.taotao.pojo.TbOrder;
import org.taotao.pojo.TbOrderItem;
import org.taotao.pojo.TbOrderShipping;

/**
 * <p>Title: Orderinfo</p>
 * <p>Description: 订单相关信息的操作pojo实体类</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月28日
 * @version 1.0
 */
public class OrderInfo implements Serializable{
	
//	订单基本信息
	private TbOrder order;
//	订单明细信息
	private List<TbOrderItem> itemList;
//	派送红信息
	private TbOrderShipping orderShipping;

//	set/get方法

	public List<TbOrderItem> getItemList() {
		return itemList;
	}

	public TbOrder getOrder() {
		return order;
	}

	public void setOrder(TbOrder order) {
		this.order = order;
	}

	public void setItemList(List<TbOrderItem> itemList) {
		this.itemList = itemList;
	}

	public TbOrderShipping getOrderShipping() {
		return orderShipping;
	}

	public void setOrderShipping(TbOrderShipping orderShipping) {
		this.orderShipping = orderShipping;
	}
	
	
	
	
	
	
	
}
