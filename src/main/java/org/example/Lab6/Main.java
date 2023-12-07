package org.example.Lab6;

import org.example.Lab6.data.ChildrenBook;
import org.example.Lab6.data.ScientificBook;
import org.example.Lab6.inter.IBook;
import org.example.Lab6.inter.IHall;
import org.example.Lab6.lib.ChildrenLibraryHall;
import org.example.Lab6.lib.LibraryChildren;
import org.example.Lab6.lib.ScientificLibraryHall;
import org.example.Lab6.list.MyLinkedList;

public class Main {
    public static void main(String[] args) {
            // Создание списка книг для детского зала
            MyLinkedList<IBook> childrenBooks = new MyLinkedList<>();
            childrenBooks.addByIndex(0,new ChildrenBook("Book 1", 15));
            childrenBooks.addByIndex(1,new ChildrenBook("Book 2", 12));
            childrenBooks.addByIndex(2,new ChildrenBook("Book 3", 10));

            // Создание детского зала
            IHall childrenHall = new ChildrenLibraryHall(childrenBooks, "Children's Hall");

            // Показ всех книг в детском зале
            childrenHall.showAllBookInHall();

            // Получение суммарной стоимости всех книг в детском зале
            double totalPriceChildren = childrenHall.getAllPriceFromBook();
            System.out.println("Суммарная стоимость всех книг в детском зале: " + totalPriceChildren);

            // Создание списка книг для научного зала
            MyLinkedList<IBook> scientificBooks = new MyLinkedList<>();
            scientificBooks.addByIndex(0,new ScientificBook("Book A", 20));
            scientificBooks.addByIndex(0,new ScientificBook("Book B", 18));
            scientificBooks.addByIndex(0,new ScientificBook("Book C", 25));

            // Создание научного зала
            IHall scientificHall = new ScientificLibraryHall(scientificBooks, "Scientific Hall");

            // Показ всех книг в научном зале
            scientificHall.showAllBookInHall();

            // Получение книги по индексу в научном зале
            int bookIndex = 1;
            IBook bookAtIndex = scientificHall.getBookByNumber(bookIndex);
            System.out.println("Книга по индексу " + bookIndex + " в научном зале: " + bookAtIndex);

            // Добавление новой книги в научный зал
            IBook newBook = new ScientificBook("Book D", 30);
            int newIndex = 2;
            scientificHall.addNumberOfBookByNumber(newIndex, newBook);

            // Удаление книги из научного зала по индексу
            int deleteIndex = 0;
            scientificHall.deleteBookByNumber(deleteIndex);

            // Вывод информации о научном зале
            System.out.println(scientificHall.toString());
    }
}

