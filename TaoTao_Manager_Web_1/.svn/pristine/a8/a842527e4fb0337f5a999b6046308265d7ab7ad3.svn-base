package org.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.taotao.common.pojo.EasyUITreeNode;
import org.taotao.common.pojo.TaotaoResult;
import org.taotao.content.service.ContentCategoryService;

/**
 * <p>Title: ContentCategoryController</p>
 * <p>Description: 内容表现层</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月17日
 * @version 1.0
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {
	
	@Autowired//在这里注入一个Service方法
	private ContentCategoryService categoryService;
	
//	1.0 页面展示操作
@RequestMapping("/list")
public @ResponseBody List<EasyUITreeNode> getContentCategoryList(
			@RequestParam(value="id",defaultValue="0") Long parentId ){
//	调用Service查询结果	
	List<EasyUITreeNode> list=categoryService.getContentCatList(parentId);
//返回结果
		return list;
}
	
	
//	2.0 创建一个新节点的添加操作
@RequestMapping("/create")
public @ResponseBody TaotaoResult createCategoryNode(long parentId,String name){
	TaotaoResult taotaoResult;
	taotaoResult = categoryService.addCateGoryNode(parentId, name);
	return  taotaoResult;
}





	
	
	
	
}
