package org.taotao.order.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.taotao.cart.service.CartService;
import org.taotao.common.pojo.TaotaoResult;
import org.taotao.common.utils.CookieUtils;
import org.taotao.common.utils.JsonUtils;
import org.taotao.order.pojo.OrderInfo;
import org.taotao.order.service.OrderService;
import org.taotao.pojo.TbItem;
import org.taotao.pojo.TbUser;

/**
 * <p>Title: OrderController</p>
 * <p>Description: 订单的表现层操作</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月27日
 * @version 1.0
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	
	
	@Value("${CART_KEY}")//在这里注入一个购物车在cookie中key
	private String CART_KEY; 
	@Value("${COOKIE_EXPIRE}")//在这里注入一个购物车存在cookie的时间
	private int COOKIE_EXPIRE;
	@Value("${TOKEN_KEY}")//注入一个用户在cookie中的令牌
	private  String  TOKEN_KEY;
	@Autowired//注入一个购物车的服务
	private CartService cartService;
	@Autowired//注入一个订单服务操作
	private OrderService orderService;
	
//	0.0从cookie中获取购物车列表的公共方法,需要传入一个request请求
	private List<TbItem> getItemListFromCookie(HttpServletRequest request){
//		从cookie中获取商品列表
		String json=CookieUtils.getCookieValue(request, CART_KEY, true);
//		判断是否可以从购物车中取出东西
		if (StringUtils.isNotBlank(json)) {
			List<TbItem> list=JsonUtils.jsonToList(json, TbItem.class);
			return list;
		}
//		如果取出的是空
		return new ArrayList<TbItem>();
	}
	
	
//1.0	购物车提交订单
@RequestMapping("/order-cart")
public String showOrderCart(HttpServletRequest request) {
	//取用户信息
			TbUser user = (TbUser) request.getAttribute("user");
			//根据用户查询收货地址列表
			//................
			//取商品列表
			List<TbItem> list = this.getItemListFromCookie(request);
			request.setAttribute("cartList", list);
			return "order-cart";
}	

//2.0创建订单
@RequestMapping(value="/create",method=RequestMethod.POST)
public String createOrder(OrderInfo orderInfo, Model model, HttpServletRequest request) {
//获取用户信息
	TbUser tbUser=(TbUser) request.getAttribute("user");
//性订单中设置用户的信息
	orderInfo.getOrder().setUserId(tbUser.getId());
	orderInfo.getOrder().setBuyerNick(tbUser.getUsername());
//	掉用方法创建订单
	TaotaoResult taotaoResult = orderService.createOrder(orderInfo);
	//把订单号传递给页面
	model.addAttribute("orderId", taotaoResult.getData());
	model.addAttribute("payment", orderInfo.getOrder().getPayment());
//设置送货预计时间
	DateTime dateTime = new DateTime();
	dateTime.plusDays(3);//3天后送到货
//设置时间
	model.addAttribute("date", dateTime.toString("yyyy-MM-dd"));
//	返回成功页面
	return "success";
}

}
