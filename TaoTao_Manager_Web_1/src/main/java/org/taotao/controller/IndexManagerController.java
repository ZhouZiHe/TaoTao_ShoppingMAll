package org.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.taotao.common.pojo.TaotaoResult;
import org.taotao.search.service.SearchItemService;

/**
 * <p>Title: IndexManagerController</p>
 * <p>Description: 实现索引库的数据的操作</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月20日
 * @version 1.0
 */

@Controller
public class IndexManagerController {
	
	@Autowired//注入一个SearchItenService接口
	private SearchItemService searchItemService;
	
//	1.0 实现数据库和数据库的数据完全导入同步
@RequestMapping("/index/importall")
public @ResponseBody TaotaoResult synchronizeAllItems(){
	try {
//	1.1调用service方法同步数据库和索引库的数据
		TaotaoResult taotaoResult = searchItemService.importAllItems();
		return taotaoResult;
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return TaotaoResult.build(500, "同步失败");
	}
	
}
	
}
