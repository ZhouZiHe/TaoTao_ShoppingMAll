package org.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.taotao.common.pojo.EasyUIDataGridResult;
import org.taotao.common.pojo.TaotaoResult;
import org.taotao.dao.Item_Param_CatMapper;
import org.taotao.dao.TbItemParamMapper;
import org.taotao.pojo.Item_Param_Cat;
import org.taotao.pojo.TbItemParam;
import org.taotao.pojo.TbItemParamExample;
import org.taotao.pojo.TbItemParamExample.Criteria;
import org.taotao.service.ItemParamService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * <p>Title: ItemParamServiceImpl</p>
 * <p>Description: 商品规格参数的业务操作类</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月29日
 * @version 1.0
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {
	
	@Autowired//注入一个item_param_cat mapper 操作对象
	private Item_Param_CatMapper item_Param_CatMapper;
	@Autowired//注入一个parammapper的操作类
	private TbItemParamMapper tbItemParamMapper;
	
//	1.0 分页查询关于规格参数列表
	@Override
	public EasyUIDataGridResult getItemParamCatPageList(int page,int rows){
//1.1先进性一个分页的处理
		PageHelper.startPage(page, rows);
//1.2 调用方法进行查询
		List<Item_Param_Cat> paramCatList = item_Param_CatMapper.getParamCatList();
//	1.3 获取分页的信息
		PageInfo< Item_Param_Cat> pageInfo=new PageInfo<>(paramCatList);
//	1.4 初始化这个包装类
		EasyUIDataGridResult easyUIDataGridResult=new EasyUIDataGridResult();
//	1.5 进行赋值
		easyUIDataGridResult.setRows(pageInfo.getList());
		easyUIDataGridResult.setTotal(pageInfo.getTotal());
//	1.6返回结果
		return easyUIDataGridResult;
}
	
//2.0 添加规格参数进行检验
	@Override
	public TaotaoResult checkParamCat(long catId){
//创面一个查询对象
		TbItemParamExample tbItemParamExample=new TbItemParamExample();	
//		创建条件对象
		Criteria criteria = tbItemParamExample.createCriteria();
//		向条件对象中添加条件
		criteria.andItemCatIdEqualTo(catId);
//		执行查询条件
		List<TbItemParam> tbItemParamList = tbItemParamMapper.selectByExample(tbItemParamExample);
//		判断是否为空
		if(tbItemParamList!=null&& !tbItemParamList.isEmpty()){
			return  TaotaoResult.ok(true);
		}
		return  TaotaoResult.ok(false);
}
	
//	3.0 添加商品的规格参数
	@Override
	public TaotaoResult insertItemParam(TbItemParam tbItemParam){
//		补全数据
		Date date=new Date();
		tbItemParam.setCreated(date);
		tbItemParam.setUpdated(date);
//		进行添加数据
		tbItemParamMapper.insert(tbItemParam);
//		返回一个成功的结果
		return TaotaoResult.ok();
	}
	
//	4.0 通过商品itemParamId得到一个规格对象
	@Override
	public TbItemParam geTbItemParamById(long paramId){
			TbItemParam tbItemParam = tbItemParamMapper.selectByPrimaryKey(paramId);
		return tbItemParam;
	}
	
	
	
	
	
	
	
}
