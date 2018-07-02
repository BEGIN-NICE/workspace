package com.itheima.load.domain;

public class User {
	private Integer id;
	private String username;
	private String password;
	private String photouuid;
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
	public String getPhotouuid() {
		return photouuid;
	}
	public void setPhotouuid(String photouuid) {
		this.photouuid = photouuid;
	}
	
}
