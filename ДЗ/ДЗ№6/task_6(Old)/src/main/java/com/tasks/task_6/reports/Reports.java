package com.tasks.task_6.reports;

import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import sun.util.calendar.BaseCalendar.Date;

public class Reports {

  public List<OrderReport> getOrderResults(String book_name, String author_name, int quantity, LocalDateTime first_published, String first_name, String last_name, Session session) {

    Query query = session.createQuery("select " +
        "new com.tasks.task_6.reports.OrderReport(b.book_name, b.author_name, b.quantity, b.first_published,"
        + "c.first_name, c.last_name,"
        + "e.dateOfOrdering,"
        + "e.currentTimeOfOrdering,"
        + "e.quantityOfOrders) " +
        "from OrderBS e, Book b, Customer c " +
        "where e.book.book_id = b.book_id and e.customer.customer_id = c.customer_id and " +
        "b.book_name = :book_name and " +
        "b.author_name = :author_name and " +
        "b.quantity = :quantity and " +
        "b.first_published = :first_published and " +
        "c.first_name = :first_name and " +
        "c.last_name = :last_name");

    query.setParameter("book_name", book_name);
    query.setParameter("author_name", author_name);
    query.setParameter("quantity", quantity);
    query.setParameter("first_published", first_published);
    query.setParameter("first_name", first_name);
    query.setParameter("last_name", last_name);


    return query.getResultList();
  }
}
