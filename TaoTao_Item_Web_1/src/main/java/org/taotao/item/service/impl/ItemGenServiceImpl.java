package org.taotao.item.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.taotao.item.service.ItemGenService;
import org.taotao.item.service.ItemService;
import org.taotao.pojo.TbItem;
import org.taotao.pojo.TbItemDesc;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Service
public class ItemGenServiceImpl implements ItemGenService {

	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	@Autowired
	private ItemService itemService;
	@Value("${HTML_GEN_PATH}")
	private String HTML_GEN_PATH;

	@Override
	public void genItemHtml(Long itemId) throws Exception {
		// 调用服务查询商品信息
		TbItem item = itemService.getItemById(itemId);
		// 商品描述
		TbItemDesc itemDesc = itemService.getItemDescById(itemId);
		// 创建一数据集
		Map map = new HashMap<>();
		map.put("item", item);
		map.put("itemDesc", itemDesc);
		// 使用freemarker生成网页
		Configuration configuration = freeMarkerConfigurer.getConfiguration();
		// 获得模板对象
		Template template = configuration.getTemplate("item.ftl");

		// 第七步：创建一Writer对象，指定html输出的路径及文件名。
		Writer writer = new FileWriter(new File(HTML_GEN_PATH + itemId + ".html"));
		// 第八步：调用模板对象process方法，生成静态页面。需要两个参数：数据集、writer对象。
		template.process(map, writer);
		// 第九步：关闭writer对象。
		writer.close();

	}

}
