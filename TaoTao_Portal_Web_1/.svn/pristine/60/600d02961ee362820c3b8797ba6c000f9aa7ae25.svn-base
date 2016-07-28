package org.taotao.portal.controller;

import java.util.List;

import javax.swing.text.AbstractDocument.Content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.taotao.common.pojo.Ad1Node;
import org.taotao.common.utils.JsonUtils;
import org.taotao.content.service.ContentService;

/**
 * 
 * <p>Title: IndexController</p>
 * <p>Description:前台展示门户 </p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月17日
 * @version 1.0
 */
@Controller
public class IndexController {

//	注入一个ContentService接口
	@Autowired
	private ContentService  contentService;
//	初始化一堆有关页面的参数
	@Value("${AD1_CATEGORY_ID}")
	private long AD1_CATEGORY_ID;
	@Value("${AD1_WIDTH}")
	private Integer AD1_WIDTH;
	@Value("${AD1_WIDTH_B}")
	private Integer AD1_WIDTH_B;
	@Value("${AD1_HEIGHT}")
	private Integer AD1_HEIGHT;
	@Value("${AD1_HEIGHT_B}")
	private Integer AD1_HEIGHT_B;
	
//	1.0展示首页,在这里初始化一个轮播图
	@RequestMapping("/index")
public String showIndex(Model model){
//	1.1调用Contentservice方法查询分类下的内容
		List<Ad1Node> ad1List = contentService.getAd1FromContentList(AD1_CATEGORY_ID);
//	1.2 循环遍历赋值	
		for (Ad1Node ad1Node : ad1List) {
			ad1Node.setHeight1(AD1_HEIGHT);
			ad1Node.setHeight2(AD1_HEIGHT_B);
			ad1Node.setWidth1(AD1_WIDTH);
			ad1Node.setWidth2(AD1_WIDTH_B);
		}
//1.3 将结果转为json数据,并添加到模型对象中
	String ad1Json = JsonUtils.objectToJson(ad1List);
	model.addAttribute("ad1", ad1Json);
//1.4 返回结果视图
	return "index";
	}
	
	
	
	
}
