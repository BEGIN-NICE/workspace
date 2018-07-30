package com.itheima.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name="t_customer")
//hql的命名
@NamedQuery(name="myHql",query="from Customer where id=:id")

//本地sql设置命名查询，要指定查询结果如何封装
@SqlResultSetMapping(name="mySetMapping",entities= {@EntityResult(entityClass=Customer.class,
fields= {@FieldResult(name="id",column="id"),@FieldResult(name="name",column="c_name")})})
@NamedNativeQuery(name="findCustomer",query="select * from t_customer",resultSetMapping="mySetMapping")
@Proxy(lazy=true)//默认是true，可以设置load的延迟加载
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="c_name")
	private String name;
	
	@OneToMany(targetEntity=Order.class,mappedBy="c")
	@Cascade(CascadeType.DELETE)
	//设置检索策略
	@Fetch(FetchMode.SUBSELECT)
	@LazyCollection(LazyCollectionOption.TRUE)
	private Set<Order> orders = new HashSet<>();	
	
	public Customer() {
		super();
	}

	public Customer(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}
	
}
