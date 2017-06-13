package com.hotel.domain;

import java.util.Date;

/**
 * Cost entity. @author MyEclipse Persistence Tools
 */

public class Cost implements java.io.Serializable {

	// Fields

	private Integer id;
	private String roomTypeName;
	private Integer money;
	private Date date;

	// Constructors

	/** default constructor */
	public Cost() {
	}

	/** full constructor */
	public Cost(String roomTypeName, Integer money, Date date) {
		this.roomTypeName = roomTypeName;
		this.money = money;
		this.date = date;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoomTypeName() {
		return this.roomTypeName;
	}

	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}

	public Integer getMoney() {
		return this.money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}