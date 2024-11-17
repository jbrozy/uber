package com.ndbk.uber.service;

import com.ndbk.uber.dto.CreateRideRequest;
import com.ndbk.uber.dto.RideStatistic;
import com.ndbk.uber.helper.CoordinateHelper;
import com.ndbk.uber.model.Client;
import com.ndbk.uber.model.Driver;
import com.ndbk.uber.model.Ride;
import com.ndbk.uber.model.Waypoint;
import com.ndbk.uber.repository.ClientRepository;
import com.ndbk.uber.repository.DriverRepository;
import com.ndbk.uber.repository.RideRepository;
import com.ndbk.uber.repository.WaypointRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RideService {
    final RideRepository _rideRepository;
    private final ClientRepository _clientRepository;
    private final DriverRepository _driverRepository;
    private final WaypointRepository _waypointRepository;

    public RideService(RideRepository rideRepository,
            ClientRepository clientRepository,
            DriverRepository driverRepository, WaypointRepository waypointRepository)
    {
        this._rideRepository = rideRepository;
        this._clientRepository = clientRepository;
        this._driverRepository = driverRepository;
        this._waypointRepository = waypointRepository;
    }

    @Transactional()
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


        double distance = 0;
        var waypoints = createRideRequest.waypoints;
        var newWaypoints = new ArrayList<Waypoint>();
        for (int i = 0; i < waypoints.size() - 1; i++) {
            double lat1 = waypoints.get(i).latitude;
            double lon1 = waypoints.get(i).longitude;
            double lat2 = waypoints.get(i + 1).latitude;
            double lon2 = waypoints.get(i + 1).longitude;

            distance += CoordinateHelper.haversine(lat1, lon1, lat2, lon2);
        }

        newRide.setDistance((int)distance);
        Ride savedRide = _rideRepository.save(newRide);

        for(int i = 0; i < waypoints.size(); i++){
            var wpRequest = waypoints.get(i) ;
            Waypoint wp = new Waypoint();
            wp.setRideId(savedRide.getId());
            wp.setLatitude(wpRequest.latitude);
            wp.setLongitude(wpRequest.longitude);
            wp.setNumber(i + 1);
            newWaypoints.add(wp);
        }

        _waypointRepository.saveAll(newWaypoints);

        savedRide.setWaypoints(newWaypoints);

        return savedRide;
    }

    public Optional<Ride> getRide(int rideId){
        return _rideRepository.findById(rideId);
    }

    public List<RideStatistic> getRideStatistics(){
        return _rideRepository.getRideStatistic();
    }
}
