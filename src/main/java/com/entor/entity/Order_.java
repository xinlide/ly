package com.entor.entity;

import java.sql.Date;

public class Order_ {
	private int id;
	private String orderCode;
	private String address;
	private String post;
	private String receive;
	private String mobile;
	private String userMessage;
	private Date createDate;
	private Date payDate;
	private Date deliveryDate;
	private Date comfirmDate;
	private Orderitem orderitem;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getReceive() {
		return receive;
	}
	public void setReceive(String receive) {
		this.receive = receive;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUserMessage() {
		return userMessage;
	}
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Date getComfirmDate() {
		return comfirmDate;
	}
	public void setComfirmDate(Date comfirmDate) {
		this.comfirmDate = comfirmDate;
	}
	public Orderitem getOrderitem() {
		return orderitem;
	}
	public void setOrderitem(Orderitem orderitem) {
		this.orderitem = orderitem;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order_ [id=" + id + ", orderCode=" + orderCode + ", address=" + address + ", post=" + post
				+ ", receive=" + receive + ", mobile=" + mobile + ", userMessage=" + userMessage + ", createDate="
				+ createDate + ", payDate=" + payDate + ", deliveryDate=" + deliveryDate + ", comfirmDate="
				+ comfirmDate + ", status=" + status + "]";
	}
	
	
}
