package org.taotao.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taotao.common.pojo.EasyUITreeNode;
import org.taotao.common.pojo.TaotaoResult;
import org.taotao.content.service.ContentCategoryService;
import org.taotao.dao.TbContentCategoryMapper;

/**
 * <p>Description: 页面内容展示业务接口</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月17日
 * @version 1.0
 */
import org.taotao.pojo.TbContentCategory;
import org.taotao.pojo.TbContentCategoryExample;
import org.taotao.pojo.TbContentCategoryExample.Criteria;
/**
 * <p>Title: ContentCategoryServiceImpl</p>
 * <p>Description: 页面内容业务</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月17日
 * @version 1.0
 */

@Service
public class ContentCategoryServiceImpl  implements ContentCategoryService{

	@Autowired//注入一个dao操作类
	private TbContentCategoryMapper contentCategoryMapper;
	
//	1.0 获取所有的页面内容类别的分类
	@Override
	public List<EasyUITreeNode> getContentCatList(long parentId	){
//	 1.1创建一个example对象
		TbContentCategoryExample contentCategoryExample=new TbContentCategoryExample();
//	 1.2通过example对象创建一个查询条件
		Criteria criteria=contentCategoryExample .createCriteria();
//	 1.3封装查询条件
		criteria.andParentIdEqualTo(parentId);
//	 1.4执行查询条件
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(contentCategoryExample	); 
//	 1.5创建一个EasyUITree的list集合	
		List<EasyUITreeNode> resultList=new ArrayList<>();
//	 1.6	遍历向结果集合中添加
		for(TbContentCategory tbContentCategory:list){
//	 1.5	初始化一个EasyUITreeNOde对象,并填值
			EasyUITreeNode easyUITreeNode=new EasyUITreeNode();
			easyUITreeNode.setId(tbContentCategory.getId().intValue());
			easyUITreeNode.setText(tbContentCategory.getName());;
			easyUITreeNode.setState(tbContentCategory.getIsParent()
					? "closed" : "open");
			resultList.add(easyUITreeNode);
		}
//1.6 返回结果
	return resultList;
	}
	
//	2.0 在某个节点下添加一个内容分类
	@Override
	public TaotaoResult addCateGoryNode(long parentId,String name){
//		2.1初始化创建一个ContentCategory对象
		TbContentCategory tbContentCategory=new TbContentCategory();
//		2.2进行添加值
		tbContentCategory.setParentId(parentId);		
		tbContentCategory.setName(name);
		tbContentCategory.setIsParent(false);
		//可选值:1(正常),2(删除)
		tbContentCategory.setStatus(1);
		tbContentCategory.setSortOrder(1);
		Date date=new  Date();
		tbContentCategory.setCreated(date);
		tbContentCategory.setUpdated(date);
//		2.3插入数据
		contentCategoryMapper.insert(tbContentCategory);
//		2.4判断被添加子节点的父节点的parentId状态
		TbContentCategory parent=contentCategoryMapper.selectByPrimaryKey(parentId);
//		2.5获取isparent属性
		if(!parent.getIsParent()){
			parent.setIsParent(true);
			contentCategoryMapper.updateByPrimaryKey(parent);
		}
//	   2.6返回结果
		return TaotaoResult.ok(tbContentCategory);
				
	}
	
	
	
	
	
}
