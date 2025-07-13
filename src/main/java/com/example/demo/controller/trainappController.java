package com.example.demo.controller;

import com.example.demo.model.bookingRequest;
import com.example.demo.model.trainList;
import com.example.demo.service.trainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController

public class trainappController {
    @Autowired
    trainService service ;
    @GetMapping("/train/db")
    public List<trainList> alltrains(){
        return service.allTrains();
    }
    @PostMapping("/trains")
    public List<trainList> filteredtrains(@RequestBody trainList list){
        return service.filterTrains(list.getSource(),list.getDestination(),list.getDateOfJourney());
    }
    @GetMapping("/train/{trainNumber}")
    public trainList traindetails(@PathVariable int trainNumber){
        return service.trainDetails(trainNumber);
    }
    @PostMapping("/trains/{trainNumber}")
    public trainList trainbooking(@PathVariable int trainNumber, @RequestBody bookingRequest request){
        int seat = request.getNoOfSeats();
        System.out.println(seat);
        return service.trainBooking(trainNumber, request.getNoOfSeats(), request.getClassType());
    }
}
