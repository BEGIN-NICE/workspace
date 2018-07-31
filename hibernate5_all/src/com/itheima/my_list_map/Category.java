package com.itheima.my_list_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fanxh
 *
 */
public class Category {
	private Integer id;
	private String name;
	private String author;
/*	private List<Book> books = new ArrayList<>(0);*/
	private Map<String,Book> bookMap = new HashMap<>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
/*	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}*/
	public Map<String, Book> getBookMap() {
		return bookMap;
	}
	public void setBookMap(Map<String, Book> bookMap) {
		this.bookMap = bookMap;
	}
	
	
}
