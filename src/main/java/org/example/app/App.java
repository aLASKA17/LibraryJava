package org.example.app;

import static java.lang.System.*;
import org.example.app.model.Book;
import org.example.app.model.Library;
import org.example.app.model.User;

import java.util.List;
import java.util.Scanner;

public class App {

    Scanner scanner = new Scanner(in);


    public void menuUI() {
        Library library = new Library();
        User user = new User();
        DataController dataController = new DataController();
        out.println("Меню: ");
        out.println("-------------------------------");
        out.println("1) Добавить книгу");
        out.println("2) Вывести список книг");
        out.println("3) Сериализовать список");
        out.println("4) Десериализовать список");
        out.println("5) Сдать/Вернуть книгу");
        out.println("6) Выход");
        out.println("-------------------------------");
        out.print("Выберите действие из меню");
        int point = scanner.nextInt();
        switch (point) {
            case 1: {
                library.addBook();
                break;
            }
            case 2: {
                printListBookMenu();
                break;
            }
            case 3: {
                dataController.serilizableData(library.getBookList());
                break;
            }
            case 4: {
                dataController.deserilizableData();
                break;
            }
            case 5: {
                reverseReturnBookMenu();
                break;
            }
            case 6: {
                exit(0);
                break;
            }
            default: {
                out.println("Данного пункта нет в меню!");
            }
        }
    }

    public void reverseReturnBookMenu() {
    }


    public void printListBookMenu() {

    }

    public void run() throws InterruptedException {
        menuUI();
    }
}
