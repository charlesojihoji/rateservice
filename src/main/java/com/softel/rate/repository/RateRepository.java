package com.softel.rate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softel.rate.entity.Rate;

@Repository
public interface RateRepository extends JpaRepository<Rate, String> {

	public List<Rate> findByUserId(String userId);
	
	public List<Rate> findByHotelId(String hotelId);
}
