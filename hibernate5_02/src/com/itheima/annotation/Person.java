package com.itheima.annotation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * 采用UUID的主键生成策略
 * @author fanxh
 */

@Entity
@Table(name="t_person")
public class Person {
	@Id
	@GenericGenerator(name="myuuid",strategy="uuid")//自定义主键生成策略，然后引入
	@GeneratedValue(generator="myuuid")
	private String id;
	
	private String name;
	
	@Transient
	private String  msg; //现在这个属性不想在表中生成

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
