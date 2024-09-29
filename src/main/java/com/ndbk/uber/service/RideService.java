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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

@Service
public class RideService {
  final RideRepository _rideRepository;

  public RideService(RideRepository rideRepository) {
    _rideRepository = rideRepository;
  }

  public Ride createRide(CreateRideRequest createRideRequest){
    Ride newRide = new Ride();
    newRide.setRideDate(createRideRequest.rideDate);

    ArrayList<Waypoint> waypoints = new ArrayList<>();
    for(int waypoint_idx = 0; waypoint_idx < createRideRequest.waypoints.size(); ++waypoint_idx){
      Waypoint waypoint = createRideRequest.waypoints.get(waypoint_idx).convert();
      waypoints.add(waypoint);
      newRide.addWaypoint(waypoint);
    }

    double distance = 0;
    for (int i = 0; i < newRide.getWaypoints().size() - 1; i++) {
      double lat1 = waypoints.get(i).getLatitude();
      double lon1 = waypoints.get(i).getLongitude();
      double lat2 = waypoints.get(i + 1).getLatitude();
      double lon2 = waypoints.get(i + 1).getLongitude();

      distance += CoordinateHelper.haversine(lat1, lon1, lat2, lon2);
    }

    newRide.setDistance((int)(distance));

    return newRide;
  }

  public Optional<Ride> getRide(int rideId){
    return _rideRepository.findById(rideId);
  }
}
