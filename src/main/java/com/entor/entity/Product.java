package com.entor.entity;

import java.sql.Date;
import java.util.List;

public class Product {

	private int id;
	private String name;
	private String subTitle;
	private float orignalPrice;
	private float promotePrice;
	private int stock;
	private int cid;
	private Date datetime;
	
	private Productimage firstProductImage;
	private List<Productimage> productSingleImages;
	private List<Productimage> productDetailImages;

	private int reviewCount;
	private int saleCount;
	
	public List<Productimage> getProductDetailImages() {
		return productDetailImages;
	}
	public void setProductDetailImages(List<Productimage> productDetailImages) {
		this.productDetailImages = productDetailImages;
	}
	public List<Productimage> getProductSingleImages() {
		return productSingleImages;
	}
	public void setProductSingleImages(List<Productimage> productSingleImages) {
		this.productSingleImages = productSingleImages;
	}
	public int getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}
	public int getSaleCount() {
		return saleCount;
	}
	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public float getOrignalPrice() {
		return orignalPrice;
	}
	public void setOrignalPrice(float orignalPrice) {
		this.orignalPrice = orignalPrice;
	}
	public float getPromotePrice() {
		return promotePrice;
	}
	public void setPromotePrice(float promotePrice) {
		this.promotePrice = promotePrice;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	public Productimage getFirstProductImage() {
		return firstProductImage;
	}
	public void setFirstProductImage(Productimage firstProductImage) {
		this.firstProductImage = firstProductImage;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", subTitle=" + subTitle + ", orignalPrice=" + orignalPrice
				+ ", promotePrice=" + promotePrice + ", stock=" + stock + ", cid=" + cid + ", datetime=" + datetime
				+ ", firstProductImage=" + firstProductImage + ", productSingleImages=" + productSingleImages
				+ ", productDetailImages=" + productDetailImages + ", reviewCount=" + reviewCount + ", saleCount="
				+ saleCount + "]";
	}
	
	
	
}
