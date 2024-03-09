package com.softel.rate.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softel.rate.entity.Rate;
import com.softel.rate.repository.RateRepository;

@Service
public class RateServiceImpl implements RateService {

	@Autowired
	private RateRepository rateRepository;

	@Override
	public Rate create(Rate rate) {
		
		rate.setRatingId(UUID.randomUUID().toString());
		return rateRepository.save(rate);
	}

	@Override
	public List<Rate> getAllRatings() {

		return rateRepository.findAll();
	}

	@Override
	public List<Rate> getRatingsByUserId(String userId) {

		return rateRepository.findByUserId(userId);
	}

	@Override
	public List<Rate> getRatingsByHotelId(String hotelId) {

		return rateRepository.findByHotelId(hotelId);
	}

	@Override
	public Rate update(Rate newRate, String ratingId) {

		Rate rate = rateRepository.findById(ratingId).orElseThrow(() -> new RuntimeException("Could not find the rating"));
		
		rate.setUserId(newRate.getUserId());
		rate.setHotelId(newRate.getHotelId());
		rate.setRating(newRate.getRating());
		rate.setFeedback(newRate.getFeedback());
		
		return rateRepository.save(rate);
	}

	@Override
	public String delete(String ratingId) {

		rateRepository.deleteById(ratingId);
		
		return "The Rate has been deleted successfully.";
	}
	

}
