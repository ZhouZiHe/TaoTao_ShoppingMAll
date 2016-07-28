package org.taotao.search.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.taotao.common.pojo.SearchItem;
import org.taotao.common.pojo.SearchResult;
import org.taotao.search.dao.SearchDao;
/**
 * <p>Title: SearchDaoImpl</p>
 * <p>Description: 搜索服务的操作dao 类连接索引库</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月20日
 * @version 1.0
 */
@Repository
public class SearchDaoImpl implements SearchDao{
	
@Autowired
private SolrServer solrServer;//注入一个solrServer对象

//1.0通过查询对象进行查询
@Override
public SearchResult query(SolrQuery solrQuery) throws Exception{
//	1.1根据查询条件进行查询
	QueryResponse response = solrServer.query(solrQuery);
// 1.2通过查询结果得到一个文档对象集合
	SolrDocumentList solrDocumentList=response.getResults();
//	1.3初始化一个商品列表集合
	List<SearchItem> searchItemList=new ArrayList<>();
//	1.4遍历查询结果集进行赋值添加
	for (SolrDocument solrDocument: solrDocumentList) {
		SearchItem searchItem=new SearchItem();
		searchItem.setId(Long.parseLong(solrDocument.get("id").toString()));
		searchItem.setCategory_name((String) solrDocument.get("item_category_name"));
		searchItem.setImage((String) solrDocument.get("item_image"));
		searchItem.setPrice((long) solrDocument.get("item_price"));
		searchItem.setSell_point((String) solrDocument.get("item_sell_point"));
//		把title设置高亮
		Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
//		创建一个list集合,获取到高亮值
		List<String>  list=highlighting.get(solrDocument.get("id")).get("item_title");
		String itemTitle="";
		if (list!=null&&!list.isEmpty()){
			itemTitle=list.get(0);
		}else{
			itemTitle=solrDocument.get("item_title").toString();
		}
		searchItem.setTitle(itemTitle);
//		将赋值的对象添加到商品列表中
		searchItemList.add(searchItem);
	}
//初始化一个新的返回结果
	SearchResult searchResult=new SearchResult();
//	添加结果集合
	searchResult.setItemList(searchItemList);
//添加一个查询记录的总数
	searchResult.setRecordCount(solrDocumentList.getNumFound());
//	返回结果
	return searchResult;
}

	
}
