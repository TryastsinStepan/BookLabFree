package org.example.Lab5.library;

import org.example.Lab5.exception.BookIndexOutOfBoundsException;
import org.example.Lab5.exception.HallIndexOutOfBoundsException;
import org.example.Lab5.inter.IBook;
import org.example.Lab5.inter.IHall;
import org.example.Lab5.inter.ILibrary;
import org.example.Lab5.list.MyDoubleList;

public class ScientificLibrary implements ILibrary {
    private MyDoubleList<IHall> listHall;
    private int countHall = 0;

    public ScientificLibrary(int countHall, int countBook[]) {
        this.countHall = countHall;
        listHall = new MyDoubleList<>();
        for (int i = 0; i < countHall; i++) {
            for (int j = 0; j <= countBook[i]; j++) {
                listHall.addByIndex(i, (IHall) new ChildrenLibraryHall(j, "?"));
            }
        }
    }

    public ScientificLibrary(MyDoubleList<IHall> hall) {
        this.listHall = hall;
    }

    @Override
    public int getNumberOfHalls() {
        return this.countHall;
    }

    @Override
    public int numberOfBook() {
        int totalBook = 0;
        for (int i = 0; i < countHall; i++) {
            totalBook +=listHall.getByIndex(i).data.getCountBook() ;
        }
        return totalBook;
    }

    @Override
    public double getAllPriceFromBook() {
        int totalBook = 0;
        for (int i = 0; i < countHall; i++) {
            totalBook += listHall.getByIndex(i).data.getAllPriceFromBook();
        }
        return totalBook;
    }

    @Override
    public MyDoubleList<IHall> getScientificLibraryHall() {
        return listHall;
    }

    @Override
    public IHall getLibraryHallByIndex(int index) {
        return listHall.getByIndex(index).data;
    }

    @Override
    public IBook getBookLibraryHallByIndex(int index) {
        for (int i = 0; i < countHall; i++) {
            for (int j = 0; j < listHall.getByIndex(i).data.getCountBook(); j++) {
                IBook scientificBook = listHall.getByIndex(i).data.getBookByNumber(index);
                if (scientificBook!=null) {
                    return scientificBook;
                }
            }
        }
        return null;
    }

    @Override
    public MyDoubleList<IHall> getBookSortByPrice() {
        for (int i = 0; i < countHall; i++) {
            MyDoubleList.Node<IHall> hallOptional = listHall.getByIndex(i);
            if (hallOptional!=null) {
                IHall hall = hallOptional.data;
                boolean swapped;
                do {
                    swapped = false;
                    for (int j = 0; j < hall.getSize(); j++) {
                        IBook book1Optional =hall.getBookByNumber(j);
                        IBook book2Optional = hall.getBookByNumber(j + 1);

                        if (book1Optional!=null && book2Optional!=null) {
                            IBook book1 = book1Optional;
                            IBook book2 = book2Optional;

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
        return listHall;
    }

    @Override
    public void showAllNameOfHallByCount() {
        for (int i = 0; i < countHall; i++) {
            System.out.println("Количество книг : " + listHall.getByIndex(i).data.getCountBook() + " Название зала: " + listHall.getByIndex(i).data.getName());
        }
    }

    @Override
    public void changeHallOnDifferentByNumber(int hallNumber, IHall newHall) {
        if ((hallNumber < 0 || countHall > hallNumber) || (newHall == null)) {
            throw new HallIndexOutOfBoundsException("Неверный индекс");
        }
        listHall.getByIndex(hallNumber).data = newHall;
    }

    @Override
    public void changeBookOnDifferentByNumber(int number, IBook book) {
        if ((number < 0 || countHall > number) || (book == null)) {
            throw new HallIndexOutOfBoundsException("Неверный индекс");
        }
        listHall.getByIndex(number).data.changeNumberOfBookByNumber(number, book);
    }

    @Override
    public void addBookByNumber(int number, IBook book) {
        if ((number < 0 || number < countHall) || book == null) {
            throw new BookIndexOutOfBoundsException("Неверный индекс");
        }
        for (int i = 0; i < countHall; i++) {
            listHall.getByIndex(i).data.addNumberOfBookByNumber(number, book);
        }
    }

    @Override
    public void deleteBookByNumber(int number) {
        if (number < 0 || number < countHall) {
            throw new BookIndexOutOfBoundsException("Неверный индекс");
        }
        for (int i = 0; i < countHall; i++) {
            listHall.getByIndex(i).data.deleteBookByNumber(number);
        }
    }

    @Override
    public double getBestBook() {
        if (countHall == 0) {
            throw new IllegalArgumentException("Empty");
        }
        double maxPrice = Double.MIN_VALUE;
        for (int i = 0; i < countHall; i++) {
            double hallMaxPrice = listHall.getByIndex(i).data.getBookWithBigPrice();
            if (hallMaxPrice > maxPrice) {
                maxPrice = hallMaxPrice;
            }
        }
        return maxPrice;
    }
}
