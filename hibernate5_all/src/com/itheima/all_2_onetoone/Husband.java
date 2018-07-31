package com.itheima.all_2_onetoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="t_husband")
public class Husband {
	
	@Id
	@GenericGenerator(name="myForeignKey",strategy="foreign",parameters= {@Parameter(name="property",value="wife")})
	@GeneratedValue(generator="myForeignKey")
	private String id;
	private String name;
	
	@OneToOne(mappedBy="husband")
	@PrimaryKeyJoinColumn
	private Wife wife;
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
	public Wife getWife() {
		return wife;
	}
	public void setWife(Wife wife) {
		this.wife = wife;
	}
	
	
}
