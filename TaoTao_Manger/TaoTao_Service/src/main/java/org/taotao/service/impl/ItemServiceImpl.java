package org.taotao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taotao.dao.TbItemMapper;
import org.taotao.pojo.TbItem;
import org.taotao.service.ItemService;
/**
 * <p>Title: ItemServiceImpl</p>
 * <p>Description: ItemService接口实现类</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月12日
 * @version 1.0
 */
@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired//在这里注入一个itemMapper
	private TbItemMapper tbItemMapper;
	
//1.0	通过id查找商品
	@Override
	public TbItem findItemById(long itemId){
		TbItem item=tbItemMapper.selectByPrimaryKey(itemId);
		return item;
	}
	
}
