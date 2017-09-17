package com.tasks.task_6.entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import sun.util.calendar.BaseCalendar.Date;

@Entity
@Table(name = "warehouse")
public class Warehouse {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT PRIMARY KEY;
  private double warehouse_id;

  @Column(name = "date_delivered")
  private LocalDateTime date_delivered;

  @Column(name = "quantity_of_books")
  private int quantity_of_books;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "book_id")
  private Book book;

  @Embedded
  private WarehouseAddress warehouseAddress; //Агрегация - добавляет поля другого класса реализованы в другом классе


  public LocalDateTime getDate_delivered() {
    return date_delivered;
  }

  public void setDate_delivered(LocalDateTime date_delivered) {
    this.date_delivered = date_delivered;
  }

  public int getQuantity_of_books() {
    return quantity_of_books;
  }

  public void setQuantity_of_books(int quantity_of_books) {
    this.quantity_of_books = quantity_of_books;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public double getWarehouse_id() {
    return warehouse_id;
  }

  public void setWarehouse_id(double warehouse_id) {
    this.warehouse_id = warehouse_id;
  }

  public WarehouseAddress getWarehouseAddress() {
    return warehouseAddress;
  }

  public void setWarehouseAddress(WarehouseAddress warehouseAddress) {
    this.warehouseAddress = warehouseAddress;
  }

  @Override
  public String toString() {
    return "Warehouse{" +
        ", date_delivered=" + date_delivered +
        ", quantity_of_books=" + quantity_of_books +
        ", book=" + book +
        ", warehouse_id=" + warehouse_id +
        '}';
  }
}
