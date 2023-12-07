package org.example.Lab5.book;

import org.example.Lab3.Book;
import org.example.Lab5.inter.IBook;

/*Задание 2. Создайте класс ChildrenBook, описывающий книгу для детей, расширяющий класс Book.
Книга для детей имеет еще один параметр – минимальный возраст, с которого можно читать книгу (в
годах). Создайте соответствующую переменную, методы получения и установки значения. Создайте 3
конструктора: по умолчанию (мин. возраст = 0), с двумя параметрами (как в задании 1) и с полным
списком параметров. При разработке конструкторов используйте вызовы конструкторов суперкласса.
Создайте класс ScientificBook, описывающий научную книгу, расширяющий класс Book. Научная
книга имеет дополнительный параметр – индекс цитируемости (вещественное число). Создайте
соответствующую переменную, методы получения и установки значения. Создайте 3 конструктора: по
умолчанию (индекс цитирования = 0.0), с двумя параметрами (как в задании 1) и с полным списком
параметров. При разработке конструкторов используйте вызовы конструкторов суперкласса*/
public class ChildrenBook extends Book  implements IBook {
    private int acceptableAge;

    public ChildrenBook() {
        super();
        this.acceptableAge = 0;
    }
    public ChildrenBook(String author, int year) {
        super(author, year);
        this.acceptableAge = 0;
    }

    public ChildrenBook(String author, String name, double coast, int year,int acceptableAge) {
        super(author, name, coast, year);
        this.acceptableAge = acceptableAge;
    }
    public ChildrenBook(String author, String name, double price, int year) {
        super(author, name, price, year);
    }
    public int getAcceptableAge() {
        return acceptableAge;
    }

    public void setAcceptableAge(int acceptableAge) {
        this.acceptableAge = acceptableAge;
    }

    @Override
    public String getAuthor() {
        return super.getAuthor();
    }

    @Override
    public void setAuthor(String author) {
        super.setAuthor(author);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }

    @Override
    public int getYear() {
        return super.getYear();
    }

    @Override
    public void setYear(int year) {
        super.setYear(year);
    }

    @Override
    public String toString() {
        return "ChildrenBook{" +
                "acceptableAge=" + acceptableAge +
                '}';
    }
}
