package com.itheima.domain;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonFilter;

//设置通过Jackson生成json不包含的字段
//@JsonIgnoreProperties(value= {"id","relaceday"})
@JsonFilter(value="productFilter")//进行硬编码包含指定属性是要用到
public class Product {
	//不包含该属性	
	@JsonIgnore
	private Integer id;
	private String name;
	private Double price;
	private Date relaceday;
	
	public Date getRelaceday() {
		return relaceday;
	}
	public void setRelaceday(Date relaceday) {
		this.relaceday = relaceday;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	 
	
}
