package org.example.Lab4;

import org.example.Lab4.book.ScientificBook;
import org.example.Lab4.library.ScientificLibrary;
import org.example.Lab4.library.ScientificLibraryHall;
import org.example.Lab4.list.MyDoubleList;
import org.example.Lab4.list.MyLinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<ScientificBook> listBook = new MyLinkedList<>();
        listBook.addByIndex(1, new ScientificBook("Max", 1999));
        listBook.addByIndex(2, new ScientificBook("Steve", 1991));
        listBook.addByIndex(3, new ScientificBook("Pavel", 1992));
        listBook.addByIndex(4, new ScientificBook("Sam", 1994));
        ScientificLibraryHall libraryHall = new ScientificLibraryHall(listBook, "SciitificHall"); // Provide necessary parameters
        MyDoubleList<ScientificLibraryHall> hall = new MyDoubleList<>();
        hall.addByIndex(0, libraryHall);
        ScientificLibrary scientificLibrary = new ScientificLibrary(hall);

        // Example usage of ScientificLibrary methods
        int hallsCount = scientificLibrary.getNumberOfHalls();
        System.out.println("Number of halls: " + hallsCount);

        int totalBooks = scientificLibrary.numberOfBook();
        System.out.println("Total number of books: " + totalBooks);

        double totalPrice = scientificLibrary.getAllPriceFromBook();
        System.out.println("Total price of all books: " + totalPrice);

        // Fetching a book by index
        int bookIndex = 2; // Replace with the desired index
        ScientificBook retrievedBook = scientificLibrary.getBookScientificLibraryHallByIndex(bookIndex);
        if (retrievedBook != null) {
            System.out.println("Replace with the desired index:" + retrievedBook);
        }

        // Sorting books by price
        MyDoubleList<ScientificLibraryHall> sortedBooksByPrice = scientificLibrary.getBookSortByPrice();

        // Show all names of halls with book counts
        scientificLibrary.showAllNameOfHallByCount();


        // Delete a book from the library by number
        int deleteBookNumber = 4; // Replace with the desired book number
        scientificLibrary.deleteBookByNumber(deleteBookNumber);
        scientificLibrary.showAllNameOfHallByCount();
        // Get the best book in the library (with the highest price)
        double bestBookPrice = scientificLibrary.getBestBook();
        System.out.println("Best book price: " + bestBookPrice);
    }
}

