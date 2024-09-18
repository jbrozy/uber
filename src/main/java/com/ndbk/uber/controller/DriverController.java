package com.ndbk.uber.controller;

import com.ndbk.uber.service.DriverService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/client")
public class DriverController {
  private final DriverService _driverService;

  public DriverController(DriverService driverService){
    this._driverService = driverService;
  }


}
