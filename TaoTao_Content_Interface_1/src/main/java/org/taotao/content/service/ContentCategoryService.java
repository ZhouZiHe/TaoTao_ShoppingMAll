package org.taotao.content.service;

import java.util.List;

import org.taotao.common.pojo.EasyUITreeNode;
import org.taotao.common.pojo.TaotaoResult;

/**
 * <p>Title: ContentCategory</p>
 * <p>Description: 页面内容业务接口</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月17日
 * @version 1.0
 */
public interface ContentCategoryService {

//1.0	分类,通过父节点查询子节点,进行展示
	List<EasyUITreeNode> getContentCatList(long parentId);
//2.0	创建一个添加分类节点到的方法
	TaotaoResult addCateGoryNode(long parentId, String name);

}
