package com.vrx.ratingservice.repository;

import com.vrx.ratingservice.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {

    //custom finder Method
    List<Rating> findByUserId(String userId);

    List<Rating> findByHotelId(String hotelId);
}
