package org.taotao.cart.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.zookeeper.data.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.taotao.cart.service.CartService;
import org.taotao.common.utils.CookieUtils;
import org.taotao.common.utils.JsonUtils;
import org.taotao.item.service.ItemService;
import org.taotao.jedisclient.JedisClient;
import org.taotao.pojo.TbItem;

import com.alibaba.druid.sql.visitor.functions.If;import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
/**
 * <p>Title: CartServiceImpl</p>
 * <p>Description: 购物车业务操作类</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月27日
 * @version 1.0
 */
@Service
public class CartServiceImpl implements CartService{

	@Autowired//在这里注入一个itemservice服务接口
	private ItemService itemService;
	@Autowired//在这里注入一个jedisclient
	private JedisClient jedisClient;
	@Value("${CART_KEY}")//添加在reidis中的key
	private String CART_KEY;
	
	
//1.0 向购物车中添加商品,也就是想cookie中添加	
	@Override
	public List<TbItem> addCartItem(List<TbItem> list,long itemId,int num,String usrToken){
//	1.1判断购物车中是否有传递来的商品
		boolean flag=false;//创建一个标记
		for (TbItem tbItem : list) {
//			判断id是否相同
			if(tbItem.getId()==itemId){
//				相同的话重新设置购物车中的数量
				tbItem.setNum(tbItem.getNum() + num );
//				将标记重新设置
				flag=true;
//				跳出循环
				break;
			}
		}
// 判断标记
		if(!flag){
//				通过id查找商品
			TbItem tbItem = itemService.getItemById(itemId);
//		设置购买的商品的数量
			tbItem.setNum(num);
//		设置添加购物车的时间
			tbItem.setAddCartTime(new Date().getTime());
//	和redis进行结合
//		判断是token是否有效
			if(StringUtils.isNotBlank(usrToken)){
				jedisClient.hset(CART_KEY+":"+usrToken, itemId+"",JsonUtils.objectToJson(tbItem) );
			}
//			将商品重新添加到集合中
		list.add(tbItem);
		}
//	返回结果
		return list;
	}
	
//	2.0 删除购物车商品
	@Override
	public List<TbItem> deleteCartItem(List<TbItem> list,long itemId,String usrToken){
//		遍历集合删除商品
		for (TbItem tbItem : list) {
			if(tbItem.getId()==itemId){
				list.remove(tbItem);
//				和redis进行结合
//				判断是token是否有效
			if(StringUtils.isNotBlank(usrToken)){
				jedisClient.hdel(CART_KEY+":"+usrToken, itemId+"" );
			}
				break;
			}
		}
		return list;
	}
	
//3.0 编辑更新商品
	@Override
	public List<TbItem> updateCartItem(List<TbItem> list, long itemId,int num,String usrToken){
//		遍历集合查询商品
		//查询商品
				for (TbItem tbItem : list) {
					if (itemId == tbItem.getId()) {
						tbItem.setNum(num);
						if(StringUtils.isNotBlank(usrToken)){
//							先删除
							jedisClient.hdel(CART_KEY+":"+usrToken, itemId+"" );
//							再添加	
							jedisClient.hset(CART_KEY+":"+usrToken, itemId+"",JsonUtils.objectToJson(tbItem) );
						}
						break;
					}
				}
				return list;
	}

//	4.0 得到商品的列表
	@Override
	public List<TbItem> getCartItemList(List<TbItem> list,String usrToken){
//		和redis进行集合
		Map<String, String> map = jedisClient.hgetAll(CART_KEY+":"+usrToken);
//		遍历cookie中的list集合
		for(TbItem cookieItem:list){
//			获得一个商品的id
			String id=cookieItem.getId().toString();
//			判断cookie中的商品是否存在
			if(map.get(id)==null){//
				map.put(id, JsonUtils.objectToJson(cookieItem));
//				向redis中同步数据
				jedisClient.hset(CART_KEY+":"+usrToken, id+"",JsonUtils.objectToJson(cookieItem) );
			}else{
				String itemJson= map.get(id);
//				将itemJson转换成为一个对象
				TbItem redisItem = JsonUtils.jsonToPojo(itemJson, TbItem.class);
//				设置数量
				redisItem.setNum(	redisItem.getNum()+cookieItem.getNum() );
//				在讲这个redisItem转换为一个json
				String redisJson = JsonUtils.objectToJson(redisItem);
//				重新设置redis集合中的数数据
//				map.put(id,redisJson );
//				向redis中同步数据
				jedisClient.hset(CART_KEY+":"+usrToken, id+"", redisJson);
			}
		}
		map = jedisClient.hgetAll(CART_KEY+":"+usrToken);
		Collection<String> value= map.values();
//		创建一个返回结果集合
		List< TbItem > result=new ArrayList<>();
//		创建一个排序集合
		Set<TbItem > sort=new TreeSet<>(new Comparator<TbItem>() {
			@Override
			public int compare(TbItem o1,TbItem o2) {
				return (int) (o1.getAddCartTime()-o2.getAddCartTime());
			}
		});
//		遍历集合进行一个json转换
		for (String redisJson : value) {
			TbItem tbItem=JsonUtils.jsonToPojo(redisJson, TbItem.class);
			sort.add(tbItem);
		}
//		向结果中添加数据
		result.addAll(sort);
//		返回一个结果
		return result;
	}
	
	
	
	
	

}
