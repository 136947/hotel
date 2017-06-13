package com.hotel.domain;

import java.util.Date;

/**
 * Live entity. @author MyEclipse Persistence Tools
 */

public class Live implements java.io.Serializable {

	// Fields

	private Integer id1;
	private Room room;
	private Customer customer;
	private String name;
	private Integer consume;
	private Date bookIntoDate;
	private Date bookLeaveDate;
	private Date leaveDate;
	private Integer security;
	private String tel;

	// Constructors

	/** default constructor */
	public Live() {
	}

	/** minimal constructor */
	public Live(Room room, Customer customer, Date bookIntoDate,
			Date bookLeaveDate, Integer security, String tel) {
		this.room = room;
		this.customer = customer;
		this.bookIntoDate = bookIntoDate;
		this.bookLeaveDate = bookLeaveDate;
		this.security = security;
		this.tel = tel;
	}

	/** full constructor */
	public Live(Room room, Customer customer, String name, Integer consume,
			Date bookIntoDate, Date bookLeaveDate, Date leaveDate,
			Integer security, String tel) {
		this.room = room;
		this.customer = customer;
		this.name = name;
		this.consume = consume;
		this.bookIntoDate = bookIntoDate;
		this.bookLeaveDate = bookLeaveDate;
		this.leaveDate = leaveDate;
		this.security = security;
		this.tel = tel;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getConsume() {
		return this.consume;
	}

	public void setConsume(Integer consume) {
		this.consume = consume;
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

	public Date getLeaveDate() {
		return this.leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	public Integer getSecurity() {
		return this.security;
	}

	public void setSecurity(Integer security) {
		this.security = security;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}