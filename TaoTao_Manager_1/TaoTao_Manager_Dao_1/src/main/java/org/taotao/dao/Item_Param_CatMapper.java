package org.taotao.dao;
import java.util.List;
import org.taotao.common.pojo.SearchItem;
import org.taotao.pojo.Item_Param_Cat;

/**
 * <p>Title: SearchItemMapper</p>
 * <p>Description: 索引库数据同步的dao</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月20日
 * @version 1.0
 */
public interface Item_Param_CatMapper {

//1.0返回一个数据库中的关联查询出来tbItemCat和tbItemParma表
	List<Item_Param_Cat> getParamCatList();
	

	
}
