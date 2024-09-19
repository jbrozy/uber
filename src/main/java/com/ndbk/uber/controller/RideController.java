package com.ndbk.uber.controller;

import com.ndbk.uber.dto.CreateClientRequest;
import com.ndbk.uber.dto.UpdateClientRequest;
import com.ndbk.uber.model.Client;
import com.ndbk.uber.service.ClientService;
import com.ndbk.uber.service.RideService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/ride")
public class RideController {
  private final RideService _rideService;

  public RideController(RideService rideService){
    _rideService = rideService;
  }
}
