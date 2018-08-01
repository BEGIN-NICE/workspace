package com.itheima.domain;

import java.util.Date;

public class Book {
	private int id;
	private String name;
	private double price;
	private String author;
	private Date pubDate;
	private Catregory catregory;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Book(String name, String author) {
		super();
		this.name = name;
		this.author = author;
	}


	public Catregory getCatregory() {
		return catregory;
	}
	public void setCatregory(Catregory catregory) {
		this.catregory = catregory;
	}
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(java.util.Date date) {
		this.pubDate = date;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price
				+ ", author=" + author + ", pubDate=" + pubDate + "]";
	}
	
}
