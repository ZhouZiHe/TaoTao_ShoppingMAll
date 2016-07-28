package org.taotao.freemaker.listener;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.taotao.pojo.TbItem;
import org.taotao.pojo.TbItemDesc;
import freemarker.template.Configuration;
import freemarker.template.Template;


/**
 * <p>Title: FreeMakerListener</p>
 * <p>Description: 监听添加商品的静态页面</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月23日
 * @version 1.0
 */
@Component
public class FreeMakerAddItemListener implements MessageListener {

	@Autowired//注入一个freemaker 的配置
	private FreeMarkerConfigurer freeMarkerConfigurer;
	@Value("${HTML_GEN_PATH}")
	private String HTML_GEN_PATH;
	
	
	
	@Override
	public void onMessage(Message message) {
//		从消息中获得商品的对象
		ObjectMessage objectMessage= (ObjectMessage) message;
//		得到消息中的对象
		try {
			HashMap<String, Object> map= (HashMap<String, Object>) objectMessage.getObject();
//			从集合中的到商品对象
			TbItem tbItem=(TbItem) map.get("tbItem");
//			从集合中得到商品详细信息对象
			TbItemDesc tbItemDesc=(TbItemDesc) map.get("tbItemDesc");
//			开始创建freemaker 页面
//			创建数据集合
			Map< String, Object> fkMap =new HashMap<>();
			fkMap.put("item", tbItem);
			fkMap.put("itemDesc", tbItemDesc);
//			使用FreeMaker生成网页
			Configuration configuration=freeMarkerConfigurer.createConfiguration();
//			设置模板
			Template template=configuration.getTemplate("item.ftl");
//			创建一个写入流对象
			Writer  writer=new FileWriter(new File(HTML_GEN_PATH + tbItem.getId() +".html"));
//			调用模板生成静态页面
			template.process(fkMap, writer);
//			关闭流
			writer.close();
 		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
