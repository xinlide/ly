package com.entor.entity;

import java.sql.Date;

public class Review {

	private int id;
	private String content;
	private User user;
	private int pid;
	private Product product;
	private Date createDate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", content=" + content + ", user=" + user + ", pid=" + pid + ", product=" + product
				+ ", createDate=" + createDate + "]";
	}
	
}
