package com.hotel.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Room entity. @author MyEclipse Persistence Tools
 */

public class Room implements java.io.Serializable {

	// Fields

	private Integer roomNumber;
	private Roomtype roomtype;
	private Integer floor;
	private String status;
	private Set lives = new HashSet(0);
	private Set reserves = new HashSet(0);

	// Constructors

	/** default constructor */
	public Room() {
	}

	/** minimal constructor */
	public Room(Integer roomNumber, Roomtype roomtype, Integer floor,
			String status) {
		this.roomNumber = roomNumber;
		this.roomtype = roomtype;
		this.floor = floor;
		this.status = status;
	}

	/** full constructor */
	public Room(Integer roomNumber, Roomtype roomtype, Integer floor,
			String status, Set lives, Set reserves) {
		this.roomNumber = roomNumber;
		this.roomtype = roomtype;
		this.floor = floor;
		this.status = status;
		this.lives = lives;
		this.reserves = reserves;
	}

	// Property accessors

	public Integer getRoomNumber() {
		return this.roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Roomtype getRoomtype() {
		return this.roomtype;
	}

	public void setRoomtype(Roomtype roomtype) {
		this.roomtype = roomtype;
	}

	public Integer getFloor() {
		return this.floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set getLives() {
		return this.lives;
	}

	public void setLives(Set lives) {
		this.lives = lives;
	}

	public Set getReserves() {
		return this.reserves;
	}

	public void setReserves(Set reserves) {
		this.reserves = reserves;
	}

}