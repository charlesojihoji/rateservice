package com.softel.rate.controllers;

import java.util.List;

import com.softel.rate.entity.RateServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softel.rate.entity.Rate;
import com.softel.rate.service.RateService;

@RestController
@RequestMapping(value="/ratings",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class RateController {

	@Autowired
	private RateService rateService;
	
	@PostMapping
	public ResponseEntity<Rate> create(@RequestBody Rate rate) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(rateService.create(rate));
	}
	
	@GetMapping
	public ResponseEntity<List<Rate>> getAll(){
		
		return ResponseEntity.status(HttpStatus.OK).body(rateService.getAllRatings());
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rate>> getRatingsByUserId(@PathVariable String userId){
		
		return ResponseEntity.status(HttpStatus.OK).body(rateService.getRatingsByUserId(userId));
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<RateServiceResponse>> getRatingsByHotelId(@PathVariable String hotelId){
		
		return ResponseEntity.status(HttpStatus.OK).body(rateService.getRatingsByHotelId(hotelId));
	}
	@GetMapping("/hotels/ratingNo/{ratingNo}")
	public ResponseEntity<List<RateServiceResponse>> getListOfHotelIdsBasedOnrating(@PathVariable String ratingNo){

		return ResponseEntity.status(HttpStatus.OK).body(rateService.getListOfHotelIdsBasedOnrating(ratingNo));
	}
	
	@PutMapping("/update/{ratingId}")
	public ResponseEntity<Rate> updateRate(@RequestBody Rate newRate, @PathVariable String ratingId){
		
		return ResponseEntity.status(HttpStatus.OK).body(rateService.update(newRate, ratingId));
	}
	
	@DeleteMapping("/delete/{ratingId}")
	public ResponseEntity<String> deleteRate(@PathVariable String ratingId){
		
		return ResponseEntity.status(HttpStatus.OK).body(rateService.delete(ratingId));
	}
}
