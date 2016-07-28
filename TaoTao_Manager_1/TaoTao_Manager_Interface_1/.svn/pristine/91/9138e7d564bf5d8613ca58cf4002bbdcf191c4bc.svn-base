package org.taotao.service;

import java.io.Serializable;

import org.taotao.common.pojo.EasyUIDataGridResult;
import org.taotao.common.pojo.TaotaoResult;
import org.taotao.pojo.TbItem;
import org.taotao.pojo.TbItemDesc;

/**
 * <p>Title: ItemService</p>
 * <p>Description: service业务逻辑操作接口</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月12日
 * @version 1.0
 */
public interface ItemService extends Serializable{
//1.0	通过id查找商品
	TbItem findItemById(long itemId);
//2.0	通过插件进行分页查询
	EasyUIDataGridResult getItemList(int page, int rows);
//3.0	添加商品
	TaotaoResult addItem(TbItem tbItem, TbItemDesc tbItemDesc);

}
