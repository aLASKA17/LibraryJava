package org.example.app.model;

import org.example.app.exception.BookIsNotAvalibaleException;
import java.util.List;

public class User implements UserAction {


    @Override
    public synchronized void reserveBook(List<Book> bookList, int index) throws BookIsNotAvalibaleException {
        if (!bookList.get(index).getAvailable()) {
            throw new BookIsNotAvalibaleException("Книга занята!");
        } else {
            bookList.get(index).setAvailable(false);
        }
    }

    @Override
    public void returnBook(List<Book> bookList, int index) throws BookIsNotAvalibaleException {
        if (bookList.get(index).getAvailable()) {
            throw new BookIsNotAvalibaleException("Книга уже возвращена!");
        } else {
            bookList.get(index).setAvailable(true);
        }
    }
}
