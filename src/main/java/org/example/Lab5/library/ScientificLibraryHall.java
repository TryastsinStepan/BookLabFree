package org.example.Lab5.library;
import org.example.Lab5.book.ChildrenBook;
import org.example.Lab5.exception.BookIndexOutOfBoundsException;
import org.example.Lab5.exception.InvalidBookPriceException;
import org.example.Lab5.inter.IBook;
import org.example.Lab5.inter.IHall;
import org.example.Lab5.list.MyLinkedList;

public class ScientificLibraryHall implements IHall {
    private String nameHall;
    private MyLinkedList<IBook> bookList;
    private int countHall;
    private int countBook;

    public ScientificLibraryHall(MyLinkedList<IBook> bookList, String nameHall) {
        this.bookList = bookList;
        this.nameHall = nameHall;
        countBook = bookList.size();
    }
    public ScientificLibraryHall(int numberHall, String nameHall) {
        this.countHall = numberHall;
        this.nameHall = nameHall;
        bookList = new MyLinkedList<>();
        for (int i = 0; i < numberHall; i++) {
            bookList.addByIndex(i,new ChildrenBook("?",0));

        }
        countBook = bookList.size();
    }


    @Override
    public void showAllBookInHall() {
        if (bookList.isEmpty()) {
            throw new InvalidBookPriceException("Пусто");
        }
        for(int i = 0;i<bookList.size();i++){
            System.out.println("Название книги: "+" "+ bookList.getByIndex(i));
        }
    }

    @Override
    public double getAllPriceFromBook() {
        if (bookList.isEmpty()) {
            throw new InvalidBookPriceException("Пусто");
        }
        double total = 0;
        for(int i = 0; i < countBook; i++){
            IBook currentBook = (IBook) bookList.getByIndex(i).data;
            total += currentBook.getPrice(); // Assuming there's a getPrice() method in ScientificBook
        }
        return total;
    }

    @Override
    public IBook getBookByNumber(int index) {
        if (index < 0 || index > countBook) {
            throw new BookIndexOutOfBoundsException("Неверный индекс");
        }
        IBook currentBook = (IBook) bookList.getByIndex(index).data;
        return currentBook;
    }

    @Override
    public void changeNumberOfBookByNumber(int index, IBook book) {

        if ((index < 0 || index > countBook) || book==null) {
            throw new BookIndexOutOfBoundsException("Неверный индекс или объект равен null");
        }
        bookList.deleteByIndex(index);
        bookList.addByIndex(index,book);
    }

    @Override
    public void addNumberOfBookByNumber(int index, IBook book) {
        if ((index < 0 || index > countBook)||book==null) {
            throw new BookIndexOutOfBoundsException("Неверный индекс или объект равен null");
        }
        bookList.addByIndex(index,book);
    }

    @Override
    public void deleteBookByNumber(int index) {
        if (index < 0 || index > countBook) {
            throw new BookIndexOutOfBoundsException("Неверный индекс");
        }
        bookList.deleteByIndex(index);

    }

    public double getBookWithBigPrice(){

        MyLinkedList<IBook> data = new MyLinkedList<>();
        if (bookList.isEmpty()) {
            throw new InvalidBookPriceException("Массив книг пуст");
        }
        double maxPrice = Double.MIN_VALUE;
        for (int i = 0; i < countBook; i++) {
            data.addByIndex(i, (IBook) bookList.getByIndex(i).data);
        }
        for (int i = 0; i < countBook; i++) {
            IBook book = (IBook) bookList.getByIndex(i).data;
            if(book.getPrice()<maxPrice){
                maxPrice = book.getPrice();
            }
        }
        return maxPrice;
    }

    @Override
    public int getSize() {
        return countHall;
    }

    @Override
    public int getCountBook() {
        return countBook;
    }

    @Override
    public String getName() {
        return nameHall;
    }
    @Override
    public String toString() {
        return "ScientificChildrenHall{" +
                "nameHall='" + nameHall + '\'' +
                ", bookList=" + bookList +
                ", countBook=" + countHall +
                '}';
    }

}

