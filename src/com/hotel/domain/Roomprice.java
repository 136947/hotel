package com.hotel.domain;

import java.util.Date;

/**
 * Roomprice entity. @author MyEclipse Persistence Tools
 */

public class Roomprice implements java.io.Serializable {

	// Fields

	private Integer id1;
	private Roomtype roomtype;
	private Integer roomPrice;
	private Date priceDate;

	// Constructors

	/** default constructor */
	public Roomprice() {
	}

	/** full constructor */
	public Roomprice(Roomtype roomtype, Integer roomPrice, Date priceDate) {
		this.roomtype = roomtype;
		this.roomPrice = roomPrice;
		this.priceDate = priceDate;
	}

	// Property accessors

	public Integer getId1() {
		return this.id1;
	}

	public void setId1(Integer id1) {
		this.id1 = id1;
	}

	public Roomtype getRoomtype() {
		return this.roomtype;
	}

	public void setRoomtype(Roomtype roomtype) {
		this.roomtype = roomtype;
	}

	public Integer getRoomPrice() {
		return this.roomPrice;
	}

	public void setRoomPrice(Integer roomPrice) {
		this.roomPrice = roomPrice;
	}

	public Date getPriceDate() {
		return this.priceDate;
	}

	public void setPriceDate(Date priceDate) {
		this.priceDate = priceDate;
	}

}