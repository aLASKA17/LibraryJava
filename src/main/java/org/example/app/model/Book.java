package org.example.app.model;

import java.io.Serial;
import java.io.Serializable;

public class Book implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private String title;
    private String author;
    private int year;
    private boolean available;
    private int id;
    private static int counter = 0;

    public static int setNextId() {
        counter++;
        return counter;
    }

    public Book(String title, String author, int year, boolean available) {
        this.id = Book.setNextId();
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = available;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("Название: %s, id: %d, автор: %s, год издания: %d, досутпность: %b", title, id, author, year, available);
    }
}
