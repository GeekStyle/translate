package com.geekstylecn.translate.model;

import java.util.List;

import com.geekstylecn.translate.annotation.I18N;

public class MallCustomProduct {
	
	private Long id;
	private String price;
	private String uom;
	@I18N(table="mall_customer_product",recordId="id",column="name")
	private String name;
	private List<Review> reviewList;
	
	public MallCustomProduct() {
		super();
	}

	public MallCustomProduct(Long id, String price, String uom, String name, List<Review> reviewList) {
		super();
		this.id = id;
		this.price = price;
		this.uom = uom;
		this.name = name;
		this.reviewList = reviewList;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Review> getReviewList() {
		return reviewList;
	}
	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}
	
}
