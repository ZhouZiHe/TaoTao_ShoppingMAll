package org.taotao.content.service;

import java.util.List;

import org.taotao.common.pojo.Ad1Node;
import org.taotao.common.pojo.EasyUIDataGridResult;
import org.taotao.common.pojo.TaotaoResult;
import org.taotao.pojo.TbContent;

/**
 * <p>Title: ContentService</p>
 * <p>Description: 用于操作前台的页面内容的接口</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月18日
 * @version 1.0
 */
public interface ContentService {

//	1.0创建一个查询前台页面节点内的内容
	EasyUIDataGridResult getContentList(Long categoryId, int page, int rows);
//	2.0 添加前台页面展示的内容
	TaotaoResult addContent(TbContent content);
//	3.0 通过前台传递才会唤醒的我
	List<Ad1Node> getAd1FromContentList(long categoryId);

	
}
