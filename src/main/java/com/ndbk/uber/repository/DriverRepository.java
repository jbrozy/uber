package com.ndbk.uber.repository;

import com.ndbk.uber.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends PagingAndSortingRepository<Client, Integer> {
}