package org.example.app.model;

import org.example.app.exception.BookIsNotAvalibaleException;

import java.util.List;

public interface UserAction {

    void reserveBook(List<Book> bookList, int index) throws BookIsNotAvalibaleException;

    void returnBook(List<Book> bookList, int index) throws BookIsNotAvalibaleException;
}
