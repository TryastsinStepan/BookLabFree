package org.example.Lab6.inter;


import org.example.Lab6.list.MyDoubleList;

public interface ILibrary extends Cloneable{
    int getNumberOfHalls();
    int numberOfBook();
    double getAllPriceFromBook();
    MyDoubleList<IHall> getScientificLibraryHall();
    IHall getLibraryHallByIndex(int index);
    IBook getBookLibraryHallByIndex(int index);
    MyDoubleList<IHall> getBookSortByPrice();
    void showAllNameOfHallByCount();
    void changeHallOnDifferentByNumber(int hallNumber, IHall newHall);
   void changeBookOnDifferentByNumber(int number, IBook book);
    void addBookByNumber(int number, IBook book);
    void deleteBookByNumber(int number);
    double getBestBook();
    Object clone() throws CloneNotSupportedException;
}
