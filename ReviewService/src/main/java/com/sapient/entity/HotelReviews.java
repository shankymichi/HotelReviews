package com.sapient.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
//@Setter @Getter @NoArgsConstructor @AllArgsConstructor
@Table(name = "hotel_reviews")
@IdClass(RelationshipId.class)
public class HotelReviews implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int hotelId ;
	
	@Id
	//@Column
	private int userId;
	
	@Column
	private String reviews;

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

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	public HotelReviews() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HotelReviews(int hotelId, int userId, String reviews) {
		super();
		this.hotelId = hotelId;
		this.userId = userId;
		this.reviews = reviews;
	}
	

}
