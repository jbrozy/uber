package com.ndbk.uber.service;

import com.ndbk.uber.repository.DriverRepository;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

  final DriverRepository _driverRepository;

  public DriverService(DriverRepository driverRepository){
    this._driverRepository = driverRepository;
  }
}
