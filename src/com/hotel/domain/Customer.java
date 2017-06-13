package com.hotel.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Customer entity. @author MyEclipse Persistence Tools
 */

public class Customer implements java.io.Serializable {

	// Fields

	private String idCard;
	private String name;
	private String tel;
	private Set lives = new HashSet(0);
	private Set reserves = new HashSet(0);

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** minimal constructor */
	public Customer(String idCard, String tel) {
		this.idCard = idCard;
		this.tel = tel;
	}

	/** full constructor */
	public Customer(String idCard, String name, String tel, Set lives,
			Set reserves) {
		this.idCard = idCard;
		this.name = name;
		this.tel = tel;
		this.lives = lives;
		this.reserves = reserves;
	}

	// Property accessors

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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