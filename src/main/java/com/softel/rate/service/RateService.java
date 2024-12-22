package com.softel.rate.service;

import java.util.List;

import com.softel.rate.entity.Rate;
import com.softel.rate.entity.RateServiceResponse;

public interface RateService {

	public Rate create(Rate rate);
	public List<Rate> getAllRatings();
	public List<Rate> getRatingsByUserId(String userId);
	public List<RateServiceResponse> getRatingsByHotelId(String hotelId);
	public Rate update(Rate rate, String ratingId);
	public String delete(String ratingId);

	public List<RateServiceResponse> getListOfHotelIdsBasedOnrating(String hotelId);
}
