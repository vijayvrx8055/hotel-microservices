package com.vrx.ratingservice.service;

import com.vrx.ratingservice.entity.Rating;

import java.util.List;

public interface RatingService {

    Rating create(Rating rating);

    List<Rating> getRatingsByUserId(String userId);

    List<Rating> getAllRatings();

    List<Rating> getRatingsByHotelId(String hotelId);
}
