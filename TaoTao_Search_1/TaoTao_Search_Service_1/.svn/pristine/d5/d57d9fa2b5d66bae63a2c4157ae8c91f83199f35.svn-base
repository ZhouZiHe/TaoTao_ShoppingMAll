package org.taotao.search.service.impl;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taotao.common.pojo.SearchResult;
import org.taotao.search.dao.SearchDao;
import org.taotao.search.service.SearchService;


/**
 * <p>Title: SearchServiceImpl</p>
 * <p>Description: 通过条件查询商品的业务层实现类</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月20日
 * @version 1.0
 */
@Service
public class SearchServiceImpl implements SearchService {

	@Autowired //注入一个dao链接操作索引库的方法
	private SearchDao searchDao;
	
//	1.0 业务层进行拼接查询条件
	@Override
public SearchResult searchResult(String queryString ,int page ,int rows) throws Exception{
//		1.1初始化一个查询对象
		SolrQuery solrQuery=new SolrQuery();
//		1.2想查询对象中添加查询条件
//		添加一个主查询条件
		solrQuery.setQuery(queryString);
//		添加分页查询条件
		solrQuery.setStart((page-1)*rows);
		solrQuery.setRows(rows);
//		设置默认的额搜索域
		solrQuery.set("df", "item_title");
//		设置高亮
		solrQuery.setHighlight(true);
//		设置高亮的预
		solrQuery.addHighlightField("item_title");
//		设置高粱的头和尾
		solrQuery.setHighlightSimplePre("<font class=\"skcolor_ljg\">");
		solrQuery.setHighlightSimplePost("</font>");
//		1.3 执行查询
		SearchResult searchResult = searchDao.query(solrQuery);
//		计算页面的总数
		int pageCount=(int) Math.ceil(searchResult.getRecordCount()/rows) ;
		searchResult.setPageCount(pageCount);
		searchResult.setCurPage(page);
//		1.4 返回结果
		return searchResult;
}
	
	
}
