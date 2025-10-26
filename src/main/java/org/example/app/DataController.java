package org.example.app;

import org.example.app.model.Book;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;

public class DataController {

    public void serilizableData(List<Book> bookList)  {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("library.ser"))) {
            oos.writeObject(bookList);
            out.println("Коллекция успешно сериализована в library.ser");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deserilizableData() {
        List<Book> deserializationBookList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("library.ser"))) {
            deserializationBookList = (List<Book>) ois.readObject();
            out.println("Коллекция успешно десериализована в library.ser");
            for (Book book : deserializationBookList) {
                out.println(book.toString());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
