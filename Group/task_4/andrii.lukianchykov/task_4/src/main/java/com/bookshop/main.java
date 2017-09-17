package com.bookshop;

import com.bookshop.bookdatabase.BookDataBase;

public class main {

  public static void main(String[] args) {
      BookDataBase bookDataBase = new BookDataBase();
      bookDataBase.defaultValuesListOfBooks();
      bookDataBase.showBookList();
      bookDataBase.showBookList();
    }
}
