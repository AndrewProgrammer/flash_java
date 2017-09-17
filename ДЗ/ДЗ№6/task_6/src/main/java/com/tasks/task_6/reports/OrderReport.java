package com.tasks.task_6.reports;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import sun.util.calendar.BaseCalendar.Date;

public class OrderReport {

  private String book;
  private String customer;
  private LocalDateTime dateOfOrdering;
  private int quantityOfOrders;

  public OrderReport(String book, String customer, LocalDateTime dateOfOrdering, int quantityOfOrders) {
    this.book = book;
    this.customer = customer;
    this.dateOfOrdering = dateOfOrdering;
    this.quantityOfOrders = quantityOfOrders;
  }

  public String getBook() {
    return book;
  }

  public void setBook(String book) {
    this.book = book;
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public LocalDateTime getDateOfOrdering() {
    return dateOfOrdering;
  }

  public void setDateOfOrdering(LocalDateTime dateOfOrdering) {
    this.dateOfOrdering = dateOfOrdering;
  }

  public int getQuantityOfOrders() {
    return quantityOfOrders;
  }

  public void setQuantityOfOrders(int quantityOfOrders) {
    this.quantityOfOrders = quantityOfOrders;
  }
}
