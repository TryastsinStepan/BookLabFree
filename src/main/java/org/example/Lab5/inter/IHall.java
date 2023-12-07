package org.example.Lab5.inter;

import org.example.Lab5.inter.IBook;

public interface IHall {
    void showAllBookInHall();
    double getAllPriceFromBook();
    IBook getBookByNumber(int index);
    void changeNumberOfBookByNumber(int index, IBook book);
    void addNumberOfBookByNumber(int index,IBook book);
    double getBookWithBigPrice();
    void deleteBookByNumber(int index);
    int getSize();
    int getCountBook();
    String getName();
}
