package com.itheima.sessionlistener;

import java.io.Serializable;

public class JavaBean2 extends MyHttpSessionActivationListener implements Serializable {
	private Integer id;
	private String name;
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
	
}
