package com.itheima.all_1;

public class Customer {
	private Integer id;
	private String name;
	private String addr;
	
	
	
	public Customer(String name) {
		super();
		this.name = name;
	}
	public Customer(String name, String addr) {
		super();
		this.name = name;
		this.addr = addr;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", addr=" + addr + "]";
	}
	
}
