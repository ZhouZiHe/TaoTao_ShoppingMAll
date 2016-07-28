package org.taotao.common.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>Title: Ad1Node</p>
 * <p>Description: 这是一个广告位展示的pojo</p>
 * <p>Email: zhouzihe@hotmail.com</p> 
 * @author	Zack
 * @date	2015年12月19日
 * @version 1.0
 */

public class Ad1Node implements Serializable{

//	定义高 
	@JsonProperty("height")
	private int  height1 ;
	@JsonProperty("heightB")
	private int  height2;
//定义宽
	@JsonProperty("width")
	private int  width1;
	@JsonProperty("widthB")
	private int  width2;
//	定义一个图片资源的路径
	@JsonProperty("src")
	 private String src1;
	@JsonProperty("srcB")
	 private String src2;
//	 定义图片的连接
	 private String href;
//	定义图片的额外展示关联内容
	 private String alt;
	
//	 提供set/get方法
	 public int getHeight1() {
		return height1;
	}
	public void setHeight1(int height1) {
		this.height1 = height1;
	}
	public int getHeight2() {
		return height2;
	}
	public void setHeight2(int height2) {
		this.height2 = height2;
	}
	public int getWidth1() {
		return width1;
	}
	public void setWidth1(int width1) {
		this.width1 = width1;
	}
	public int getWidth2() {
		return width2;
	}
	public void setWidth2(int width2) {
		this.width2 = width2;
	}
	public String getSrc1() {
		return src1;
	}
	public void setSrc1(String src1) {
		this.src1 = src1;
	}
	public String getSrc2() {
		return src2;
	}
	public void setSrc2(String src2) {
		this.src2 = src2;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getAlt() {
		return alt;
	}
	public void setAlt(String alt) {
		this.alt = alt;
	}
	 
	
	
	
	
	
}
