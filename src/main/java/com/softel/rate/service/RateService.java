package com.softel.rate.service;

import java.util.List;

import com.softel.rate.entity.Rate;

public interface RateService {

	public Rate create(Rate rate);
	public List<Rate> getAllRatings();
	public List<Rate> getRatingsByUserId(String userId);
	public List<Rate> getRatingsByHotelId(String hotelId);
	public Rate update(Rate rate, String ratingId);
	public String delete(String ratingId);
}
