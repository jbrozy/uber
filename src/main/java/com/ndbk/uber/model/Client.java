package com.ndbk.uber.model;

import jakarta.persistence.*;

import java.util.List;

@Entity()
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name", length = 50, nullable = false)
  private String name;

  @Column(name = "gender", nullable = false)
  private String gender;

  @ManyToMany(targetEntity = Ride.class, cascade = CascadeType.PERSIST)
  @JoinTable(name = "ride")
  private List<Ride> rides;

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
