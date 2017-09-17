package app.task_5.com.tables;

import static app.task_5.com.JDBC.BookShopDataJdbc.getConnection;

import app.task_5.com.interfaces.AbstractBookShopData;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

public class Warehouse extends AbstractBookShopData {

  public Warehouse() throws SQLException, IOException {
  }

  @Override
  public void printElements() throws SQLException {
    String sql = "select * from warehouse";

    Statement statement = null;
    ResultSet warehouse = null;

    statement = getConnection().createStatement();
    warehouse = statement.executeQuery(sql);

    while (warehouse.next()) {
      Date dateOfDelivering = warehouse.getDate("date_delivered");
      int quantityOfBooks = warehouse.getInt("quantity_of_books");
      int book_id = warehouse.getInt("book_id");

      System.out.println(dateOfDelivering + " " + quantityOfBooks + " ");
    }
  }

  @Override
  public void addElement() throws SQLException {

    String sql = "insert into warehouse(date_delivered, quantity_of_books) values(?, ?)";
    //String sq1 = "insert into warehouse(date_delivered, quantity_of_books,book_id) values(?, ?, ?)";

    LocalDate date = null;
    PreparedStatement preparedStatement = getConnection().prepareStatement(sql);

    preparedStatement.setDate(1, java.sql.Date.valueOf(date.of(1605, 02, 22)));
    preparedStatement.setInt(2, 500);
    //preparedStatement.setInt(3,3);

    preparedStatement.executeUpdate();
    preparedStatement.close();

  }

  @Override
  public void transactionExample() throws SQLException {
    String sql1 = "insert into warehouse(date_delivered, quantity_of_books) values('1870,03,23', 500)";
    String sql2 = "insert into warehouse(date_delivered, quantity_of_books) values('1870,04,24', 500)";

    /*String sql1 = "insert into warehouse(date_delivered, quantity_of_books, book_id) values('1870,03,23', 500,4)";
    String sql2 = "insert into warehouse(date_delivered, quantity_of_books, book_id) values('1870,04,24', 500,5)";
*/
    getConnection().setAutoCommit(false);

    Statement statement = getConnection().createStatement();

    statement.executeUpdate(sql1);
    statement.executeUpdate(sql2);
    getConnection().commit();

    getConnection().setAutoCommit(true);
  }

}
