package com.itheima.annotation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PO类中的所有属性如果不写注解，也会在表中生成对应的列，列名和属性名一样
 * @author fanxh
 *
 */


@Entity
@Table(name="t_book")
public class Book {
	@Id
	//@GeneratedValue  //默认采用 native
	@GeneratedValue(strategy = GenerationType.IDENTITY)//主键生成策略
	private Integer id;
	
	@Column(name="b_name",length=30,nullable=true)
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)//用来定义日期类型
	private Date publicationDate;//出版日期
	
	private Double price;//价格没有添加注解，也会自动生成在表中
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
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
