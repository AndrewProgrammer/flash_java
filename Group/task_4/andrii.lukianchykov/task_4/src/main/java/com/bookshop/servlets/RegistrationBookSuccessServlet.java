package com.bookshop.servlets;

import com.bookshop.book.Book;
import com.bookshop.response.Response;
import com.bookshop.bookdatabase.BookDataBase;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/books/registration/success")
public class RegistrationBookSuccessServlet extends HttpServlet {

    public Response response = new Response();
    private BookDataBase bookDataBase = new BookDataBase();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter outPut = resp.getWriter();

        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String year = req.getParameter("year");

        response.getRegistrationResultStart(title, author, year);
        bookDataBase.addNewBookByStrings(title, author, year);
        response.getRegistrationResultEnd();
    }
}
