package com.vrx.user.service.client;

import com.vrx.user.service.entity.Hotel;
import com.vrx.user.service.external.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HotelServiceClient {

    @Autowired
    private RestTemplate restTemplate;

    private final Logger logger = LoggerFactory.getLogger(HotelServiceClient.class);

    @Autowired
    private HotelService hotelService;

//    String URL = "http://HOTEL-SERVICE/hotels/";

//    public HotelServiceClient(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }

    public Hotel getHotelByHotelId(String hotelId) {
//        ResponseEntity<Hotel> forEntity = restTemplate.getForEntity(URL + hotelId, Hotel.class);
//        Hotel hotel = forEntity.getBody();
        Hotel hotel = hotelService.getHotel(hotelId);
//        logger.info("response status code: {}", forEntity.getStatusCode());
        return hotel;
    }
}
