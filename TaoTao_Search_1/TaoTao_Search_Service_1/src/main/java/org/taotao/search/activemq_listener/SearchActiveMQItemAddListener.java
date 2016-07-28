package org.taotao.search.activemq_listener;

import java.util.HashMap;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.taotao.common.pojo.SearchItem;
import org.taotao.pojo.TbItem;
import org.taotao.search.mapper.SearchItemMapper;
import org.taotao.search.service.SearchItemService;

import com.alibaba.druid.sql.ast.expr.SQLCaseExpr.Item;


/***
 * <p>Title: SearchActiveMQListener</p>
 * <p>Description: 搜索服务的关于商品添加监听器</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月22日
 * @version 1.0
 */
@Component
public class SearchActiveMQItemAddListener implements MessageListener {
	
	@Autowired//注入一个搜索的服务dao索引库擦做对象
	private SearchItemMapper searchItemMapper;
	@Autowired//注入一个solrServer对象
	private SolrServer solrServer;
	
//1.0	监听到消息的操作
	@Override
	public void onMessage(Message message) {
//		TextMessage textMessage=(TextMessage) message;
		ObjectMessage objectMessage=(ObjectMessage) message;
try {
//		得到对象数据
		HashMap<String, Object> map=(HashMap<String, Object>) objectMessage.getObject();
		TbItem tbItem=(TbItem) map.get("tbItem");
//		1.1 创建一个商品搜索结果的对象
		SearchItem searchItem=null;
//		1.2接收商品的id
		long itemId=0;
//			itemId=Long.parseLong(textMessage.getText());
			itemId=tbItem.getId();
//		1.3根据商品id查找相对应的搜索商品对象
			searchItem= searchItemMapper.getSearchItemById(itemId);
//		1.4创建一个solr的文档写入流对象
			SolrInputDocument solrDocument=new SolrInputDocument();
//		1.5向solr对象中添加数据
			solrDocument.setField("id", searchItem.getId());
			solrDocument.setField("item_title", searchItem.getTitle());
			solrDocument.addField("item_sell_point", searchItem.getSell_point());
			solrDocument.addField("item_price", searchItem.getPrice());
			solrDocument.addField("item_image", searchItem.getImage());
			solrDocument.addField("item_category_name", searchItem.getCategory_name());
			solrDocument.addField("item_desc", searchItem.getItem_des());
//		1.6将数据添加到solrservcer中
			solrServer.add(solrDocument);
//		1.7提交添加	
			solrServer.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
}
