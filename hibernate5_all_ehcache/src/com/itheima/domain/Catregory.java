package com.itheima.domain;

import java.util.HashSet;
import java.util.Set;

public class Catregory {
	private int id;
	private String name;
	private Integer verson;
	private Set<Book> books = new HashSet<Book>(0); 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	
	public Integer getVerson() {
		return verson;
	}
	public void setVerson(Integer verson) {
		this.verson = verson;
	}
	@Override
	public String toString() {
		return "Catregory [id=" + id + ", name=" + name + "]";
	}
	
}
