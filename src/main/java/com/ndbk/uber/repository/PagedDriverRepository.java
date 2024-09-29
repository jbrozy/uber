package com.ndbk.uber.repository;

import com.ndbk.uber.model.Driver;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagedDriverRepository extends CrudRepository<Driver, Integer>, PagingAndSortingRepository<Driver, Integer> {
}