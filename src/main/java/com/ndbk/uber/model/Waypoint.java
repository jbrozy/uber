package com.ndbk.uber.model;

import jakarta.persistence.*;

@Entity(name = "waypoint")
public class Waypoint {
  @Id
  private Integer id;

  @Column(length = 50, nullable = false)
  private Integer number;

  @Column(nullable = false)
  private double latitude;

  @Column(nullable = false)
  private double longitude;

  @Column(name = "ride_id")
  private int rideId;

  @OneToOne()
  @JoinTable(name = "ride")
  @JoinColumn(name = "ride_id", referencedColumnName = "id")
  private Ride ride;

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }
}