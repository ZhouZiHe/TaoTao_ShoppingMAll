package org.taotao.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.taotao.common.pojo.Ad1Node;
import org.taotao.common.pojo.EasyUIDataGridResult;
import org.taotao.common.pojo.TaotaoResult;
import org.taotao.common.utils.JsonUtils;
import org.taotao.content.service.ContentService;
import org.taotao.content.service.jedisclient.JedisClient;
import org.taotao.dao.TbContentMapper;
import org.taotao.pojo.TbContent;
import org.taotao.pojo.TbContentExample;
import org.taotao.pojo.TbContentExample.Criteria;

import com.alibaba.druid.sql.visitor.PrintableVisitor;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * <p>Title: ContentServiceImpl</p>
 * <p>Description: 这是前台页面展示内容的业务操作</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月18日
 * @version 1.0
 */
@Service
public class ContentServiceImpl implements ContentService{
	
//	在这里注入一个TbContentMapper对象
	@Autowired
	private TbContentMapper  tbContentMapper;
//	在这里注入一个jedisclient
	@Autowired
	private JedisClient jedisClient;
//	从redis配置文件中获得一个redis的key
	@Value("${REDIS_CONTENT_HASH_KEY}")
	private  String  REDIS_CONTENT_HASH_KEY;
	
	
	
	
//	1.0查询所有的某个节点下的所有内容
	@Override
public  EasyUIDataGridResult getContentList(Long categoryId,
		int page,int rows){
//		1.1创建一个查询对象的实例
		TbContentExample tbContentExample=new TbContentExample();
		Criteria criteria=tbContentExample.createCriteria();
//		1.2向查询条件对象中添加查询条件
		criteria.andCategoryIdEqualTo(categoryId);
//		1.3进行拦截器的分页
		PageHelper.startPage(page, rows);
//		1.4执行查询条件
		List<TbContent> list = tbContentMapper.selectByExample(tbContentExample);
//		1.5取分页的信息
		PageInfo<TbContent> pageInfo=new PageInfo<>(list);
		EasyUIDataGridResult easyUIDataGridResult=new EasyUIDataGridResult();
		easyUIDataGridResult.setTotal(pageInfo.getTotal());
		easyUIDataGridResult.setRows(list);
//		1.6返回结果
		return easyUIDataGridResult;
}
	
//	2.0添加一个前台内容的方法
@Override
public TaotaoResult addContent(TbContent content){
//	2.1 补全属性
	Date date=new Date();
	content.setCreated(date);
	content.setUpdated(date);
//	2.2执行插入数据库
	tbContentMapper.insert(content);
//	和jedis缓存结合起来
	//内容添加成功后需要缓存同步
	jedisClient.hdel(REDIS_CONTENT_HASH_KEY, content.getCategoryId().toString());
	
	
	
//	2.3插入成功返回结果
	return TaotaoResult.ok();
}
	
//3.0 编写一个通过分类的id获得要在前台展示的数据集合
@Override
public List<Ad1Node> getAd1FromContentList(long categoryId){
//3.1与redis相结合提供缓存,添加一个查询缓存的业务逻辑
try{
//	从redis数据库中获取缓存数据
	String json=jedisClient.hget(REDIS_CONTENT_HASH_KEY,categoryId+"" );
	if(StringUtils.isNoneBlank(json)){
		List<Ad1Node> list = JsonUtils.jsonToList(json, Ad1Node.class);
		return  list;
	}
}catch(Exception e){
	e.printStackTrace();
}
//	当数据库中没有这个缓存对象的时候就要从数据库中进行查询,创建一个查询对象
	TbContentExample tbContentExample=new TbContentExample();
	Criteria criteria=tbContentExample.createCriteria();
//	3.2  添加查询条件
	criteria.andCategoryIdEqualTo(categoryId);
//	3.3  执行查询条件
   List<TbContent> list = tbContentMapper.selectByExample(tbContentExample);
// 3.4 创建一个初始化的集合
   List<Ad1Node> resultList=new ArrayList<>();
// 3.5  遍历向结果集合中添加值
   for (TbContent tbContent : list) {
	Ad1Node ad1Node=new Ad1Node();
	ad1Node.setAlt(tbContent.getSubTitle());
	ad1Node.setHref(tbContent.getUrl());
	ad1Node.setSrc1(tbContent.getPic());
	ad1Node.setSrc2(tbContent.getPic2());
	resultList.add(ad1Node);
}
//   将返回的结果返回给redis数据库
   try{
	  jedisClient.hset(REDIS_CONTENT_HASH_KEY, categoryId+"",JsonUtils.objectToJson(resultList) );
   }catch(Exception e){
	   e.printStackTrace();
 }
//	将结果返回
   return resultList;
}


}
