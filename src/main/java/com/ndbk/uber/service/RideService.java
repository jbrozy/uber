package com.ndbk.uber.service;

import com.ndbk.uber.dto.CreateRideRequest;
import com.ndbk.uber.helper.CoordinateHelper;
import com.ndbk.uber.model.Client;
import com.ndbk.uber.model.Driver;
import com.ndbk.uber.model.Ride;
import com.ndbk.uber.model.Waypoint;
import com.ndbk.uber.repository.ClientRepository;
import com.ndbk.uber.repository.DriverRepository;
import com.ndbk.uber.repository.RideRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RideService {
  final RideRepository _rideRepository;
  private final ClientRepository _clientRepository;
  private final DriverRepository _driverRepository;

  public RideService(RideRepository rideRepository, ClientRepository clientRepository, DriverRepository driverRepository) {
    this._rideRepository = rideRepository;
    this._clientRepository = clientRepository;
    this._driverRepository = driverRepository;
  }

  public Ride createRide(CreateRideRequest createRideRequest){
    Optional<Client> client = _clientRepository.findById(createRideRequest.clientId);
    if(client.isEmpty()){
      return null;
    }

    Optional<Driver> driver = _driverRepository.findById(createRideRequest.driverId);
    if(driver.isEmpty()){
      return null;
    }

    Ride newRide = new Ride();
    newRide.setClient(client.get());
    newRide.setDriver(driver.get());
    newRide.setRideDate(createRideRequest.rideDate);

    ArrayList<Waypoint> waypoints = new ArrayList<>();
    for(int waypoint_idx = 0; waypoint_idx < createRideRequest.waypoints.size(); ++waypoint_idx){
      Waypoint waypoint = createRideRequest.waypoints.get(waypoint_idx).convert();
      waypoint.setNumber(waypoint_idx + 1);
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

    return _rideRepository.save(newRide);
  }

  public Optional<Ride> getRide(int rideId){
    return _rideRepository.findById(rideId);
  }
}
