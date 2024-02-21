package com.softel.rate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="micro_ratings")
public class Rate {

	@Id
	@Column(name="Rating ID")
	private String ratingId;
	
	@Column(name="User ID")
	private String userId;
	
	@Column(name="Hotel ID")
	private String hotelId;
	
	@Column(name="Rating")
	private int rating;
	
	@Column(name="Feedback")
	private String feedback;

	public Rate() {
		super();
	}

	public String getRatingId() {
		return ratingId;
	}

	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
}
