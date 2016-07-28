package org.taotao.service;

import org.taotao.pojo.TbItem;

/**
 * <p>Title: ItemService</p>
 * <p>Description: service业务逻辑操作接口</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月12日
 * @version 1.0
 */
public interface ItemService {
//1.0	通过id查找商品
	TbItem findItemById(long itemId);

}
