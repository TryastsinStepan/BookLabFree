package org.example.Lab4.library;

import org.example.Lab4.book.ScientificBook;
import org.example.Lab4.list.MyDoubleList;

import java.util.Optional;

public class ScientificLibrary {
    private MyDoubleList<ScientificLibraryHall> hall;
    private int countHall;

    public ScientificLibrary(int countHall, int countBook[]) {
        this.countHall = countHall;
        hall = new MyDoubleList<>();
        for (int i = 0; i < countHall; i++) {
            for (int j = 0; j < countBook[i]; j++) {
                hall.addByIndex(i, new ScientificLibraryHall(j, "?"));
            }
        }
    }

    public ScientificLibrary(MyDoubleList<ScientificLibraryHall> hall) {
        this.hall = hall;
        this.countHall++;
    }

    public int getNumberOfHalls() {
        return countHall;
    }

    //1.1
    public int numberOfBook() {
        int totalBook = 0;
        for (int i = 0; i < countHall; i++) {
            totalBook += hall.getByIndex(i).data.getCountBook();
        }
        return totalBook;
    }

    //1.2
    public double getAllPriceFromBook() {
        int totalBook = 0;
        for (int i = 0; i < countHall; i++) {
            totalBook += hall.getByIndex(i).data.getAllPriceFromBook();
        }
        return totalBook;
    }

    public MyDoubleList<ScientificLibraryHall> getScientificLibraryHall() {
        return hall;
    }

    //1.3
    public ScientificLibraryHall getScientificLibraryHallByIndex(int index) {
        return hall.getByIndex(index).data;
    }

    //1.4
    public ScientificBook getBookScientificLibraryHallByIndex(int index) {
        for (int i = 0; i < countHall; i++) {
            for (int j = 0; j < hall.getByIndex(i).data.getCountBook(); j++) {
                ScientificBook scientificBook = hall.getByIndex(i).data.getBookByNumber(index);
                if (scientificBook!=null) {
                    return scientificBook;
                }
            }

        }
        return null;
    }

    //1.5
    public MyDoubleList<ScientificLibraryHall> getBookSortByPrice() {
        for (int i = 0; i < countHall; i++) {
            MyDoubleList.Node<ScientificLibraryHall> hallOptional = hall.getByIndex(i);
            if (hallOptional!=null) {
                ScientificLibraryHall hall = hallOptional.data;
                boolean swapped;
                do {
                    swapped = false;
                    for (int j = 0; j < hall.getCountBook() - 1; j++) {
                        Optional<ScientificBook> book1Optional = Optional.ofNullable(hall.getBookByNumber(j));
                        Optional<ScientificBook> book2Optional = Optional.ofNullable(hall.getBookByNumber(j + 1));

                        if (book1Optional.isPresent() && book2Optional.isPresent()) {
                            ScientificBook book1 = book1Optional.get();
                            ScientificBook book2 = book2Optional.get();

                            if (book1.getPrice() > book2.getPrice()) {
                                hall.changeNumberOfBookByNumber(j, book2);
                                hall.changeNumberOfBookByNumber(j + 1, book1);
                                swapped = true;
                            }
                        }
                    }
                } while (swapped);
            }
        }
        return hall;
    }

    //2.1
    public void showAllNameOfHallByCount() {
        for (int i = 0; i < countHall; i++) {
            System.out.println("Количество книг : " + hall.getByIndex(i).data.getCountBook() + " Название зала: " + hall.getByIndex(i).data.getNameHall());
        }
    }

    //2.2
    public void changeHallOnDifferentByNumber(int hallNumber, ScientificLibraryHall newHall) {
        if ((hallNumber >= 0 && hallNumber > hallNumber) || (newHall == null)) {
            throw new IllegalArgumentException("Неверный индекс");
        }
        hall.getByIndex(hallNumber).data = newHall;
    }

    //2.3
    public void changeBookOnDifferentByNumber(int number, ScientificBook book) {
        if ((number >= 0 && number > countHall)) {
            throw new IllegalArgumentException("Неверный индекс");
        }
        hall.getByIndex(number).data.changeNumberOfBookByNumber(number, book);
    }

    //2.4
    public void addBookByNumber(int number, ScientificBook book) {
        if ((number >= 0 && number > countHall) || book == null) {
            throw new IllegalArgumentException("Неверный индекс");
        }
        for (int i = 0; i < countHall; i++) {
            hall.getByIndex(i).data.addNumberOfBookByNumber(number, book);
        }
    }

    //2.5
    public void deleteBookByNumber(int number) {
        if ((number <= 0 )) {
            throw new IllegalArgumentException("Неверный индекс");
        }
        for (int i = 0; i < countHall; i++) {
            hall.getByIndex(i).data.deleteBookByNumber(number);
        }
    }

    //2.6
    public double getBestBook() {
        if (countHall == 0) {
            throw new IllegalArgumentException("Empty");
        }
        double maxPrice = Double.MIN_VALUE;
        for (int i = 0; i < countHall; i++) {
            double hallMaxPrice = hall.getByIndex(i).data.getBookWithBigPrice();
            if (hallMaxPrice > maxPrice) {
                maxPrice = hallMaxPrice;
            }
        }
        return maxPrice;
    }
}

