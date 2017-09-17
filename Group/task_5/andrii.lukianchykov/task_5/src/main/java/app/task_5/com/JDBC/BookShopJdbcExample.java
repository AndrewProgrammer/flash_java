package app.task_5.com.JDBC;

import app.task_5.com.tables.Books;
import app.task_5.com.tables.Customers;
import app.task_5.com.tables.Orders;
import app.task_5.com.tables.Warehouse;
import java.io.IOException;
import java.sql.SQLException;

public class BookShopJdbcExample {

  public static void main(String[] args) throws SQLException, IOException {

    Books book = new Books();
    Customers customer = new Customers();
    Orders order = new Orders();
    Warehouse warehouse = new Warehouse();

    BookShopDataJdbc bookShopDataJdbc = new BookShopDataJdbc(book, customer, order, warehouse);

   /* bookShopDataJdbc.getBook().printElements();
    bookShopDataJdbc.getBook().addElement();
    bookShopDataJdbc.getBook().printElements();


    bookShopDataJdbc.getBook().transactionExample();

    bookShopDataJdbc.getBook().addContentAndImage();
    bookShopDataJdbc.getBook().addInfoAboutBook();
    bookShopDataJdbc.getBook().readInfoAboutBook();

    bookShopDataJdbc.getBook().saveImageOfBook();
    bookShopDataJdbc.getBook().retrieveImageOfBookInBase64();*/

    /*bookShopDataJdbc.getCustomer().printElements();
    bookShopDataJdbc.getCustomer().addElement();
    bookShopDataJdbc.getCustomer().printElements();
    bookShopDataJdbc.getCustomer().transactionExample();*/


    bookShopDataJdbc.getOrder().printElements();
    //bookShopDataJdbc.getOrder().addElement();
    bookShopDataJdbc.getOrder().printElements();
    //bookShopDataJdbc.getOrder().transactionExample();

    bookShopDataJdbc.getWarehouse().printElements();
    //bookShopDataJdbc.getWarehouse().addElement();
    bookShopDataJdbc.getWarehouse().printElements();
    //bookShopDataJdbc.getWarehouse().transactionExample();

  }
}
