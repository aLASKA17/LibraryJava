package org.example.app;


import org.example.app.model.Book;
import org.example.app.model.Library;
import java.util.List;

public class App {

    public Library init() {
        Book book1 = new Book("a1asak", "srayghrsdfh", 2131, true);
        Book book2 = new Book("seygtdrsfh", "sddgtdafshgfd", 325, false);
        Book book3 = new Book("vfmrk234", "kdjsfhsdkjf", 457, true);
        Book book4 = new Book("qwpzxcnm", "pleirutyv", 879, false);
        Book book5 = new Book("zxcvbnml", "asdfghjkl", 1523, true);
        Book book6 = new Book("plmoknij", "qazwsxedc", 678, false);
        Book book7 = new Book("uytrewqas", "dfghjkpoi", 499, true);

        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        library.addBook(book7);

        return library;
    }


    public void run() throws InterruptedException {

        List<Book> bookList = init().getBookList();
        Library library1 = new Library(0);
        Library library2 = new Library(1);

        Thread thread1 = new Thread(library1);
        Thread thread2 = new Thread(library2);

        thread1.start();
        thread1.join();
        thread2.start();

        DataController dataController = new DataController();
        dataController.serilizableData(bookList);
        dataController.deserilizableData();
    }

}
