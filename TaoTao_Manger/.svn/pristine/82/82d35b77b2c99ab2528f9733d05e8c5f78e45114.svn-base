package org.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.taotao.pojo.TbItem;
import org.taotao.service.ItemService;

/**
 * <p>Title: ItemController</p>
 * <p>Description: 展示层用于接收和回写数据</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月11日
 * @version 1.0
 */

@Controller
public class ItemController {

@Autowired//注入一个Service
private ItemService itemService;
	
//1.0	通过id查找商品	
@RequestMapping("/findItemById/{itemId}")
@ResponseBody 
public TbItem findItemById(@PathVariable long itemId){
	TbItem item=itemService.findItemById(itemId);
	return item;
}
	
	
}
