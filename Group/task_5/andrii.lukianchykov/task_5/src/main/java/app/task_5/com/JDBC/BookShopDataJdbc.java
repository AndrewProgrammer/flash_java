package app.task_5.com.JDBC;

import app.task_5.com.tables.Books;
import app.task_5.com.tables.Customers;
import app.task_5.com.tables.Orders;
import app.task_5.com.tables.Warehouse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookShopDataJdbc {

  private static Connection connection;

  private Books book;
  private Customers customer;
  private Orders order;
  private Warehouse warehouse;

  public BookShopDataJdbc(Books book, Customers customer, Orders order, Warehouse warehouse)
      throws SQLException {

    this.book = book;
    this.customer = customer;
    this.order = order;
    this.warehouse = warehouse;

  /*  InputStream inputStream = getClass().getResourceAsStream("/db.properties");
    Properties properties = new Properties();
    properties.load(inputStream);*/



    /*
    connection = DriverManager
        .getConnection(properties.getProperty("url"),
            properties.getProperty("username"),
            properties.getProperty("password"));
            */

    /*MysqlConnectionPoolDataSource cp = new MysqlConnectionPoolDataSource();
    cp.setServerName("localhost");
    cp.setPortNumber(3306);
    cp.setUser("root");
    cp.setPassword("root");
    cp.setDatabaseName("bookshop");

    PooledConnection pooledConnection = cp.getPooledConnection();

    connection = pooledConnection.getConnection();

    System.out.println("Connected");*/

    connection = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/BookShop?serverTimezone=UTC&useSSL=false",
        "root",
        "root");
    System.out.println("Connection successful");

  }

  public Books getBook() {
    return book;
  }

  public Customers getCustomer() {
    return customer;
  }

  public Orders getOrder() {
    return order;
  }

  public Warehouse getWarehouse() {
    return warehouse;
  }

  public static Connection getConnection() {
    return connection;
  }
}
