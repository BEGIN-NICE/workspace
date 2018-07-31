package com.itheima.all_6_criteria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="t_order")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="o_money")
	private double money;
	@Column(name="o_receiverInfo")
	private String receiverInfo;
	@ManyToOne(targetEntity=Customer.class)
	@JoinColumn(name="o_customer_id")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Customer c;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getReceiverInfo() {
		return receiverInfo;
	}
	public void setReceiverInfo(String receiverInfo) {
		this.receiverInfo = receiverInfo;
	}
	public Customer getC() {
		return c;
	}
	public void setC(Customer c) {
		this.c = c;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", money=" + money + ", receiverInfo=" + receiverInfo + "]";
	}
	
}
