package com.entor.entity;

public class Orderitem {

	private int id;
	private Product product;
	private Order_ order;
	private User user;
	private int number;
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
	public Order_ getOrder() {
		return order;
	}
	public void setOrder(Order_ order) {
		this.order = order;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Orderitem [id=" + id + ", product=" + product + ", order=" + order + ", user=" + user + ", number="
				+ number + "]";
	}
	
	
}
