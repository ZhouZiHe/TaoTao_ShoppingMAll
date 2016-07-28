package org.taotao.cart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.taotao.cart.service.CartService;
import org.taotao.common.pojo.TaotaoResult;
import org.taotao.common.utils.CookieUtils;
import org.taotao.common.utils.JsonUtils;
import org.taotao.pojo.TbItem;
import org.taotao.pojo.TbUser;
import org.taotao.user.service.LoginService;

/**
 * <p>Title: CartController</p>
 * <p>Description: 购物车的表现层</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月27日
 * @version 1.0
 */
@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired//注入一个购物车的服务
	private CartService cartService;
	@Autowired//在这里注入一个关于用户登陆查询redis数据库的方法,调用loginservice
	private LoginService loginService;
	@Value("${CART_KEY}")//在这里注入一个购物车在cookie中key
	private String CART_KEY; 
	@Value("${COOKIE_EXPIRE}")//在这里注入一个购物车存在cookie的时间
	private int COOKIE_EXPIRE;
	@Value("${TOKEN_KEY}")//添加一个cookie中存在的用户的指令
	private String TOKEN_KEY;
	

//	0.1从cookie中获取购物车列表的公共方法,需要传入一个request请求
	private List<TbItem> getItemListFromCookie(HttpServletRequest request){
		//从cookie中取商品列表
				String json = CookieUtils.getCookieValue(request, CART_KEY, true);
				if (StringUtils.isBlank(json)) {
					return new ArrayList<>();
				}
				//购物车不为空把json数据转换成java对象
				List<TbItem> list = JsonUtils.jsonToList(json, TbItem.class);
				return list;
	}
//	0.2 request中获取用户登陆的token,并返回一个用户在redis中的登陆状态
	private String getUserToken(HttpServletRequest request){
//		从request中获取登陆用户的令牌
		String userToken = CookieUtils.getCookieValue(request, TOKEN_KEY);
//		判断令牌是否为空
		if(StringUtils.isBlank(userToken)){
			return null;
		}
//		调用Service的方法进行验证用户的登陆状态
		TaotaoResult taotaoResult = loginService.checkUser(userToken);
//		判断返回的额状态
		if (taotaoResult.getStatus()!= 200) {
			return null;
		}
//		状态正确的情况下返回一个用户的id
		TbUser tbUser=(TbUser) taotaoResult.getData();
		return tbUser.getId().toString();
	}
	
	
	
//1.0	添加购物车
	@RequestMapping("/add/{itemId}")
	public String addCartItem(@PathVariable long itemId,int num ,
			HttpServletRequest request,HttpServletResponse response){
// 1.1 从cookie中取出购物车的商品列表
		List<TbItem> list = this.getItemListFromCookie(request);
//	1.5 在这里添加一个关于判断用户的过程,判断用户是否已经登录
		String  token=this.getUserToken(request);
//	1.2 调用添加购物车的方法
		 List<TbItem> result = cartService.addCartItem(list, itemId, num,token);
//	1.3 将购物车重写回cookie中
	CookieUtils.setCookie(request, response, CART_KEY, 
			JsonUtils.objectToJson(result),COOKIE_EXPIRE, true);
//	1.4 返回一个成功页面
		return "cartSuccess";
	}	
	
	
//	2.0删除商品
	@RequestMapping("/delete/{itemId}")
	public String deleteCartItem(@PathVariable long itemId ,
			HttpServletRequest request ,HttpServletResponse response){
//	2.1从cookie中取出购物车
		List<TbItem> list = this.getItemListFromCookie(request);
// 2.5 在这里添加一个关于判断用户的过程,判断用户是否已经登录
			String  token=this.getUserToken(request);
// 2.2 执行操作
		List<TbItem> result =cartService.deleteCartItem(list, itemId,token);
//	2.3删除之后返回到cookie中
		CookieUtils.setCookie(request, response, CART_KEY,
				JsonUtils.objectToJson(result), COOKIE_EXPIRE, true);
//2.4 返回到购物车列表页面
		return "redirect:/cart/cart.html";
	}
	
//	3.0修改商品
	@RequestMapping("/update/num/{itemId}/{num}")
	public String  updateNum(@PathVariable Long itemId, @PathVariable Integer num,
			HttpServletRequest request ,HttpServletResponse response) {
//3.1 获取商品列表
		List<TbItem> list = this.getItemListFromCookie(request);
//3.4 在这里添加一个关于判断用户的过程,判断用户是否已经登录
			String  token=this.getUserToken(request);
//3.2	执行操,	更新商品
		List<TbItem> result =cartService.updateCartItem(list, itemId, num,token);
//3.3 把商品列表写回cookie
		CookieUtils.setCookie(request, response, CART_KEY, 
				JsonUtils.objectToJson(result), COOKIE_EXPIRE, true);
//		返回结果视图
		return "redirect:/cart/cart.html";
	}
	
//	4.0 查询购物车
	@RequestMapping("/cart")
	public String showCart(HttpServletRequest request ,Model model){
//4.1 在这里添加一个关于判断用户的过程,判断用户是否已经登录
		String  token=this.getUserToken(request);
//		先从从cookie中获得商品集合的列表
		List<TbItem> list = this.getItemListFromCookie(request);
//		调用购物车的Service方法进行购物车和用户本来所拥有的购物车内容进行合并
		List<TbItem> result = cartService.getCartItemList(list,token);
//		将购物车传递到页面
		model.addAttribute("cartList", result);
//		返回界面
		return "cart";
}
	
	
}
