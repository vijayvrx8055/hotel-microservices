package com.vrx.hotelservice.controller;

import com.vrx.hotelservice.entity.Hotel;
import com.vrx.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel hotelResponse = hotelService.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelResponse);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId) {
        Hotel hotel = hotelService.get(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(hotel);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(hotels);
    }
}
