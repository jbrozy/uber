package com.ndbk.uber.repository;

import com.ndbk.uber.dto.RideStatistic;
import com.ndbk.uber.model.Client;
import com.ndbk.uber.model.Ride;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RideRepository extends CrudRepository<Ride, Integer> {
    @Query("SELECT new com.ndbk.uber.dto.RideStatistic(d.city, COUNT(r), SUM(r.price), AVG(w.latitude), AVG(w.longitude))" +
            "FROM com.ndbk.uber.model.Ride r " +
            "JOIN com.ndbk.uber.model.Driver d ON r.driver.id = d.id " +
            "JOIN com.ndbk.uber.model.Waypoint w ON r.id = w.rideId " +
            "WHERE SUBSTR(d.city, -13) = 'United States' " +
            "GROUP BY d.city")
    List<RideStatistic> getRideStatistic();
}