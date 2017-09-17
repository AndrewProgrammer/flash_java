package app.task_5.com.tables;

import static app.task_5.com.JDBC.BookShopDataJdbc.getConnection;

import app.task_5.com.interfaces.AbstractBookShopData;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Date;
import javax.xml.soap.Text;

public class Books extends AbstractBookShopData {

  public Books() throws SQLException, IOException {
  }

  @Override
  public void printElements() throws SQLException {

    String sql = "select * from books";

    Statement statement = null;
    ResultSet books = null;

    statement = getConnection().createStatement();
    books = statement.executeQuery(sql);

    while (books.next()) {

      String bookName = books.getString("book_name");
      String authorName = books.getString("author_name");
      String genre = books.getString("genre");
      String originalLanguage = books.getString("original_language");
      int quantity = books.getInt("quantity");
      int countOfSales = books.getInt("sales_count");
      Date published = books.getDate("first_published");
      double price = books.getDouble("price");



      System.out.println(bookName + " " + authorName + " " + genre
          + " " + originalLanguage + " " + quantity + " " + countOfSales
          + " " + published + " " + price + " ");
    }
  }

  @Override
  public void addElement() throws SQLException {
    String sql = "insert into books(book_name, author_name, genre, original_language, quantity, sales_count, first_published, price) "
        + "values(?, ?, ?, ?, ?, ?, ?, ?)";

    LocalDate date = null;
    PreparedStatement preparedStatement = getConnection().prepareStatement(sql);

    preparedStatement.setString(1, "Don Quixote");
    preparedStatement.setString(2, "Miguel de Cervantes");
    preparedStatement.setString(3, "novel");
    preparedStatement.setString(4, "Spanish");
    preparedStatement.setInt(5, 500);
    preparedStatement.setInt(6, 500);
    preparedStatement.setDate(7, java.sql.Date.valueOf(date.of(1605, 02, 22)));
    preparedStatement.setDouble(8, 1000);

    preparedStatement.executeUpdate();
    preparedStatement.close();
  }

  @Override
  public void transactionExample() throws SQLException {
    String sql1 =
        "insert into books(book_name, author_name, genre, original_language, quantity, sales_count, first_published, price)"
            + " values('A Tale of Two Cities', 'Charles Dickens', 'historical fiction', 'English', 500, 500, '1859,02,22', 1149.99)";
    String sql2 =
        "insert into books(book_name, author_name, genre, original_language, quantity, sales_count, first_published, price)"
            + " values('The Lord of the Rings', 'J. R. R. Tolkien', 'fantasy', 'English', 500, 500, '1945,02,22', 1199.99)";

    getConnection().setAutoCommit(false);

    Statement statement = getConnection().createStatement();

    try {
      statement.executeUpdate(sql1);
      statement.executeUpdate(sql2);
      getConnection().commit();
    } catch (Exception e) {
      getConnection().rollback();
    }

    getConnection().setAutoCommit(true);
  }

  public void addInfoAboutBook() throws SQLException, FileNotFoundException {
    String sq2 = "update books set content = ? where content = 1";

    PreparedStatement preparedStatement = getConnection().prepareStatement(sq2);

    File file = new File("items/text.txt");
    FileReader fileReader = new FileReader(file);

    preparedStatement.setCharacterStream( 1, fileReader);

    preparedStatement.executeUpdate();

    preparedStatement.close();
  }


  public void readInfoAboutBook() throws SQLException, IOException {
    String sql = "select content from books where content = 1";

    Statement statement = getConnection().createStatement();
    ResultSet resultSet = statement.executeQuery(sql);

    if (resultSet.next()) {
      Clob content = resultSet.getClob("content");
      Reader reader = content.getCharacterStream();
      BufferedReader bufferedReader = new BufferedReader(reader);

      //bufferedReader.lines().forEach(System.out::println);
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        System.out.println(line);
      }
    }

    resultSet.close();
    statement.close();
  }

  public void saveImageOfBook() throws SQLException, FileNotFoundException {
    String sq2 = "update books set image = ? where image = 1";

    PreparedStatement preparedStatement = getConnection().prepareStatement(sq2);
    File imageBook = new File("items/book 1.png");

    imageBook = new File(String.valueOf(imageBook));
    FileInputStream fileInputStream = new FileInputStream(imageBook);

    preparedStatement.setBinaryStream(1, fileInputStream);

    preparedStatement.executeUpdate();

    preparedStatement.close();
  }

  public void retrieveImageOfBookInBase64() throws SQLException, IOException {
    String sql = "select image from books where image = 1";

    Statement statement = getConnection().createStatement();
    ResultSet resultSet = statement.executeQuery(sql);

    File imageBookCopy = new File("items/book 1_copy.png");

    imageBookCopy = new File(String.valueOf(imageBookCopy));

    if (resultSet.next()) {
      Blob blob = resultSet.getBlob("image");
      FileOutputStream fileOutputStream = new FileOutputStream(imageBookCopy);
      fileOutputStream.write(blob.getBytes(1, (int) blob.length()));

      fileOutputStream.flush();
      fileOutputStream.close();
    }

    resultSet.close();
    statement.close();
  }
  public void addContentAndImage() throws SQLException {
    String sq1 = "ALTER TABLE  books "
        + "ADD content TEXT NOT NULL, "
        + "ADD image BLOB NOT NULL;";

    PreparedStatement preparedStatement = getConnection().prepareStatement(sq1);

    preparedStatement.executeUpdate();
    preparedStatement.close();
  }
}