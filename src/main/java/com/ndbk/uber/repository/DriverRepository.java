package com.ndbk.uber.repository;

import com.ndbk.uber.model.Client;
import com.ndbk.uber.model.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends CrudRepository<Driver, Integer>, PagingAndSortingRepository<Driver, Integer> {
    Page<Driver> findByLicensePlateContains(String licensePlate, Pageable pageable);
    Page<Driver> findByNameContains(String licensePlate, Pageable pageable);
    Page<Driver> findByLicensePlateContainsAndNameContains(String licensePlate, String name, Pageable pageable);
}