package com.ndbk.uber.dto;

import com.ndbk.uber.model.Waypoint;
import jakarta.persistence.Column;

public class CreateWaypointRequest {
  public Integer number;
  public double latitude;
  public double longitude;

  public Waypoint convert(){
    Waypoint waypoint = new Waypoint();
    waypoint.setLatitude(this.latitude);
    waypoint.setLongitude(this.longitude);

    return waypoint;
  }
}
