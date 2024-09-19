package com.ndbk.uber.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "driver")
public class Driver {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 50, nullable = false)
  private String name;

  @Column(nullable = false)
  private String city;

  @Column(name = "license_plate", nullable = false)
  private String licensePlate;

  @ManyToMany
  private Set<Ride> rides;

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getLicensePlate() {
    return licensePlate;
  }

  public void setLicensePlate(String licensePlate) {
    this.licensePlate = licensePlate;
  }
}
