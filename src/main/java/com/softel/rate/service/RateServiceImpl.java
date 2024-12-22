package com.softel.rate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.softel.rate.entity.Rate;
import com.softel.rate.entity.RateServiceResponse;
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
	public List<RateServiceResponse> getRatingsByHotelId(String hotelId) {
		
		List<Rate> listOfRatings = rateRepository.findByHotelId(hotelId);

		List<RateServiceResponse> listOfRateServiceResponse = new ArrayList<RateServiceResponse>();
				
		for(Rate rate: listOfRatings) {
			RateServiceResponse rateObj = new RateServiceResponse();
			rateObj.setFeedback(rate.getFeedback());
			rateObj.setHotelId(rate.getHotelId());
			rateObj.setRating(rate.getRating());
			rateObj.setRatingId(rate.getRatingId());
			rateObj.setUserId(rate.getUserId());
			
			listOfRateServiceResponse.add(rateObj);
		}
		
		return listOfRateServiceResponse;
	}
	@Override
	public List<RateServiceResponse> getListOfHotelIdsBasedOnrating(String ratingNo) {

		List<Rate> listOfRatings = rateRepository.findByRating(Integer.parseInt(ratingNo));

		List<RateServiceResponse> listOfRateServiceResponse = new ArrayList<RateServiceResponse>();

		for(Rate rate: listOfRatings) {
			RateServiceResponse rateObj = new RateServiceResponse();
			rateObj.setFeedback(rate.getFeedback());
			rateObj.setHotelId(rate.getHotelId());
			rateObj.setRating(rate.getRating());
			rateObj.setRatingId(rate.getRatingId());
			rateObj.setUserId(rate.getUserId());

			listOfRateServiceResponse.add(rateObj);
		}

		return listOfRateServiceResponse;
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
