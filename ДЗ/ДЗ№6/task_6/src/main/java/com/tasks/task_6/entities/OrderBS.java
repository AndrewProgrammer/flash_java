package com.tasks.task_6.entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import sun.util.calendar.BaseCalendar.Date;

@Entity
@Table(name = "orders")
public class OrderBS {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT PRIMARY KEY;
  private double order_id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "book_id")
  private Book book;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @Column(name = "date_of_order")
  private LocalDateTime date_of_order;

  @Column(name = "quantity_of_orders")
  private int quantity_of_orders;

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public void setDate_of_order(LocalDateTime date_of_order) {
    this.date_of_order = date_of_order;
  }

  public int getQuantity_of_orders() {
    return quantity_of_orders;
  }

  public void setQuantity_of_orders(int quantity_of_orders) {
    this.quantity_of_orders = quantity_of_orders;
  }

  public double getOrder_id() {
    return order_id;
  }

  public void setOrder_id(double order_id) {
    this.order_id = order_id;
  }

  @Override
  public String toString() {
    return "OrderBS{" +
        "order_id=" + order_id +
        ", book=" + book +
        ", customer=" + customer +
        ", date_of_order=" + date_of_order +
        ", quantity_of_orders=" + quantity_of_orders +
        '}';
  }
}
