package org.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.taotao.common.pojo.EasyUITreeNode;
import org.taotao.service.ItemCatService;

/**
 * <p>Title: ItemCatController</p>
 * <p>Description: 用于操作关于商品类目</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月13日
 * @version 1.0
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
	
//	注入一个itemcatService
	@Autowired 
	private ItemCatService itemCatService;
	
	
//	1.0 添加一个查询目录
	@RequestMapping("/list")
	public @ResponseBody List<EasyUITreeNode> getItemCatList(
					@RequestParam(defaultValue="0" ,value="id") Long parentId){
		List<EasyUITreeNode> list=itemCatService.getItemCatList(parentId);
		return list;
	}
	
	
	
	
}
