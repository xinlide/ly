package com.entor.entity;

public class Productimage {

	private int id;
	private Product product;
	private String type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Productimage [id=" + id + ", product=" + product + ", type=" + type + "]";
	}
	
	
}
