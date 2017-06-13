package com.hotel.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Stuff entity. @author MyEclipse Persistence Tools
 */

public class Stuff implements java.io.Serializable {

	// Fields

	private Integer stuffId;
	private String name;
	private String psw;
	private String position;
	private Set reserves = new HashSet(0);

	// Constructors

	/** default constructor */
	public Stuff() {
	}

	/** minimal constructor */
	public Stuff(Integer stuffId, String name, String psw, String position) {
		this.stuffId = stuffId;
		this.name = name;
		this.psw = psw;
		this.position = position;
	}

	/** full constructor */
	public Stuff(Integer stuffId, String name, String psw, String position,
			Set reserves) {
		this.stuffId = stuffId;
		this.name = name;
		this.psw = psw;
		this.position = position;
		this.reserves = reserves;
	}

	// Property accessors

	public Integer getStuffId() {
		return this.stuffId;
	}

	public void setStuffId(Integer stuffId) {
		this.stuffId = stuffId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPsw() {
		return this.psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Set getReserves() {
		return this.reserves;
	}

	public void setReserves(Set reserves) {
		this.reserves = reserves;
	}

}