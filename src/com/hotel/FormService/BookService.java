package com.hotel.FormService;

import java.util.Date;

public class BookService {
	private String stuffNumber;
	private String idcard;
	private String phone;
	private String roomNumber;
	private Date liveDate;
	private Date leaveDate;
	public String getStuffNumber() {
		return stuffNumber;
	}
	public void setStuffNumber(String stuffNumber) {
		this.stuffNumber = stuffNumber;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getLiveDate() {
		return liveDate;
	}
	public void setLiveDate(Date liveDate) {
		this.liveDate = liveDate;
	}
	public Date getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}
	
}
