package org.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.taotao.common.pojo.EasyUIDataGridResult;
import org.taotao.common.pojo.EasyUITreeNode;
import org.taotao.common.pojo.TaotaoResult;
import org.taotao.content.service.ContentService;
import org.taotao.pojo.TbContent;
import org.taotao.pojo.TbContentCategory;


/**
 * <p>Title: ContentController</p>
 * <p>Description: 用于展示相关的页面内容节点的操作</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月18日
 * @version 1.0
 */

@Controller
@RequestMapping("content")
public class ContentController {
	
//	在这里注入一个service
	@Autowired
	private ContentService contentService; 
	
	
//	1.0查询某个分类下面的所有节点内容
@RequestMapping("/query/list")		
public @ResponseBody  EasyUIDataGridResult getContentNodeList(long categoryId,
		int page,int rows){
	
//	调用service 进行查询
	EasyUIDataGridResult easyUIDataGridResult=contentService.getContentList(categoryId, page, rows);
//	返回结果
	return easyUIDataGridResult;
}	
	
	
//2.0添加前台页面的内容
@RequestMapping(value="/save", method=RequestMethod.POST)
public @ResponseBody TaotaoResult createContent(TbContent content){
	TaotaoResult taotaoResult=contentService.addContent(content);
	return taotaoResult;
}






}
