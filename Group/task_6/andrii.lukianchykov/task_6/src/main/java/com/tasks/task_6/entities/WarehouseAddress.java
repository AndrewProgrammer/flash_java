package com.tasks.task_6.entities;

import java.util.Arrays;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class WarehouseAddress {

  //Нет WarehouseAddress - а если бы был то это композиция, ведь этот адрес был бы именно в классе WarehouseAddress реализован

  @Column(name = "country")
  private String country;

  @Column(name = "city")
  private String city;

  @Column(name = "street")
  private String street;

  @Column(name = "zip")
  private int zip;

  @Column(name = "state")
  private char[] state = new char[2];

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public int getZip() {
    return zip;
  }

  public void setZip(int zip) {
    this.zip = zip;
  }

  public char[] getState() {
    return state;
  }

  public void setState(char[] state) {
    this.state = state;
  }

  @Override
  public String toString() {
    return "WarehouseAddress{" +
        "country='" + country + '\'' +
        ", city='" + city + '\'' +
        ", street='" + street + '\'' +
        ", zip=" + zip +
        ", state=" + Arrays.toString(state) +
        '}';
  }
}

