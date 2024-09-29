package com.ndbk.uber.service;

import com.ndbk.uber.dto.CreateDriverRequest;
import com.ndbk.uber.dto.UpdateDriverRequest;
import com.ndbk.uber.model.Driver;
import com.ndbk.uber.repository.DriverRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverService {

  final DriverRepository _driverRepository;

  public DriverService(DriverRepository driverRepository){
    this._driverRepository = driverRepository;
  }

  public Driver updateDriver(UpdateDriverRequest updateDriverRequest){
    Driver driver = new Driver();
    driver.setId(updateDriverRequest.id);
    driver.setName(updateDriverRequest.name);
    driver.setLicensePlate(updateDriverRequest.licensePlate);
    driver.setCity(updateDriverRequest.city);

    return _driverRepository.save(driver);
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

  public void deleteDriverById(int id){
    _driverRepository.deleteById(id);
  }

  public Page<Driver> getDrivers(String name, String licensePlate, Pageable pageable) {
    if(name == null && licensePlate == null){
      return _driverRepository.findAll(pageable);
    }

    if(licensePlate == null)
      return _driverRepository.findByNameContains(name, pageable);

    if(name == null)
      return _driverRepository.findByLicensePlateContains(licensePlate, pageable);

    return _driverRepository.findByLicensePlateContainsAndNameContains(licensePlate, name, pageable);
  }
}
