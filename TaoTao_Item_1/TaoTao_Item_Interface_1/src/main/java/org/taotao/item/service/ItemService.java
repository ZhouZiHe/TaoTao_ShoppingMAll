package org.taotao.item.service;

import org.taotao.pojo.TbItem;
import org.taotao.pojo.TbItemDesc;
import org.taotao.pojo.TbItemParamItem;

/**
 * <p>Title: ItemService</p>
 * <p>Description:商品的相关业务操作接口 </p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月27日
 * @version 1.0
 */

public interface ItemService {
//1.0 通过itemId查找商品
	TbItem getItemById(long ItemId);
//2.0 通过itemId查找商品的详细
	TbItemDesc getItemDescById(Long itemId);
//3.0 通过商品Id查找商品的规格参数
	TbItemParamItem getItemParamByItemId(Long itemId);
	
}
