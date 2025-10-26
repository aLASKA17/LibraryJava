import org.example.app.exception.BookIsNotAvalibaleException;
import org.example.app.exception.BookNotFoundException;
import org.example.app.model.Book;
import org.example.app.model.Library;
import org.example.app.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestSearch {

    public Library init() {
        Book book1 = new Book("a1asak", "srayghrsdfh", 2131, true);
        Book book2 = new Book("seygtdrsfh", "sddgtdafshgfd", 2131, false);
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

    @Test
    public void testSearchByYear() throws BookNotFoundException {

        Library library = init();
        List<Book> bookList = library.searchByYear(2131);

        List<Book> otherList = new ArrayList<>();
        init().getBookList().stream()
                .filter(book -> book.getYear() == 2131)
                .forEach(otherList::add);

        Assertions.assertEquals(bookList, otherList);
    }

    @Test
    public void testReturnBook() throws BookIsNotAvalibaleException {

        List<Book> bookList = init().getBookList();
        User user = new User();

        user.returnBook(bookList, 1);
        Assertions.assertEquals(bookList.get(1).getAvailable(),true);
    }

    @Test
    public void testReserveBook() throws BookIsNotAvalibaleException {
        List<Book> bookList = init().getBookList();
        User user = new User();

        user.reserveBook(bookList, 0);
        Assertions.assertEquals(bookList.get(0).getAvailable(),false);
    }

}
