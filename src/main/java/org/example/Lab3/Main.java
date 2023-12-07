package org.example.Lab3;


/*Задание 5. Объедините имеющиеся на данный момент типы в пакет libraries. Проверьте работу
классов, создав экземпляр библиотеки с различными произвольными значениями количества
книг по залам. Добавьте книги в залы, библиотеки; измените книгу; измените зал; удалите
книгу; для проверки каждого задания используйте методы распечатки списка залов и книг.
Выведите автора самой лучшей книги; выведите список названий книг по убыванию цены*/
public class Main {
    public static void main(String[] args) {
        ChildrenBook[] booksHall1 = new ChildrenBook[3];
        booksHall1[0] = new ChildrenBook("Автор1", "Книга1", 19.99, 2020, 6);
        booksHall1[1] = new ChildrenBook("Автор2", "Книга2", 14.99, 2019, 7);
        booksHall1[2] = new ChildrenBook("Автор3", "Книга3", 12.49, 2021, 5);
        ChildrenBook[] booksHall2 = new ChildrenBook[2];
        booksHall2[0] = new ChildrenBook("Автор4", "Книга4", 9.99, 2018, 8);
        booksHall2[1] = new ChildrenBook("Автор5", "Книга5", 7.99, 2017, 6);
        ChildrenLibraryHall hall1 = new ChildrenLibraryHall("Зал 1", booksHall1);
        ChildrenLibraryHall hall2 = new ChildrenLibraryHall("Зал 2", booksHall2);
        ChildrenLibrary library = new ChildrenLibrary(new ChildrenLibraryHall[] {hall1, hall2});
        System.out.println("Информация о библиотеке:");
        System.out.println("======================");
        for (int i = 0; i <library.getBookSortByPrice().length ; i++) {
            for (int j = 0; j < library.getChildrenLibraryHall()[i].getChildrenBook().length; j++) {
                System.out.println(library.getChildrenLibraryHall()[i].getChildrenBook()[j].getName());
            }
            System.out.println("======================");
        }
        System.out.println("Всего книг в библиотеке: " + library.numberOfBook());
        System.out.println("======================");
        System.out.println("Всего книг в Зале 1: " + hall1.getAllCountOfBook());
        System.out.println("======================");
        hall1.showAllBookInHall();
        System.out.println("======================");
        System.out.println("Общая стоимость книг в Зале 2: " + hall2.getAllPriceFromBook());
        System.out.println("======================");
        System.out.println("Книга в Зале 1 по индексу 1: " + hall1.getBookByNumber(1).orElse(null).getName());
        hall1.changeNumberOfBookByNumber(0, new ChildrenBook("Новый Автор", "Новая Книга", 15.99, 2023, 7));
        System.out.println("Самая дорогая книга в Зале 2: " + hall2.getBookWithBigPrice());
        library.getBookSortByPrice();
        System.out.println("Информация о библиотеке после сортировки:");
        System.out.println("======================");
        for (int i = 0; i <library.getBookSortByPrice().length ; i++) {
            for (int j = 0; j < library.getChildrenLibraryHall()[i].getChildrenBook().length; j++) {
                System.out.println(library.getChildrenLibraryHall()[i].getChildrenBook()[j].getName());
            }
            System.out.println("======================");
        }
        System.out.println("Самая дорогая книга в библиотеке: " + library.getBestBook());
    }
}