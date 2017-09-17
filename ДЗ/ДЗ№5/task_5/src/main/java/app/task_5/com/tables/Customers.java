package app.task_5.com.tables;

import static app.task_5.com.JDBC.BookShopDataJdbc.getConnection;

import app.task_5.com.interfaces.AbstractBookShopData;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class Customers extends AbstractBookShopData {

  public Customers() throws SQLException, IOException {
  }

  @Override
  public void printElements() throws SQLException {
    String sql = "select * from customers";

    Statement statement = null;
    ResultSet customers = null;

    statement = getConnection().createStatement();
    customers = statement.executeQuery(sql);

    while (customers.next()) {
      String first_name = customers.getString("first_name");
      String last_name = customers.getString("last_name");
      String phone = customers.getString("phone");
      Timestamp dateOfRegistration = customers.getTimestamp("date_registered");

      System.out.println(first_name + " " + last_name + " "
          + phone + " " + dateOfRegistration + " ");
    }
  }

  @Override
  public void addElement() throws SQLException {
    String sql = "insert into customers(first_name, last_name, phone, date_registered) values(?, ?, ?, ?)";

    PreparedStatement preparedStatement = getConnection().prepareStatement(sql);

    preparedStatement.setString(1, "Mike");
    preparedStatement.setString(2, "Liberty");
    preparedStatement.setString(3, "777-68-23");
    preparedStatement.setTimestamp(4, Timestamp.valueOf("2015-02-22 04:14:09"));

    preparedStatement.executeUpdate();
    preparedStatement.close();

  }

  @Override
  public void transactionExample() throws SQLException {
    String sql1 = "insert into customers(first_name, last_name, phone, date_registered) values('John', 'Johnson', '777-58-24','2015-03-23 04:15:10')";
    String sql2 = "insert into customers(first_name, last_name, phone, date_registered) values('Dell', 'Pi', '777-64-25','2015-04-24 04:16:11')";

    getConnection().setAutoCommit(false);

    Statement statement = getConnection().createStatement();

    statement.executeUpdate(sql1);
    statement.executeUpdate(sql2);
    getConnection().commit();

    getConnection().setAutoCommit(true);
  }
}
