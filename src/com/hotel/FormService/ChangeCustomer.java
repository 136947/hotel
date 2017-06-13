package com.hotel.FormService;

import java.util.Date;

public class ChangeCustomer {
	private String name;
	private String tel;
	private String idcard;
	private String roomNumber;
	private String status;
	private Date liveIntoDate;
	private Date leaveDate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getLiveIntoDate() {
		return liveIntoDate;
	}
	public void setLiveIntoDate(Date liveIntoDate) {
		this.liveIntoDate = liveIntoDate;
	}
	public Date getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}
	
}
