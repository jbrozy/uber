package com.ndbk.uber.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;
import java.util.stream.Collectors;

@Entity(name = "ride")
public class Ride {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "ride_date", nullable = false)
  @DateTimeFormat(pattern = "dd-MM-yyyy")
  private Date rideDate;

  @Column(nullable = false)
  private int distance;

  @Column(nullable = false)
  private int price;

  @ManyToOne
  @JoinColumn(name = "client_id", nullable = false) // Foreign key in Ride table
  @JsonBackReference
  private Client client;

  @ManyToOne
  @JoinColumn(name = "driver_id", nullable = false)
  private Driver driver;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(insertable = true, updatable = false, name = "ride_id")
  private Set<Waypoint> waypoints = new HashSet<>();

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public Driver getDriver() {
    return driver;
  }

  public void setDriver(Driver driver) {
    this.driver = driver;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public Date getRideDate() {
    return rideDate;
  }

  public void setRideDate(Date rideDate) {
    this.rideDate = rideDate;
  }

  public int getDistance() {
    return distance;
  }

  public void setDistance(int distance) {
    this.distance = distance;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Set<Waypoint> getWaypoints() {
    return waypoints;
  }

  public void setWaypoints(List<Waypoint> waypoints) {
    this.waypoints = new HashSet<>(waypoints);
  }
}
