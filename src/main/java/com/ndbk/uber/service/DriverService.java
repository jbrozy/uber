package com.ndbk.uber.service;

import com.ndbk.uber.dto.CreateDriverRequest;
import com.ndbk.uber.model.Driver;
import com.ndbk.uber.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverService {

  final DriverRepository _driverRepository;

  public DriverService(DriverRepository driverRepository){
    this._driverRepository = driverRepository;
  }

  public Driver create(CreateDriverRequest createDriverRequest){
    Driver driver = new Driver();
    driver.setName(createDriverRequest.name);
    driver.setCity(createDriverRequest.city);
    driver.setLicensePlate(createDriverRequest.licensePlate);


    return _driverRepository.save(driver);
  }

  public Optional<Driver> getDriverById(int id){
    return _driverRepository.findById(id);
  }
}
