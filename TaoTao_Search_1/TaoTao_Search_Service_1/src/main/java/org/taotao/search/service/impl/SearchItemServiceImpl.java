package org.taotao.search.service.impl;

import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;
import org.aspectj.weaver.AjAttribute.PrivilegedAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taotao.common.pojo.SearchItem;
import org.taotao.common.pojo.TaotaoResult;
import org.taotao.search.mapper.SearchItemMapper;
import org.taotao.search.service.SearchItemService;

/**
 * <p>Title: SearchItemServiceImpl</p>
 * <p>Description:用于操作搜索服务的实现类</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月20日
 * @version 1.0
 */
@Service
public class SearchItemServiceImpl implements SearchItemService {
	@Autowired//在这里注入一个关于搜索服务数据库和索引库之间的联系的mapper
	private SearchItemMapper searchItemMapper;
	@Autowired//在这里注入一个solr服务
	private SolrServer solrServer;
	
//	1.0 数据库中的所有数据导入到索引库中
	@Override
	public TaotaoResult importAllItems() throws Exception{
//		1.1第一步查询数据库得到所需要的字段属性的集合
		List<SearchItem> searchItemList=searchItemMapper.getSearchItemList();
//		1.2循环将数据写入到索引库中
		for (SearchItem searchItem : searchItemList) {
//			1.2.1创建一个solr的文档写入流对象
			SolrInputDocument solrDocument=new SolrInputDocument();
//			1.2.2向solr对象中添加数据
			solrDocument.setField("id", searchItem.getId());
			solrDocument.setField("item_title", searchItem.getTitle());
			solrDocument.addField("item_sell_point", searchItem.getSell_point());
			solrDocument.addField("item_price", searchItem.getPrice());
			solrDocument.addField("item_image", searchItem.getImage());
			solrDocument.addField("item_category_name", searchItem.getCategory_name());
			solrDocument.addField("item_desc", searchItem.getItem_des());
//			1.2.3将数据添加到solrservcer中
			solrServer.add(solrDocument);
		}
//		1.3提交事务
		solrServer.commit();
//		1.4 返回成功结果
		return TaotaoResult.ok();
	}

//2.0 通过id查找数据库向索引库添加一个新的索引文档对象


}
