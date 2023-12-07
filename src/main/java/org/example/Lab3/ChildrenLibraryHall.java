package org.example.Lab3;


import java.util.Arrays;
import java.util.Optional;
public class ChildrenLibraryHall {
    private String nameHall;
    private int countBook;
    private ChildrenBook childrenBook[];

    public ChildrenLibraryHall(String nameHall, int countBook) {
        this.nameHall = nameHall;
        this.countBook = countBook;
    }

    public ChildrenLibraryHall(String nameHall, ChildrenBook childrenBook[]) {
        this.nameHall = nameHall;
        this.childrenBook = childrenBook;
    }

    public String getNameHall() {
        return nameHall;
    }

    public void setNameHall(String nameHall) {
        this.nameHall = nameHall;
    }

    public int getCountBook() {
        return childrenBook.length;
    }

    public void setCountBook(int countBook) {
        this.countBook = countBook;
    }

    public ChildrenBook[] getChildrenBook() {
        return childrenBook;
    }

    public void setChildrenBook(ChildrenBook[] childrenBook) {
        this.childrenBook = childrenBook;
    }
    //Задание 1
    public int getAllCountOfBook() {
        return childrenBook.length;
    }
    // Задание 2
    public void showAllBookInHall(){
        for(int i = 0;i<childrenBook.length;i++){
            System.out.println("Название книги: "+" "+ childrenBook[i].getName());
        }
    }
    //Задание 3
    public double getAllPriceFromBook(){
        double total = 0;
        for(int i = 0;i<childrenBook.length;i++){
            total+=childrenBook[i].getPrice();
        }
        return total;
    }
    //Задание 4
    public Optional<ChildrenBook> getBookByNumber(int index){
        if (index < 0 || index >= childrenBook.length) {
            throw new IllegalArgumentException("Неверный индекс");
        }
       return Optional.of(childrenBook[index]);
    }
    //Задание 5
    public void changeNumberOfBookByNumber(int index,ChildrenBook childrenBookForChange){
        if ((index < 0 || index >= childrenBook.length)||childrenBookForChange==null) {
            throw new IllegalArgumentException("Неверный индекс или объект равен null");
        }
        childrenBook[index] = childrenBookForChange;
    }
    // Задание 6
    public void addNumberOfBookByNumber(int index,ChildrenBook childrenBookForAdd){
        ChildrenBook arrayForCopy[] = new ChildrenBook[childrenBook.length+1];
        if ((index < 0 || index >= childrenBook.length)||childrenBookForAdd==null) {
            throw new IllegalArgumentException("Неверный индекс или объект равен null");
        }
        for (int i = 0,j = 0; i < arrayForCopy.length; i++) {
            if(i == index){
                arrayForCopy[i] = childrenBookForAdd;
            }else{
                arrayForCopy[i] = childrenBook[j];
                j++;
            }
        }
        childrenBook = arrayForCopy;
    }
    // Задание 7
    public void deleteBookByNumber(int index) {
        if (index < 0 || index >= childrenBook.length) {
            throw new IllegalArgumentException("Неверный индекс");
        }
        ChildrenBook[] newArray = new ChildrenBook[childrenBook.length - 1];

        for (int i = 0, j = 0; i < childrenBook.length; i++) {
            if (i != index) {
                newArray[j] = childrenBook[i];
                j++;
            }
        }
        childrenBook = newArray;
    }
    // Задание 8
    public double getBookWithBigPrice(){
        if (childrenBook.length == 0) {
            throw new IllegalArgumentException("Массив книг пуст");
        }
        double totalPrice = Double.MIN_VALUE;
        for (int i = 0; i < childrenBook.length; i++) {
            if(childrenBook[i].getPrice()>totalPrice){
                totalPrice = childrenBook[i].getPrice();
            }
        }
        return totalPrice;
    }
    @Override
    public String toString() {
        return "ChildrenLibraryHall{" +
                "nameHall='" + nameHall + '\'' +
                ", countBook=" + countBook +
                ", childrenBook=" + Arrays.toString(childrenBook) +
                '}';
    }
}
