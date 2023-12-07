package org.example.Lab6.data;

import org.example.Lab6.inter.IBook;

/*Задание 1. Создайте класс Book, описывающий книгу. Каждая книга содержит: автора, название,
стоимость в рублях и год издания. Создайте для каждого атрибута книги закрытую переменную-член
класса соответствующего типа. Конструктор по умолчанию должен создавать книгу с параметрами:
«Не определено», «Не определено», 0.0, 0. Второй конструктор должен принимать все 4 параметра:
автора, название, стоимость в рублях и год издания. Напишите третий конструктор, который имеет 2
параметра: автора и год издания (Используйте вызов конструктора по умолчанию). Для каждого
атрибута создайте методы получения и установки значения.*/
public class Book implements IBook {
    private String author;
    private String name;
    private double price;
    private int year;

    public Book() {
        this.author = "Не определено";
        this.name = "Не определено";
        this.price = 0.0;
        this.year =0;
    }

    public Book(String author, String name, double price, int year) {
        this.author = author;
        this.name = name;
        this.price = price;
        this.year = year;
    }

    public Book(String author,int year) {
        this();
        this.author = author;
        this.year = year;
    }
    @Override
    public String getAuthor() {
        return author;
    }
    @Override
    public void setAuthor(String author) {
        this.author = author;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public int getYear() {
        return year;
    }
    @Override
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Book clonedBook = (Book) super.clone(); // Клонируем с помощью метода Object.clone()
        clonedBook.author = this.author != null ? new String(this.author) : null;
        clonedBook.name = this.name != null ? new String(this.name) : null;
        clonedBook.price = this.price;
        clonedBook.year = this.year;
        return clonedBook;
    }

    @Override
    public int hashCode() {
        int result = this.name != null ? this.author.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Книга: " +
                "автор='" + author + '\'' +
                ", название='" + name + '\'' +
                ", год издания=" + year +
                '}';
    }
}
