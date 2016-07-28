package org.taotao.pojo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TbItem implements Serializable{
	
	
//	添加一个添加商品购物车的时间
	private long addCartTime;
	
	public long getAddCartTime() {
		return addCartTime;
	}

	public void setAddCartTime(long addCartTime) {
		this.addCartTime = addCartTime;
	}
	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_item.id
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_item.title
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_item.sell_point
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    private String sellPoint;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_item.price
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    private Long price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_item.num
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    private Integer num;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_item.barcode
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    private String barcode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_item.image
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    private String image;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_item.cid
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    private Long cid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_item.status
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_item.created
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    private Date created;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_item.updated
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    private Date updated;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_item.id
     *
     * @return the value of tb_item.id
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_item.id
     *
     * @param id the value for tb_item.id
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_item.title
     *
     * @return the value of tb_item.title
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_item.title
     *
     * @param title the value for tb_item.title
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_item.sell_point
     *
     * @return the value of tb_item.sell_point
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    public String getSellPoint() {
        return sellPoint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_item.sell_point
     *
     * @param sellPoint the value for tb_item.sell_point
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint == null ? null : sellPoint.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_item.price
     *
     * @return the value of tb_item.price
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    public Long getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_item.price
     *
     * @param price the value for tb_item.price
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_item.num
     *
     * @return the value of tb_item.num
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    public Integer getNum() {
        return num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_item.num
     *
     * @param num the value for tb_item.num
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_item.barcode
     *
     * @return the value of tb_item.barcode
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_item.barcode
     *
     * @param barcode the value for tb_item.barcode
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_item.image
     *
     * @return the value of tb_item.image
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    public String getImage() {
        return image;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_item.image
     *
     * @param image the value for tb_item.image
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_item.cid
     *
     * @return the value of tb_item.cid
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    public Long getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_item.cid
     *
     * @param cid the value for tb_item.cid
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    public void setCid(Long cid) {
        this.cid = cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_item.status
     *
     * @return the value of tb_item.status
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_item.status
     *
     * @param status the value for tb_item.status
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_item.created
     *
     * @return the value of tb_item.created
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_item.created
     *
     * @param created the value for tb_item.created
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_item.updated
     *
     * @return the value of tb_item.updated
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_item.updated
     *
     * @param updated the value for tb_item.updated
     *
     * @mbggenerated Fri Dec 11 19:25:29 CST 2015
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
//   增加一个images的方法
    @JsonIgnore
    public String[] getImages() {
		String image = this.getImage();
		if (image != null && !"".equals(image)) {
			String[] strings = image.split(",");
			return strings;
		}
		return null;
	}
    
}