package app.task_5.com.tables;

import static app.task_5.com.JDBC.BookShopDataJdbc.getConnection;
import static java.sql.Types.NULL;

import app.task_5.com.interfaces.AbstractBookShopData;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

public class Orders extends AbstractBookShopData {

  public Orders() throws SQLException, IOException {
  }

  @Override
  public void printElements() throws SQLException {
    String sql = "select * from orders";

    Statement statement = null;
    ResultSet orders = null;

    statement = getConnection().createStatement();
    orders = statement.executeQuery(sql);

    while (orders.next()) {

      Date dateOfOrder = orders.getDate("date_of_order");
      Timestamp timeOfDelivering = orders.getTimestamp("time_of_order");
      int quantityOforders = orders.getInt("quantity_of_orders");
      /*int book_id = orders.getInt("book_id");
      int customer_id = orders.getInt("customer_id");

      System.out.println(dateOfOrder + " " + timeOfDelivering + " " + quantityOforders + " "
      + book_id + " " + customer_id + " " );*/
    }
  }

  @Override
  public void addElement() throws SQLException {
    //String sql = "insert into orders(date_of_order, time_of_order, quantity_of_orders, book_id, customer_id) values(?, ?, ?, ?, ?)";
    String sql = "insert into orders(date_of_order, time_of_order, quantity_of_orders) values(?, ?, ?)";
    PreparedStatement preparedStatement = getConnection().prepareStatement(sql);

    preparedStatement.setTimestamp(1, Timestamp.valueOf("2015-02-22 04:14:09"));
    preparedStatement.setDate(2, java.sql.Date.valueOf(LocalDate.of(2015, 02, 22)));
    preparedStatement.setInt(3, 500);
  /*  preparedStatement.setInt(4, NULL);
    preparedStatement.setInt(5,NULL);*/

    preparedStatement.executeUpdate();
    preparedStatement.close();
  }

  @Override
  public void transactionExample() throws SQLException {

    /*String sql = "INSERT INTO orders(date_of_order, time_of_order, quantity_of_orders, book_id, customer_id) VALUES ('2015-06-07 10:15:22', '2015,06,07',500,NULL, NULL )";
    String sql1 = "INSERT INTO orders(date_of_order, time_of_order, quantity_of_orders, book_id, customer_id) VALUES ('2016-08-09 14:23:45', '2016,08,09',500,NULL, NULL)";
*/
    String sql = "INSERT INTO orders(date_of_order, time_of_order, quantity_of_orders) VALUES ('2015-06-07 10:15:22', '2015,06,07',500)";
    String sql1 = "INSERT INTO orders(date_of_order, time_of_order, quantity_of_orders) VALUES ('2016-08-09 14:23:45', '2016,08,09',500)";

    getConnection().setAutoCommit(false);

    Statement statement = getConnection().createStatement();

    statement.executeUpdate(sql);
    statement.executeUpdate(sql1);
    getConnection().commit();

    getConnection().setAutoCommit(true);
  }

}
