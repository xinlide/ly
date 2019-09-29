package com.entor.entity;

public class Productimage {

	private int id;
	private int pid;
	private String type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Productimage [id=" + id + ", pid=" + pid + ", type=" + type + "]";
	}
	
	
	
}
