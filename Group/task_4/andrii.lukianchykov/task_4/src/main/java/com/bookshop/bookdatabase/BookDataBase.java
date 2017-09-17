package com.bookshop.bookdatabase;

import static java.lang.System.out;

import com.bookshop.book.Book;
import com.bookshop.helpTests.IncorrectSymbol;
import com.bookshop.helpTests.ListIsEmptyException;
import com.bookshop.helpTests.ListIsNotEmptyException;
import com.bookshop.helpTests.ListIsNullException;
import com.bookshop.response.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDataBase {

    private List<Book> listOfBooks = new ArrayList<>();
    private Book book = new Book();
    private Response response = new Response();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of Books: ").append(listOfBooks);
        return sb.toString();
    }
    public void showBookList(){
        out.println("List of books: " + listOfBooks.toString());
    }

    public void showBooksServletOutput() {

        if( listOfBooks.size() == 0) {
            throw new ListIsEmptyException("List is empty");
        }
        if(listOfBooks.isEmpty()) {
            for(Book b : listOfBooks){
                response.getMiddle(b.getTitleBook(),b.getAuthorBook(),b.getYearBook());
                showBookList();
            }
        }else{
            response.getOutPutElse();
        }
    }

    public void defaultValuesListOfBooks() {

        if (listOfBooks.size() != 0) {

            listOfBooks.add(new Book("Legend of Searcher", "Terry Goodkind", "2008"));
            listOfBooks.add(new Book("Comics", "Overwatch", "2017"));
            listOfBooks.add(new Book("Limited Collection of how to code right", "Java Enetrprise", "2017"));

        } else{
            throw new ListIsNotEmptyException("List is not empty");
        }
    }

    public List<Book> findBookByAuthor(String author) {

        List<Book> books = new ArrayList<Book>();

        if( listOfBooks.size() == 0) {
            throw new ListIsEmptyException("List is empty");
        }

        if (listOfBooks.isEmpty()) {
            for (Book b : listOfBooks) {
                if (b.getAuthorBook().equals(author)) {
                    response.getMiddle(b.getTitleBook(),b.getAuthorBook(),b.getYearBook());
                    books.add(book);
                }
            }
        }else{
            response.getSearchElse();
        }

        return books;
    }

    public void addNewBook() {

        if( listOfBooks.size() == 0) {
            throw new ListIsEmptyException("List is empty");
        }
        listOfBooks.add(book);
    }

    public void addNewBookByStrings(String title, String author, String year) {

        Scanner scanner = new Scanner(System.in);
        String key = "0";

        out.println("<p>Do you want to add new String to current elements? Or you want to delete existing elements?\n"
            + "Yes(add) - 1\n" + "No(remove) - 2");

        if(!scanner.hasNextLine()) {

            key = scanner.nextLine();

            switch (key) {
                case "1":
                    listOfBooks.add(new Book(title,author,year));
                    break;
                case "2":
                    removeList();
                    break;
                case "3":
                    removeListByIndex();
                default:
                    throw new IncorrectSymbol("IncorrectSymbol.Pls read instruction");
            }
        }
    }

    public void removeList() {

        if(listOfBooks.size() == 0) {
            throw new ListIsEmptyException("List is empty already");
        }
        for(int i = listOfBooks.size() - 1; i>=0; i--) {
            listOfBooks.get(i);
            listOfBooks.remove(i);
        }
        out.println("<p>List was successfully removed<p>");

    }
    public void removeListByIndex() {

        if(listOfBooks.size() == 0) {
            throw new ListIsEmptyException("List is empty already");
        }
        Scanner scanner = new Scanner(System.in);
        int key;

        out.println("<p> Input id of book: <p>");

        if(!scanner.hasNextInt()) {
            key = scanner.nextInt();

            if (key != listOfBooks.size()) {
                throw new IncorrectSymbol("IncorrectSymbol.Pls read instruction");
            }
        }
        if (!scanner.hasNextInt()) {

            key = scanner.nextInt();
            for (int i = key; i <= listOfBooks.size(); i++) {
                listOfBooks.get(i);
                listOfBooks.remove(i);
            }
        }
        out.println("<p>List was successfully removed<p>");
    }

    public List<Book> getListOfBooks() {
        return listOfBooks;
    }
}
