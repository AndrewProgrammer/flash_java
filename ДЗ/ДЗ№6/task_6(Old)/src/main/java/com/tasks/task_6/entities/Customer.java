package com.tasks.task_6.entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT PRIMARY KEY;
  private double customer_id;

  @Column(name = "first_name")
  private String first_name;

  @Column(name = "last_name")
  private String last_name;

  @Column(name = "phone")
  private String phone;

  @Column(name = "date_registered")
  private LocalDateTime date_registered;

  @Embedded
  private CustomerAddress customerAddress;

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public LocalDateTime getDate_registered() {
    return date_registered;
  }

  public void setDate_registered(LocalDateTime date_registered) {
    this.date_registered = date_registered;
  }

  public double getCustomer_id() {
    return customer_id;
  }

  public void setCustomer_id(double customer_id) {
    this.customer_id = customer_id;
  }

  public CustomerAddress getCustomerAddress() {
    return customerAddress;
  }

  public void setCustomerAddress(CustomerAddress customerAddress) {
    this.customerAddress = customerAddress;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "first_name='" + first_name + '\'' +
        ", last_name='" + last_name + '\'' +
        ", phone='" + phone + '\'' +
        ", date_registered=" + date_registered +
        ", customer_id=" + customer_id +
        '}';
  }
}
