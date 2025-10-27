package org.example.app.model;

import org.example.app.App;
import org.example.app.exception.BookIsNotAvalibaleException;
import org.example.app.exception.BookNotFoundException;
import static java.lang.System.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library implements Runnable{
    User user = new User();
    private final List<Book> bookList = new ArrayList<>();
    private int value;
    Scanner scanner = new Scanner(in);

    public Library(int value) {
        this.value = value;
    }

    public Library(){}

    public void addBook() {
        out.print("Назвние книги: ");
        String title = scanner.nextLine();
        out.print("\nАвтор книги: ");
        String author = scanner.nextLine();
        out.print("\nГод издания книги: ");
        int year = scanner.nextInt();
        bookList.add(new Book(title, author, year, true));
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void printInfoBook() {
        for (Book book : bookList) {
            out.println(book.toString());
        }
    }

    public List<Book> searchByAuthor(String author) throws BookNotFoundException {
        List<Book> otherList = new ArrayList<>();
        bookList.stream()
                .filter(book -> book.getAuthor().toUpperCase().trim().equals(author.toUpperCase().trim()))
                .forEach(book -> {
                    out.println(book);
                    otherList.add(book);
                });
        if (otherList.isEmpty()) {
            throw new BookNotFoundException("Книга не найдена!");
        }
        return otherList;
    }

    public List<Book> searchByYear(int year) throws BookNotFoundException {
        List<Book> otherList = new ArrayList<>();
        bookList.stream()
                .filter(book -> book.getYear() == year)
                .forEach(book -> {
                    out.println(book);
                    otherList.add(book);
                });
        if (otherList.isEmpty()) {
            throw new BookNotFoundException("Книга не найдена!");
        }
        return otherList;
    }

    public synchronized List<Book> searchByTitle(String title) throws BookNotFoundException{
        List<Book> otherList = new ArrayList<>();
        bookList.stream()
                .filter(book -> book.getTitle().toUpperCase().trim().equals(title.toUpperCase().trim()))
                .forEach(book -> {
                    out.println(book);
                    otherList.add(book);
                });
        if (otherList.isEmpty()) {
            throw  new BookNotFoundException("Книга не найдена!");
        }
        return otherList;
    }


    @Override
    public void run() {
        List<Book> list = getBookList();

        switch (value) {
            case 0: {
                try {
                    user.reserveBook(list, 0);
                } catch (BookIsNotAvalibaleException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            case 1: {
                try {
                    user.returnBook(list, 1);
                } catch (BookIsNotAvalibaleException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            default: out.println("Такого пункта нет! ");
            break;
        }

    }
}

