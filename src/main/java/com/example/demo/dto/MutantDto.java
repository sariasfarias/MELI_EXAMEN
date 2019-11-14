package com.example.demo.dto;

import java.io.Serializable;
import java.sql.Date;


public class MutantDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private String[] adn;
	private Date inserted;

	public MutantDto() {
		super();
		Date date = new Date(System.currentTimeMillis());
		this.inserted = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String[] getAdn() {
		return adn;
	}

	public void setAdn(String[] adn) {
		this.adn = adn;
	}

	public Date getInserted() {
		return inserted;
	}

	public void setInserted(Date inserted) {
		this.inserted = inserted;
	}
}
