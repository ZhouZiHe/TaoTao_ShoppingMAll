package org.taotao.item.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taotao.dao.TbItemDescMapper;
import org.taotao.dao.TbItemMapper;
import org.taotao.dao.TbItemParamItemMapper;
import org.taotao.dao.TbItemParamMapper;
import org.taotao.item.service.ItemService;
import org.taotao.pojo.TbItem;
import org.taotao.pojo.TbItemDesc;
import org.taotao.pojo.TbItemDescExample;
import org.taotao.pojo.TbItemExample;
import org.taotao.pojo.TbItemParam;
import org.taotao.pojo.TbItemDescExample.Criteria;
import org.taotao.pojo.TbItemParamExample;
import org.taotao.pojo.TbItemParamItem;
import org.taotao.pojo.TbItemParamItemExample;

/**
 * <p>Title: ItemServiceImpl</p>
 * <p>Description: 商品相关的业务层操作</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月27日
 * @version 1.0
 */
@Service
public class ItemServiceImpl implements ItemService{


	@Autowired//在这里注入一个TbitemMapper
	private  TbItemMapper tbItemMapper;
	@Autowired//在这里注入一个TbItemDescMapper
	private  TbItemDescMapper tbItemDescMapper;
	@Autowired//在这里注入一个TbItemparam
	private TbItemParamItemMapper tbItemParamItemMapper;
	
//	1.0 通过id查找商品
	@Override
public TbItem getItemById(long ItemId){
		TbItem tbItem = tbItemMapper.selectByPrimaryKey(ItemId);
		return tbItem;
}
	
//	2.0 通过id查找商品详细信息
	@Override
	public TbItemDesc getItemDescById(Long itemId) {
//		创建一个查询对象
		TbItemDescExample tbItemDescExample=new TbItemDescExample();
//		创建查询条件
		Criteria criteria = tbItemDescExample.createCriteria();
//		添加条件
		criteria.andItemIdEqualTo(itemId);
//		执行查询
		List<TbItemDesc> list = tbItemDescMapper.selectByExample(tbItemDescExample);
		TbItemDesc tbItemDesc=list.get(0);
//		返回结果
		return tbItemDesc;
	}

//3.0 查询商品的规格内容
	@Override
	public TbItemParamItem getItemParamByItemId(Long itemId) {
//		创建查询对象
		TbItemParamItemExample itemParamItemExample=new TbItemParamItemExample();
//		创建条件对象
		org.taotao.pojo.TbItemParamItemExample.Criteria criteria = itemParamItemExample.createCriteria();
//		向查询条件中添加条件
		criteria.andItemIdEqualTo(itemId);
//		执行查询条件
		List<TbItemParamItem> list = tbItemParamItemMapper.selectByExample(itemParamItemExample);
//		得到结果
		TbItemParamItem tbItemParamItem = list.get(0);
//		返回结果
		return tbItemParamItem; 
	}
	
	
	
}
