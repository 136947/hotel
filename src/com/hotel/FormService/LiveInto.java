package com.hotel.FormService;

import java.util.Date;

public class LiveInto {
    private String roomNumber;
    private String idCard;
    private String name;
    private Date liveDate;
    private Date wileaveDate;
    private String security;
	private String tel;
    public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getLiveDate() {
		return liveDate;
	}
	public void setLiveDate(Date liveDate) {
		this.liveDate = liveDate;
	}
	public Date getWileaveDate() {
		return wileaveDate;
	}
	public void setWileaveDate(Date wileaveDate) {
		this.wileaveDate = wileaveDate;
	}
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}
}
