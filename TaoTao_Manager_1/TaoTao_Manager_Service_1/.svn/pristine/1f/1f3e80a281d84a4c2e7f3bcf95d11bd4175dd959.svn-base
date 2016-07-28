package org.taotao.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taotao.common.pojo.EasyUITreeNode;
import org.taotao.dao.TbItemCatMapper;
import org.taotao.pojo.TbItemCat;
import org.taotao.pojo.TbItemCatExample;
import org.taotao.pojo.TbItemCatExample.Criteria;
import org.taotao.service.ItemCatService;

/**
 * <p>Title: ItemCatServiceImpl</p>
 * <p>Description: ItemCatService接口的实现类</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月13日
 * @version 1.0
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
	
//	注入一个mapper
	@Autowired
	private TbItemCatMapper itemCatMapper;
	
//1.0	查询某个节点下的商品类目集合	
	@Override
public List<EasyUITreeNode> getItemCatList(long parentId	){
//1.1根据parentId查询分类的额列表
	TbItemCatExample tbItemCatExample=new TbItemCatExample();
//1.2设置查询条件
	Criteria criteria=tbItemCatExample.createCriteria();
	criteria.andParentIdEqualTo(parentId);
//1.3执行查询条件
	List<TbItemCat> list = itemCatMapper.selectByExample(tbItemCatExample);
//初始化一个一个EasyUITreeNode集合
	ArrayList<EasyUITreeNode> easyUITreeNodeList=new ArrayList<>();
	for(TbItemCat itemCat:list){
		EasyUITreeNode easyUITreeNode=new EasyUITreeNode();
		easyUITreeNode.setId(itemCat.getId().intValue());
		easyUITreeNode.setText(itemCat.getName());
		easyUITreeNode.setState(itemCat.getIsParent()?"closed":"open");
		easyUITreeNodeList.add(easyUITreeNode);
	}
	return  easyUITreeNodeList;
}	
	
	
}
