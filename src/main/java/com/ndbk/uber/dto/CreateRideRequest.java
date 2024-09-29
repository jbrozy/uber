package com.ndbk.uber.dto;

import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;

public class CreateRideRequest {
  public int clientId;
  public int driverId;
  public Date rideDate;

  @Size(min = 2)
  public List<CreateWaypointRequest> waypoints;
}
