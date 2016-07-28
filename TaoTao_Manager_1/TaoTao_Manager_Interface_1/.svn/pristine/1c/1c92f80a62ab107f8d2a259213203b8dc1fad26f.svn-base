package org.taotao.service;

import org.taotao.common.pojo.EasyUIDataGridResult;
import org.taotao.common.pojo.TaotaoResult;
import org.taotao.pojo.TbItemParam;

/**
 * <p>Title: ItemParamService</p>
 * <p>Description: 商品规格的接口</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月29日
 * @version 1.0
 */

public interface ItemParamService {

//1.0 分页查询规格参数
	EasyUIDataGridResult getItemParamCatPageList(int page, int rows);
//2.0 判断规格参数是否被使用
	TaotaoResult checkParamCat(long catId);
//3.0 添加商品规格参数
	TaotaoResult insertItemParam(TbItemParam tbItemParam);
//4.0 通过规格参数的id得到规格参数对象
	TbItemParam geTbItemParamById(long paramId);

}
