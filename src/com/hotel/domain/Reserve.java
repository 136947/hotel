package com.hotel.domain;

import java.util.Date;

/**
 * Reserve entity. @author MyEclipse Persistence Tools
 */

public class Reserve implements java.io.Serializable {

	// Fields

	private Integer id1;
	private Room room;
	private Customer customer;
	private Stuff stuff;
	private String tel;
	private Date bookIntoDate;
	private Date bookLeaveDate;
	private Integer bookNumber;

	// Constructors

	/** default constructor */
	public Reserve() {
	}

	/** full constructor */
	public Reserve(Room room, Customer customer, Stuff stuff, String tel,
			Date bookIntoDate, Date bookLeaveDate, Integer bookNumber) {
		this.room = room;
		this.customer = customer;
		this.stuff = stuff;
		this.tel = tel;
		this.bookIntoDate = bookIntoDate;
		this.bookLeaveDate = bookLeaveDate;
		this.bookNumber = bookNumber;
	}

	// Property accessors

	public Integer getId1() {
		return this.id1;
	}

	public void setId1(Integer id1) {
		this.id1 = id1;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Stuff getStuff() {
		return this.stuff;
	}

	public void setStuff(Stuff stuff) {
		this.stuff = stuff;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getBookIntoDate() {
		return this.bookIntoDate;
	}

	public void setBookIntoDate(Date bookIntoDate) {
		this.bookIntoDate = bookIntoDate;
	}

	public Date getBookLeaveDate() {
		return this.bookLeaveDate;
	}

	public void setBookLeaveDate(Date bookLeaveDate) {
		this.bookLeaveDate = bookLeaveDate;
	}

	public Integer getBookNumber() {
		return this.bookNumber;
	}

	public void setBookNumber(Integer bookNumber) {
		this.bookNumber = bookNumber;
	}

}