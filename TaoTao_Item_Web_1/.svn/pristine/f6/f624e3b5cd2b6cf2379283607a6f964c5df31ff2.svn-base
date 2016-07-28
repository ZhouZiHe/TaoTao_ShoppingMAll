package org.taotao.item.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.taotao.common.pojo.TaotaoResult;
import org.taotao.item.service.ItemGenService;
import org.taotao.item.service.ItemService;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;

@Controller
public class FreeMarkerController {

	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	@Autowired
	private ItemService itemService;
	@Value("${HTML_GEN_PATH}")
	private String HTML_GEN_PATH;
	
	@Autowired
	private ItemGenService itemGenService;

	@RequestMapping("/genhtml")
	@ResponseBody
	public TaotaoResult genHtml() throws Exception {
		// 获得配置对象
		Configuration configuration = freeMarkerConfigurer.getConfiguration();
		// 获得模板对象
		Template template = configuration.getTemplate("hello.ftl");
		// 第六步：创建一个数据集，可以使用map也可以使用pojo。把模板使用的数据封装好。
		Map map = new HashMap<>();
		map.put("hello", "hello freemarker");

		// 第七步：创建一Writer对象，指定html输出的路径及文件名。
		Writer writer = new FileWriter(new File("D:\\temp\\0823\\out\\hello1.html"));
		// 第八步：调用模板对象process方法，生成静态页面。需要两个参数：数据集、writer对象。
		template.process(map, writer);
		// 第九步：关闭writer对象。
		writer.close();
		return TaotaoResult.ok();
	}

	@RequestMapping("/genItemHtml/{itemId}")
	@ResponseBody
	public String genItemHtml(@PathVariable Long itemId) throws Exception {
		itemGenService.genItemHtml(itemId);
		return "OK";
	}

}
