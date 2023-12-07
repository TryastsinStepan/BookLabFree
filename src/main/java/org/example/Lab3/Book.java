package org.example.Lab3;
/*Задание 1. Создайте класс Book, описывающий книгу. Каждая книга содержит: автора, название,
стоимость в рублях и год издания. Создайте для каждого атрибута книги закрытую переменную-член
класса соответствующего типа. Конструктор по умолчанию должен создавать книгу с параметрами:
«Не определено», «Не определено», 0.0, 0. Второй конструктор должен принимать все 4 параметра:
автора, название, стоимость в рублях и год издания. Напишите третий конструктор, который имеет 2
параметра: автора и год издания (Используйте вызов конструктора по умолчанию). Для каждого
атрибута создайте методы получения и установки значения.*/
public class Book {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", coast=" + price +
                ", year=" + year +
                '}';
    }
}
