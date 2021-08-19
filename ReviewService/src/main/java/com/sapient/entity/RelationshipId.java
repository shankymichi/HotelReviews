package com.sapient.entity;

import java.io.Serializable;



public class RelationshipId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int hotelId ;
	private int userId;


	public int getHotelId() {
		return hotelId;
	}


	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public RelationshipId() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RelationshipId(int hotelId, int userId) {
		super();
		this.hotelId = hotelId;
		this.userId = userId;
	}
	
	

}
