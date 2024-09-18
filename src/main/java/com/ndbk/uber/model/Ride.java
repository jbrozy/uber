package com.ndbk.uber.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

  @OneToMany
  @JoinTable(name = "client")
  @JoinColumn(name = "client_id", referencedColumnName = "id")
  private Set<Client> clients = new HashSet<>();

  @OneToOne
  @JoinTable(name = "driver")
  @JoinColumn(name = "driver_id", referencedColumnName = "id")
  private Driver driver;

  @ManyToMany
  @Size(min = 2, max = 2)
  private Set<Waypoint> waypoints = new HashSet<>();

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

  public void addWaypoint(Waypoint waypoint){
    this.waypoints.add(waypoint);
  }
}
