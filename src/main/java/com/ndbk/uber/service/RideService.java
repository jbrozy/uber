package com.ndbk.uber.service;

import com.ndbk.uber.dto.CreateRideRequest;
import com.ndbk.uber.dto.RideStatistic;
import com.ndbk.uber.helper.CoordinateHelper;
import com.ndbk.uber.model.Ride;
import com.ndbk.uber.model.Waypoint;
import com.ndbk.uber.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class RideService {

  final RideRepository _rideRepository;

  public RideService(RideRepository rideRepository) {
    _rideRepository = rideRepository;
  }

  public Ride createRide(CreateRideRequest createRideRequest){
    Ride newRide = new Ride();
    newRide.setRideDate(createRideRequest.rideDate);

    Waypoint from = createRideRequest.waypoints.get(0).convert();
    Waypoint to = createRideRequest.waypoints.get(1).convert();

    int distance = CoordinateHelper.distance(from, to);
    newRide.setDistance(distance);

    newRide.addWaypoint(from);
    newRide.addWaypoint(to);

    return newRide;
  }

  @Query(value = "SELECT id FROM Client")
  public RideStatistic getRideStatistic(){
    return new RideStatistic();
  }
}
