package com.hotel.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Roomtype entity. @author MyEclipse Persistence Tools
 */

public class Roomtype implements java.io.Serializable {

	// Fields

	private Integer roomTypeId;
	private String roomTypeName;
	private String roomIntroduce;
	private Integer allNumber;
	private Set roomprices = new HashSet(0);
	private Set rooms = new HashSet(0);

	// Constructors

	/** default constructor */
	public Roomtype() {
	}

	/** minimal constructor */
	public Roomtype(Integer roomTypeId, String roomTypeName,
			String roomIntroduce, Integer allNumber) {
		this.roomTypeId = roomTypeId;
		this.roomTypeName = roomTypeName;
		this.roomIntroduce = roomIntroduce;
		this.allNumber = allNumber;
	}

	/** full constructor */
	public Roomtype(Integer roomTypeId, String roomTypeName,
			String roomIntroduce, Integer allNumber, Set roomprices, Set rooms) {
		this.roomTypeId = roomTypeId;
		this.roomTypeName = roomTypeName;
		this.roomIntroduce = roomIntroduce;
		this.allNumber = allNumber;
		this.roomprices = roomprices;
		this.rooms = rooms;
	}

	// Property accessors

	public Integer getRoomTypeId() {
		return this.roomTypeId;
	}

	public void setRoomTypeId(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String getRoomTypeName() {
		return this.roomTypeName;
	}

	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}

	public String getRoomIntroduce() {
		return this.roomIntroduce;
	}

	public void setRoomIntroduce(String roomIntroduce) {
		this.roomIntroduce = roomIntroduce;
	}

	public Integer getAllNumber() {
		return this.allNumber;
	}

	public void setAllNumber(Integer allNumber) {
		this.allNumber = allNumber;
	}

	public Set getRoomprices() {
		return this.roomprices;
	}

	public void setRoomprices(Set roomprices) {
		this.roomprices = roomprices;
	}

	public Set getRooms() {
		return this.rooms;
	}

	public void setRooms(Set rooms) {
		this.rooms = rooms;
	}

}