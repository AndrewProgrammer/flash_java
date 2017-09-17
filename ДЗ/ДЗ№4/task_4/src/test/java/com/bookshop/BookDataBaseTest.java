package com.bookshop;

import com.bookshop.bookdatabase.BookDataBase;
import com.bookshop.helpTests.ListIsEmptyException;
import com.bookshop.helpTests.ListIsNotEmptyException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BookDataBaseTest {

  BookDataBase bookDataBase;

  @Rule
  public ExpectedException expectedException =
      ExpectedException.none();

  @BeforeClass
  public static void setUpClass() {
    System.out.println("Before Class");
  }

  @AfterClass
  public static void tearDownClass() {
    System.out.println("After Class");
  }

  @Before
  public void setUp() {
    System.out.println("Before");
    bookDataBase = new BookDataBase();

  }

  @After
  public void tearDown() {
    System.out.println("After");
  }

  @Test(expected = ListIsEmptyException.class)
  public void shouldRemoveCorrect() {
    bookDataBase.removeList();
  }

  @Test(expected = ListIsEmptyException.class)
  public void shouldNotAddElementsInListWhenItIsEmpty() {
    bookDataBase.addNewBook();
  }

  @Test(expected = ListIsEmptyException.class)
  public void shouldRemoveCorrectByIndex() {
    bookDataBase.removeListByIndex();
  }

  @Test(expected = ListIsEmptyException.class)
  public void shouldFindBookByAuthor() {
    bookDataBase.findBookByAuthor("Test");
  }

  @Test(expected = ListIsNotEmptyException.class)
  public void shouldAddDefaultBooks() {
    bookDataBase.defaultValuesListOfBooks();
  }

  @Test(expected = ListIsEmptyException.class)
  public void shouldShowOutputInfoToTheServlet(){
    bookDataBase.showBooksServletOutput();
  }

  /*@Test(expected = IncorrectSymbol.class)
  public void shouldInputCorrectData() {
    bookDataBase.removeListByIndex();
  }*/
}
