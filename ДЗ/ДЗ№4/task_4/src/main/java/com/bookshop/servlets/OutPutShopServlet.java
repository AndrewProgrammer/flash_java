package com.bookshop.servlets;

import com.bookshop.response.Response;
import com.bookshop.bookdatabase.BookDataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "/books/output")
public class OutPutShopServlet extends HttpServlet {

    private Response response = new Response();
    private BookDataBase bookDataBase = new BookDataBase();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter outPut = resp.getWriter();

        response.getOutPutHead();
        bookDataBase.showBooksServletOutput();
        response.getOutPutEnd();
    }
}


