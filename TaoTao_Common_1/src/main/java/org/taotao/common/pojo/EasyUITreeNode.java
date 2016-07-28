package org.taotao.common.pojo;

import java.io.Serializable;

/**
 * <p>Title: EasyUITreeNode</p>
 * <p>Description: 创建easyui的包装类文件,这个之中主要包括了easyUI需要的参数</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月13日
 * @version 1.0
 */
public class EasyUITreeNode implements Serializable{
//	属性值
	private int id;					//节点的id
	private String text;			//节点内容
	private String state;		//节点状态
	
	
//	set/get方法
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	

}
