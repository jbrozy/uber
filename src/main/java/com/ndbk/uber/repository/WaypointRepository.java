package com.ndbk.uber.repository;

import com.ndbk.uber.model.Driver;
import com.ndbk.uber.model.Waypoint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaypointRepository extends CrudRepository<Waypoint, Integer> {
}