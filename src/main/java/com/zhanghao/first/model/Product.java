package com.zhanghao.first.model;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {
	private Long id;
	private String name;
	private Integer price;
	private Integer state;
	private Date createTime;
	private Date updateTime;

	public Integer getState() {
		return state;
	}

	public void setState(Integer statue) {
		this.state = statue;
	}

	private String desc;
	private Integer productId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

}
