package com.hotel.FormService;

import java.util.Date;
import javax.annotation.Resource;
public class LiveSelectService {
   private String roomPrice1;
   private String roomPrice2;
   private String roomTypeId;
   private String floor;
   private String roomNumber;

public String getRoomPrice1() {
	return roomPrice1;
}
public void setRoomPrice1(String roomPrice1) {
	this.roomPrice1 = roomPrice1;
}
public String getRoomPrice2() {
	return roomPrice2;
}
public void setRoomPrice2(String roomPrice2) {
	this.roomPrice2 = roomPrice2;
}

public String getFloor() {
	return floor;
}
public void setFloor(String floor) {
	this.floor = floor;
}
public String getRoomTypeId() {
	return roomTypeId;
}
public void setRoomTypeId(String roomTypeId) {
	this.roomTypeId = roomTypeId;
}
public String getRoomNumber() {
	return roomNumber;
}
public void setRoomNumber(String roomNumber) {
	this.roomNumber = roomNumber;
}
  
}
