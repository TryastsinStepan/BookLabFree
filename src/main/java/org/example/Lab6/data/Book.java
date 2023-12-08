package org.example.Lab6.data;

import org.example.Lab6.exception.InvalidBookPriceException;
import org.example.Lab6.inter.IBook;

import java.io.Serializable;

/*Задание 1. Создайте класс Book, описывающий книгу. Каждая книга содержит: автора, название,
стоимость в рублях и год издания. Создайте для каждого атрибута книги закрытую переменную-член
класса соответствующего типа. Конструктор по умолчанию должен создавать книгу с параметрами:
«Не определено», «Не определено», 0.0, 0. Второй конструктор должен принимать все 4 параметра:
автора, название, стоимость в рублях и год издания. Напишите третий конструктор, который имеет 2
параметра: автора и год издания (Используйте вызов конструктора по умолчанию). Для каждого
атрибута создайте методы получения и установки значения.*/
public class Book implements IBook, Serializable {
    private String title;
    private String author;
    private int year;
    private double price;

    public Book() {
        this.title = "Не определено";
        this.author = "Не определено";
        this.year = 0;
        this.price = 0.0f;
    }

    public Book(String title, String author, int publishingYear, float price) {
        this.title = title;
        this.author = author;
        this.year = publishingYear;
        this.price = price;
    }

    public Book(String author, int publishingYear) {
        this();
        this.author = author;
        this.year = publishingYear;
    }

    @Override
    public String getAuthor() {
        return this.author;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getName() {
        return this.title;
    }

    @Override
    public void setName(String name) {
        this.title = name;
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
        return this.year;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }
}