package com.vrx.user.service.client;

import com.vrx.user.service.entity.Rating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@Service
public class RatingServiceClient {

    @Autowired
    private RestTemplate restTemplate;

    private final Logger logger = LoggerFactory.getLogger(RatingServiceClient.class);

    String URI = "http://RATING-SERVICE/ratings/users/";

    public List<Rating> getRatingForUser(String userId) {
        List<Rating> forObject = Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(URI + userId, Rating[].class)));
        logger.info("{}", forObject);
        logger.info("{}", forObject.toString());
        return (List<Rating>) forObject;
    }
}
