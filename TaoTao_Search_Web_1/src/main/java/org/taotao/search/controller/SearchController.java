package org.taotao.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.taotao.common.pojo.SearchResult;
import org.taotao.search.service.SearchItemService;
import org.taotao.search.service.SearchService;

/**
 * <p>Title: SearchController</p>
 * <p>Description: 搜索表现层操作</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月20日
 * @version 1.0
 */
@Controller
public class SearchController {

	@Autowired//注入一个SearchService接口
	private SearchService searchService;
	
//1.0 通过查询条件从索引库中查找商品	
@RequestMapping("/search")	
	public String searchItem(@RequestParam("q")String queryString,
			@RequestParam(defaultValue="1") Integer  page , 
			@RequestParam(defaultValue="60") Integer rows,
			Model model){
try {
		queryString=new String(queryString.getBytes("iso8859-1"), "utf-8");
		SearchResult searchResult= searchService.searchResult(queryString, page, rows);
		model.addAttribute("query", queryString);
		model.addAttribute("page", page);
		model.addAttribute("itemList", searchResult.getItemList());
		model.addAttribute("totalPage", searchResult.getPageCount());
//	返回结果
		return "search";
	} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "您的网络故障了");
	return "error/exception";
	}
}
	
}
