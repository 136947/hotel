package com.hotel.FormService;

import java.util.Date;

public class GsService {
    private String roomNum;
    private String name;
    private String tel;
    private String idCard;
    private Date bookIntoDate;
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
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
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public Date getBookIntoDate() {
		return bookIntoDate;
	}
	public void setBookIntoDate(Date bookIntoDate) {
		this.bookIntoDate = bookIntoDate;
	}
    
}
