package org.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.taotao.common.pojo.EasyUIDataGridResult;
import org.taotao.common.pojo.TaotaoResult;
import org.taotao.pojo.TbItem;
import org.taotao.pojo.TbItemDesc;
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
	
//	2.0	分页查找商品列表
@RequestMapping("/item/list")
public @ResponseBody EasyUIDataGridResult getItemList(Integer page,Integer rows){
	EasyUIDataGridResult easyUIDataGridResult=itemService.getItemList(page, rows);
//	将结果返回
	return easyUIDataGridResult;
}

//	3.0 	添加商品
@RequestMapping("item/save")
public @ResponseBody TaotaoResult itemSave(TbItem item,String desc){
//3.1 封装商品描述对象
	TbItemDesc itemDesc=new TbItemDesc();
	itemDesc.setItemDesc(desc);
//3.2 条用服务添加商品
	TaotaoResult taotaoResult=itemService.addItem(item, itemDesc);
//3.3	返回结果
	return taotaoResult;
}




}
