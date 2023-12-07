package org.example.Lab6.lib;



import org.example.Lab6.exception.BookIndexOutOfBoundsException;
import org.example.Lab6.exception.HallIndexOutOfBoundsException;
import org.example.Lab6.inter.IBook;
import org.example.Lab6.inter.IHall;
import org.example.Lab6.inter.ILibrary;
import org.example.Lab6.list.MyDoubleList;

public class LibraryChildren implements ILibrary {
    private MyDoubleList<IHall> listHall;
    private IHall arrayHall[];
    private int countHall = 0;

    public LibraryChildren(int countHall, int countBook[]) {
        this.countHall = countHall;
        listHall = new MyDoubleList<>();
        arrayHall = new IHall[countHall];
        for (int i = 0; i < countHall; i++) {
            for (int j = 0; j < countBook[i]; j++) {
                listHall.addByIndex(i, (IHall) new ChildrenLibraryHall(j, "?"));
                arrayHall[i] = new ChildrenLibraryHall(j,"?");
            }
        }
    }

    public LibraryChildren(MyDoubleList<IHall> hall) {
        this.listHall = hall;
    }

    @Override
    public int getNumberOfHalls() {
        return countHall;
    }

    @Override
    public int numberOfBook() {
        int totalBook = 0;
        for (int i = 0; i < countHall; i++) {
            totalBook += listHall.getByIndex(i).data.getCountBook();
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
            if (hallOptional != null && hallOptional.data != null) {
                IHall hall = hallOptional.data;
                boolean swapped;
                do {
                    swapped = false;
                    for (int j = 0; j < hall.getCountBook(); j++) { // Изменение условия цикла
                        IBook book1Optional = hall.getBookByNumber(j);
                        IBook book2Optional = hall.getBookByNumber(j + 1);

                        if (book1Optional != null && book2Optional != null) {
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
            System.out.println( "Номер холла: " + listHall.getByIndex(i).data.getSize()  + " Название зала: " + listHall.getByIndex(i).data.getName());
        }
    }

    @Override
    public void changeHallOnDifferentByNumber(int hallNumber, IHall newHall) {
        if ((hallNumber < 0 || countHall < hallNumber) || (newHall == null)) {
            throw new HallIndexOutOfBoundsException("Неверный индекс");
        }
        listHall.getByIndex(hallNumber).data = newHall;
    }

    @Override
    public void changeBookOnDifferentByNumber(int number, IBook book) {
        if ((number < 0 || countHall < number) || (book == null)) {
            throw new HallIndexOutOfBoundsException("Неверный индекс");
        }
        listHall.getByIndex(number).data.changeNumberOfBookByNumber(number, book);
    }

    @Override
    public void addBookByNumber(int number, IBook book) {
        if ((number < 0 || countHall < number) || book == null) {
            throw new BookIndexOutOfBoundsException("Неверный индекс");
        }
        for (int i = 0; i < countHall; i++) {
            listHall.getByIndex(i).data.addNumberOfBookByNumber(number, book);
        }
        listHall.getByIndex(number).data.setCountHall(listHall.getByIndex(number).data.getCountBook()+1);
    }

    @Override
    public void deleteBookByNumber(int number) {
        if (number < 0 || countHall < number) {
            throw new BookIndexOutOfBoundsException("Неверный индекс");
        }
        for (int i = 0; i < countHall; i++) {
            listHall.getByIndex(i).data.deleteBookByNumber(number);
        }
        listHall.getByIndex(number).data.setCountHall(listHall.getByIndex(number).data.getCountBook()-1);
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
    @Override
    public Object clone() throws CloneNotSupportedException {
        LibraryChildren clonedLibrary = (LibraryChildren) super.clone(); // Cloning the object using Object's clone method

        MyDoubleList<IHall> clonedListOfHalls = new MyDoubleList<>();
        for (int i = 0; i < countHall; i++) {
            MyDoubleList.Node<IHall> node = listHall.getByIndex(i);
            if (node != null && node.data != null) {
                IHall clonedHall = (IHall) node.data.clone();
                clonedListOfHalls.addByIndex(i, clonedHall);
            }
        }

        clonedLibrary.listHall = clonedListOfHalls; // Setting the cloned list of halls

        return clonedLibrary; // Returning the cloned LibraryChildren object
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        LibraryChildren library = (LibraryChildren) object;
        return getNumberOfHalls() == library.getNumberOfHalls() && getScientificLibraryHall().equals(library);
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + countHall;

        for (int i = 0; i < countHall; i++) {
            result = prime * result + listHall.getByIndex(i).data.hashCode();
        }

        return result;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Научная библиотека \n");
        sb.append("Количество залов: '").append(countHall).append("'\n");
        sb.append("Информация о зале:\n");

        for (int i = 0; i < countHall; i++) {
            sb.append("Зал ").append(i + 1).append(": ").append(listHall.getByIndex(i).data.toString()).append("\n");
        }
        return sb.toString();
    }
}
