package org.example.Lab3;

import java.util.Arrays;
import java.util.Optional;

/*Задание 4. Создайте класс ChildrenLibrary, описывающий детскую библиотеку и содержащий
массив залов. Нумерация залов в библиотеке сквозная, начинается с 0. Нумерация книг в
библиотеке сквозная, начинается с 0 нулевого зала. Создайте 2 конструктора:
 принимающий количество залов и массив количеств книг по залам;
 принимающий массив залов. Создайте методы получения:
 количества залов;
 количества книг;
 массива залов библиотеки;
 объекта зала по его номеру в библиотеке;
 объекта книги по ее номеру в библиотеке;
 отсортированного по убыванию цены массива книг библиотеки. Создайте еще методы:
 выводящий на экран список названий всех залов с количеством книг в них;
 замена зала по его номеру на другой (номер зала — первый параметр, ссылка на новый зал
передается вторым параметром);
 замена книги по ее номеру на другую (номер книги — первый параметр, ссылка на другую
книгу передается вторым параметром);
 добавление книги в библиотеку по ее номеру в библиотеке; номер книги — первый
параметр, ссылка на новую книгу – второй параметр метода; количество залов не
увеличивается;
 удаление книги по ее номеру в библиотеке;
 метод getBestBook() получение книги с самой большой ценой в библиотеке.*/
public class ChildrenLibrary {
    private ChildrenLibraryHall[] childrenLibraryHall;

    public ChildrenLibrary(int numberOfHalls, int[] numBooksInHalls) {
        this.childrenLibraryHall = new ChildrenLibraryHall[numberOfHalls];
        for (int i = 0; i < numberOfHalls; i++) {
            childrenLibraryHall[i].setCountBook(numBooksInHalls[i]);
        }
    }

    public ChildrenLibrary(ChildrenLibraryHall[] childrenLibraryHall) {
        this.childrenLibraryHall = childrenLibraryHall;
    }

    public int getNumberOfHalls() {
        return childrenLibraryHall.length;
    }

    //1.1
    public int numberOfBook() {
        int totalBook = 0;
        for (int i = 0; i < childrenLibraryHall.length; i++) {
            totalBook += childrenLibraryHall[i].getCountBook();
        }
        return totalBook;
    }

    //1.2
    public ChildrenLibraryHall[] getChildrenLibraryHall() {
        return childrenLibraryHall;
    }

    //1.3
    public ChildrenLibraryHall getChildrenLibraryHallByIndex(int index) {
        return childrenLibraryHall[index];
    }

    //1.4
    public Optional<ChildrenBook> getBookChildrenLibraryHallByIndex(int index) {
        for (ChildrenLibraryHall halls : childrenLibraryHall) {
            Optional<ChildrenBook> childrenBook = halls.getBookByNumber(index);
            return childrenBook;
        }
        return null;
    }

    //1.5
    public ChildrenLibraryHall[] getBookSortByPrice() {
        for (ChildrenLibraryHall libraryHall : childrenLibraryHall) {
            ChildrenBook[] books = libraryHall.getChildrenBook();

            if (books != null && books.length > 1) {
                boolean swapped;
                do {
                    swapped = false;
                    for (int i = 0; i < books.length - 1; i++) {
                        if (books[i].getPrice() > books[i + 1].getPrice()) {
                            ChildrenBook temp = books[i];
                            books[i] = books[i + 1];
                            books[i + 1] = temp;
                            swapped = true;
                        }
                    }
                } while (swapped);
            }
        }
        return childrenLibraryHall;
    }
   //2.1
    public void showAllNameOfHallByCount() {
        for (ChildrenLibraryHall libraryHall : childrenLibraryHall) {
            System.out.println("Количество книг: "+" "+libraryHall.getCountBook() + "Название зала: "+" "+libraryHall.getNameHall());
        }
    }
    //2.2
    public void changeHallOnDifferentByNumber(int hallNumber, ChildrenLibraryHall newHall){
        if ((hallNumber >= 0 && hallNumber < childrenLibraryHall.length)||(newHall == null)) {
            throw new IllegalArgumentException("Неверный индекс");
        }
        childrenLibraryHall[hallNumber] = newHall;
    }
    //2.3
    public void changeBookOnDifferentByNumber(int number, ChildrenBook book){
        if ((number >= 0 && number < childrenLibraryHall.length)||book == null) {
            throw new IllegalArgumentException("Неверный индекс");
        }
        for (ChildrenLibraryHall libraryHall : childrenLibraryHall){
            libraryHall.changeNumberOfBookByNumber(number,book);
        }
    }
    //2.4
    public void addBookByNumber(int number, ChildrenBook book){
        if ((number >= 0 && number < childrenLibraryHall.length)||book == null) {
            throw new IllegalArgumentException("Неверный индекс или книга");
        }
        for (ChildrenLibraryHall libraryHall : childrenLibraryHall){
            libraryHall.addNumberOfBookByNumber(number,book);
        }
    }
    //2.5
    public void deleteBookByNumber(int number){
        if ((number >= 0 && number < childrenLibraryHall.length)) {
            throw new IllegalArgumentException("Неверный индекс или книга");
        }
        for (ChildrenLibraryHall libraryHall : childrenLibraryHall){
            libraryHall.deleteBookByNumber(number);
        }
    }
    //2.6
    public double getBestBook() {
        if (childrenLibraryHall.length == 0) {
            throw new IllegalArgumentException("Empty");
        }
        double maxPrice = Double.MIN_VALUE;
        for (ChildrenLibraryHall libraryHall : childrenLibraryHall) {
            double hallMaxPrice = libraryHall.getBookWithBigPrice();
            if (hallMaxPrice > maxPrice) {
                maxPrice = hallMaxPrice;
            }
        }
        return maxPrice;
    }
    @Override
    public String toString() {
        return "ChildrenLibrary{" +
                "childrenLibraryHall=" + Arrays.toString(childrenLibraryHall) +
                '}';
    }
}
