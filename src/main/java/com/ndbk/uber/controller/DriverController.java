package com.ndbk.uber.controller;

import com.ndbk.uber.dto.CreateDriverRequest;
import com.ndbk.uber.dto.UpdateDriverRequest;
import com.ndbk.uber.model.Driver;
import com.ndbk.uber.service.DriverService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/driver")
public class DriverController {
  private final DriverService _driverService;

  public DriverController(DriverService driverService){
    this._driverService = driverService;
  }


  @PostMapping
  public ResponseEntity<Driver> CreateDriver(@RequestBody CreateDriverRequest createDriverRequest){
    Driver newDriver = _driverService.create(createDriverRequest);

    return ResponseEntity.ok().body(newDriver);
  }

  @PutMapping
  public ResponseEntity<Driver> UpdateDriver(@RequestBody UpdateDriverRequest driver){
    Driver updateDriver = _driverService.updateDriver(driver);
    return updateDriver != null ? ResponseEntity.ok().body(updateDriver) : ResponseEntity.notFound().build();
  }

  @GetMapping("{driverId}")
  public ResponseEntity<Driver> GetDriverById(@PathVariable  int driverId){
    Optional<Driver> driver = _driverService.getDriverById(driverId);
    return driver.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("{driverId}")
  public ResponseEntity<Driver> DeleteDriverById(@PathVariable  int driverId){
    _driverService.deleteDriverById(driverId);
    return ResponseEntity.ok().build();
  }
}
