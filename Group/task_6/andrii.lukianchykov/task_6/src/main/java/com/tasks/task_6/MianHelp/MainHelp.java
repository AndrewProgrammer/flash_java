package com.tasks.task_6.MianHelp;

import com.tasks.task_6.HibernateUtilities;
import com.tasks.task_6.entities.Book;
import com.tasks.task_6.entities.Privacy.Role;
import com.tasks.task_6.entities.Privacy.User;
import com.tasks.task_6.reports.OrderReport;
import com.tasks.task_6.reports.Reports;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class MainHelp {

  public MainHelp(){}

  public void getHelp() throws SQLException {

    SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
    Session session = sessionFactory.openSession();

    NativeQuery query = session.createNativeQuery("select version();");
    session.createNativeQuery("select version();");
    String result = (String) query.getSingleResult();
    System.out.println(result);

    Transaction tx = session.beginTransaction();

    LocalDate date = null;

    Book book = new Book();
    book.setBook_name("Don Quixote");
    book.setAuthor_name("Miguel de Cervantes");
    book.setGenre("novel");
    book.setOriginal_language("Spanish");
    book.setQuantity(500);
    book.setSales_count(500);
    book.setFirst_published(date.atStartOfDay());
    book.setPrice(999.99);


    session.save(book);

    Book book1 = session.get(Book.class, (double) 1); // Если не найдет id - Null
    //book book = session.get(book.class, (long) 1); // Если не найдет id - EXCEPTION
    System.out.println(book1);

    //how to Update
    book1.setSales_count(book1.getSales_count() + 10);

    User user = new User();
    user.setLogin("Andrew");
    user.setPassword("root");

    Role role1 = new Role();
    role1.setName("admin");

    Role role2 = new Role();
    role2.setName("customer");

    Set<Role> roles = new HashSet<>();
    roles.add(role1);
    roles.add(role2);

    user.setRoles(roles);

    session.save(user);

    Reports reports = new Reports();
    List<OrderReport> exams = reports.getOrderResults("Don Quixote", "Miguel de Cervantes", 500, date.atStartOfDay(), "Mike", "Liberty", session);

    Query query1 = session.createNamedQuery("bookByName");

    query1.setParameter("book_name", "Don Quixote");
    query1.setParameter("author_name", "Miguel de Cervantes");
    query.setParameter("quantity", 500);
    query.setParameter("first_published", date.atStartOfDay());
    query.setParameter("first_name", "Mike");
    query.setParameter("last_name", "Liberty");

    Book book2 = (Book) query1.getSingleResult();

    NativeQuery nativeQuery = session.
        createNativeQuery("select * from books").
        addEntity(Book.class);

    Book book3 = (Book) nativeQuery.getSingleResult();

    tx.commit();

    sessionFactory.close();

  }
}
