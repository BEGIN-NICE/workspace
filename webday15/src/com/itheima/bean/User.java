package com.itheima.bean;

public class User {
	private Integer id;
	private String username;
	private String password;
	private String email;
	private String name;
	private String sex;
	private String telephone;
	
	public User(String username, String password, String email, String name, String sex, String telephone) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.sex = sex;
		this.telephone = telephone;
	}
	public User(Integer id, String username, String password, String email, String name, String sex, String telephone) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.sex = sex;
		this.telephone = telephone;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String gettelephone() {
		return telephone;
	}
	public void settelephone(String telephone) {
		this.telephone = telephone;
	}
	
}
