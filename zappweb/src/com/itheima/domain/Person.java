package com.itheima.domain;

import java.io.Serializable;

public class Person implements Serializable{
	private Integer age;
	private String username;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(Integer age, String username) {
		super();
		this.age = age;
		this.username = username;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", username=" + username + "]";
	}
	
	
}
