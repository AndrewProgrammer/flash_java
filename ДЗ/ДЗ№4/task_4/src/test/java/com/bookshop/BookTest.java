package com.bookshop;

import com.bookshop.book.Book;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class BookTest {


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
        Book book = new Book();
    }

    @After
    public void tearDown() {
        System.out.println("After");
    }


}
