package com.ndbk.uber.controller;

import com.ndbk.uber.dto.CreateRideRequest;
import com.ndbk.uber.dto.RideStatistic;
import com.ndbk.uber.model.Ride;
import com.ndbk.uber.service.RideService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping(path="/stats")
public class StatisticsController {
  private final RideService _rideService;

  public StatisticsController(RideService rideService){
    _rideService = rideService;
  }

  @GetMapping
  public ResponseEntity<List<RideStatistic>> GetRideStatistics(){
    var stats = _rideService.getRideStatistics();
    return ResponseEntity.ok(stats);
  }
}