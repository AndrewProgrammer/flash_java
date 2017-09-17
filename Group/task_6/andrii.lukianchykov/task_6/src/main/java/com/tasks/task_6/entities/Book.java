package com.tasks.task_6.entities;

import static com.tasks.task_6.HibernateUtilities.getSessionFactory;

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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import sun.util.calendar.BaseCalendar.Date;

@NamedNativeQueries({
    @NamedNativeQuery(
        name = "books",
        query = "select * from books",
        resultClass = Book.class
    )
})
@Entity
@Table(name = "books")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private double book_id;

  @Column(name = "book_name")
  private String book_name;

  @Column(name = "author_name")
  private String author_name;

  @Column(name = "genre")
  private String genre;

  @Column(name = "original_language")
  private String original_language;

  @Column(name = "quantity")
  private int quantity;

  @Column(name = "sales_count")
  private int sales_count;

  @Column(name = "first_published")
  private  LocalDateTime  first_published;

  @Column(name = "content")
  private String  content;

  @Column(name = "image")
  private Blob image;

  @Column(name = "price")
  private double price;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
  private Set<OrderBS> orders;

  public String getBook_name() {
    return book_name;
  }

  public void setBook_name(String book_name) {
    this.book_name = book_name;
  }

  public String getAuthor_name() {
    return author_name;
  }

  public void setAuthor_name(String author_name) {
    this.author_name = author_name;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getOriginal_language() {
    return original_language;
  }

  public void setOriginal_language(String original_language) {
    this.original_language = original_language;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public int getSales_count() {
    return sales_count;
  }

  public void setSales_count(int sales_count) {
    this.sales_count = sales_count;
  }

  public LocalDateTime getFirst_published() {
    return first_published;
  }

  public void setFirst_published( LocalDateTime  first_published) {
    this.first_published = first_published;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Blob getImage() {
    return image;
  }

  public void setImage(Blob image) {
    this.image = image;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getBook_id() {
    return book_id;
  }

  public void setBook_id(double book_id) {
    this.book_id = book_id;
  }

  /*public void addInfoAboutBook() throws SQLException, FileNotFoundException {
    String sq2 = "update books set content = ? where content = 1";

    PreparedStatement preparedStatement = getSessionFactory().preparedStatement(sq2);

    File file = new File("items/text.txt");
    FileReader fileReader = new FileReader(file);

    preparedStatement.setCharacterStream( 1, fileReader);

    preparedStatement.executeUpdate();

    preparedStatement.close();
  }


  public void readInfoAboutBook() throws SQLException, FileNotFoundException, IOException {
    String sql = "select content from books where content = 1";

    Statement statement = getSessionFactory().createStatement();
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

    PreparedStatement preparedStatement = getSessionFactory().preparedStatement(sq2);
    File imageBook = new File("items/book 1.png");

    imageBook = new File(String.valueOf(imageBook));
    FileInputStream fileInputStream = new FileInputStream(imageBook);

    preparedStatement.setBinaryStream(1, fileInputStream);

    preparedStatement.executeUpdate();

    preparedStatement.close();
  }

  public void retrieveImageOfBookInBase64() throws SQLException, IOException {
    String sql = "select image from books where image = 1";

    Statement statement = getSessionFactory().createStatement();
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
  }*/

  @Override
  public String toString() {
    return "Book{" +
        "book_name='" + book_name + '\'' +
        ", author_name='" + author_name + '\'' +
        ", genre='" + genre + '\'' +
        ", original_language='" + original_language + '\'' +
        ", quantity=" + quantity +
        ", sales_count=" + sales_count +
        ", first_published=" + first_published +
        ", content=" + content +
        ", image=" + image +
        ", price=" + price +
        ", book_id=" + book_id +
        '}';
  }
}
