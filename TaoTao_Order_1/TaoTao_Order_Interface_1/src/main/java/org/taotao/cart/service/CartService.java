package org.taotao.cart.service;

import java.util.List;
import org.taotao.pojo.TbItem;

public interface CartService {

//添加商品
	List<TbItem> addCartItem(List<TbItem> list, long itemId, int num,String usrToken);
//删除商品
	List<TbItem> deleteCartItem(List<TbItem> list, long itemId,String usrToken);
//更新善品
	List<TbItem> updateCartItem(List<TbItem> list, long itemId, int num,String usrToken);
//得到购物车商品集合
	List<TbItem> getCartItemList(List<TbItem> list,String usrToken);
	
}
