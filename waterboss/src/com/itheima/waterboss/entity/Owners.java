package com.itheima.waterboss.entity;

import java.util.Date;

public class Owners {
	private Long id;
	private String name;
	private Long address;
	private String housenumber;
	private String watermeter;
	private Date adddate;
	private Long ownertypeid;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAddress() {
		return address;
	}
	public void setAddress(Long address) {
		this.address = address;
	}
	public String getHousenumber() {
		return housenumber;
	}
	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}
	public String getWatermeter() {
		return watermeter;
	}
	public void setWatermeter(String watermeter) {
		this.watermeter = watermeter;
	}
	public Date getAdddate() {
		return adddate;
	}
	public void setAdddate(Date adddate) {
		this.adddate = adddate;
	}
	public Long getOwnertypeid() {
		return ownertypeid;
	}
	public void setOwnertypeid(Long ownertypeid) {
		this.ownertypeid = ownertypeid;
	}
	
}
