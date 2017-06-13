package com.hotel.FormService;

import java.util.Date;

public class BookSelectService {
	private Date bookLiveDate;
	private Date bookLeaveDate;
	private String roomType;
	private String floor;
	private String price;
	private String select;
	public Date getBookLiveDate() {
		return bookLiveDate;
	}
	public void setBookLiveDate(Date bookLiveDate) {
		this.bookLiveDate = bookLiveDate;
	}
	public Date getBookLeaveDate() {
		return bookLeaveDate;
	}
	public void setBookLeaveDate(Date bookLeaveDate) {
		this.bookLeaveDate = bookLeaveDate;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSelect() {
		return select;
	}
	public void setSelect(String select) {
		this.select = select;
	}
	
}
