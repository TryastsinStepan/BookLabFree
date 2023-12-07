package org.example.Lab4.library;

import org.example.Lab4.book.ScientificBook;
import org.example.Lab4.list.MyLinkedList;

/*Создайте класс ScientificLibraryHall, описывающий научный зал
библиотеки, который хранит динамический массив научных книг в виде
односвязного циклического списка с выделенной головой.
Зал имеет имя по разделу науки.
Нумерация книг сквозная, начинается с 0. Номер книги не хранится.
Создайте соответствующие переменные и методы чтения/установки
значений.
Создайте 2 конструктора:
1. принимающий имя зала и кол-во книг в зале;
2. принимающий имя зала и массив книг.
Создайте следующий методы для:
 получения количества книг в зале;
 выводящий на экран список названий всех книг в зале;
 получения общей стоимости всех книг в зале;
 получения книги по ее номеру в зале номеру (возвращает Optional с
соответствующим значением);
 изменения книги по ее номеру;
 добавления книги по номеру;
 удаления книги по номеру.
Создайте метод getBestBook(), возвращающий книгу с самой высокой
стоимостью.*/
public class ScientificLibraryHall {
    private String nameHall;
    private MyLinkedList<ScientificBook> bookList;
    private int countBook;

    public ScientificLibraryHall(MyLinkedList<ScientificBook> bookList, String nameHall) {
        this.bookList = bookList;
        this.nameHall = nameHall;
        this.countBook = bookList.size();
    }
    public ScientificLibraryHall(int countBook, String nameHall) {
    this.countBook = countBook;
    this.nameHall = nameHall;
        bookList = new MyLinkedList<>();
        for (int i = 0; i < countBook; i++) {
            bookList.addByIndex(i,new ScientificBook("?",0));
        }
    }
    public void setCountBook(int countBook) {
        this.countBook = countBook;
    }

    //1
    public int getCountBook() {
        return bookList.size();
    }
    //2
    public void showAllBookInHall(){
        for(int i = 0;i<bookList.size();i++){
            System.out.println("Название книги: "+" "+ bookList.getByIndex(i));
        }
    }
    //3
    public double getAllPriceFromBook(){
        double total = 0;
        for(int i = 0; i < bookList.size(); i++){
            ScientificBook currentBook = (ScientificBook) bookList.getByIndex(i).data;
            total += currentBook.getPrice(); // Assuming there's a getPrice() method in ScientificBook
        }
        return total;
    }
    //4
    public ScientificBook getBookByNumber(int index){
        if (index < 0 || index >= bookList.size()) {
            throw new IllegalArgumentException("Неверный индекс");
        }
        ScientificBook currentBook = (ScientificBook) bookList.getByIndex(index).data;
        return currentBook;
    }
    //5
    public void changeNumberOfBookByNumber(int index, ScientificBook scientificBookForChange){
        if ((index < 0 || index >= bookList.size())||scientificBookForChange==null) {
            throw new IllegalArgumentException("Неверный индекс или объект равен null");
        }
        bookList.deleteByIndex(index);
        bookList.addByIndex(index,scientificBookForChange);
    }
    //6
    public void addNumberOfBookByNumber(int index,ScientificBook scientificBookForChange){
        if ((index < 0 || index > bookList.size())||scientificBookForChange==null) {
            throw new IllegalArgumentException("Неверный индекс или объект равен null");
        }
        bookList.addByIndex(index,scientificBookForChange);
    }
    //7
    public void deleteBookByNumber(int index) {
        if (index < 0 || index > bookList.size()) {
            throw new IllegalArgumentException("Invalid index");
        }
        bookList.deleteByIndex(index);
    }
    //8
    public double getBookWithBigPrice(){
        if (bookList.size() == 0) {
            throw new IllegalArgumentException("Массив книг пуст");
        }
        double totalPrice = Double.MIN_VALUE;
        for (int i = 0; i < bookList.size(); i++) {
            ScientificBook scientificBook = (ScientificBook)bookList.getByIndex(i).data;
            if(scientificBook.getPrice()>totalPrice){
                totalPrice = scientificBook.getPrice();
            }
        }
        return totalPrice;
    }

    public String getNameHall() {
        return nameHall;
    }


    @Override
    public String toString() {
        return "ScientificLibraryHall{" +
                "nameHall='" + nameHall + '\'' +
                ", bookList=" + bookList +
                ", countBook=" + countBook +
                '}';
    }
}
