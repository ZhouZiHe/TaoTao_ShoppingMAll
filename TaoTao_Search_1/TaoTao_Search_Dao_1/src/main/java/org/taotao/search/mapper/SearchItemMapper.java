package org.taotao.search.mapper;
import java.util.List;
import org.taotao.common.pojo.SearchItem;

/**
 * <p>Title: SearchItemMapper</p>
 * <p>Description: 索引库数据同步的dao</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月20日
 * @version 1.0
 */
public interface SearchItemMapper {

//1.0	返回一个从数据库中查询出索引库需要的特定字段的所有集合
		List<SearchItem> getSearchItemList();
//		2.0	返回通过id查找数据库中查询出索引需要特定字典的对应对象
			SearchItem getSearchItemById(long itemId);
	
}
