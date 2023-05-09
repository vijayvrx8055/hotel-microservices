package com.vrx.user.service.services;

import com.vrx.user.service.client.HotelServiceClient;
import com.vrx.user.service.client.RatingServiceClient;
import com.vrx.user.service.entity.Hotel;
import com.vrx.user.service.entity.Rating;
import com.vrx.user.service.entity.User;
import com.vrx.user.service.exception.UserNotFoundException;
import com.vrx.user.service.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RatingServiceClient ratingServiceClient;

    @Autowired
    private HotelServiceClient hotelServiceClient;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        //fetch rating of the above user from rating-service
        List<Rating> ratingsResponse = ratingServiceClient.getRatingForUser(user.getUserId());
        logger.info("Ratings:{}", ratingsResponse);
        //fetch hotel details using hotelId
        List<Rating> ratings = ratingsResponse.stream().map(rating -> {
            Hotel hotelResponse = hotelServiceClient.getHotelByHotelId(rating.getHotelId());
            rating.setHotel(hotelResponse);
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratings);
        return user;
    }
}
