package org.example.Lab5;

import org.example.Lab3.ChildrenLibrary;
import org.example.Lab5.book.ChildrenBook;
import org.example.Lab5.inter.IBook;
import org.example.Lab5.inter.IHall;
import org.example.Lab5.library.ChildrenLibraryHall;
import org.example.Lab5.library.LibraryChildren;
import org.example.Lab5.list.MyDoubleList;

public class Main {
    public static void main(String[] args) {
        int[] countBooksPerHall = {3, 4, 2}; // Sample array representing the number of books in each hall
        LibraryChildren library = new LibraryChildren(3, countBooksPerHall); // Creating a library with 3 halls

        // Displaying the number of halls and total number of books in the library
        System.out.println("Number of halls: " + library.getNumberOfHalls());
        System.out.println("Total number of books: " + library.numberOfBook());

        // Retrieving the hall and book by index
        int hallIndex = 1;
        IHall retrievedHall = library.getLibraryHallByIndex(hallIndex);
        if (retrievedHall != null) {
            System.out.println("Retrieved hall: " + retrievedHall.getName());
        }

        int bookIndex = 1;
        IBook retrievedBook = library.getBookLibraryHallByIndex(bookIndex);
        if (retrievedBook != null) {
            System.out.println("Retrieved book: " + retrievedBook.getName());
        }

        // Sorting books by price
        MyDoubleList<IHall> sortedBooksByPrice = library.getBookSortByPrice();

        // Displaying all halls with their book counts
        library.showAllNameOfHallByCount();

        // Changing a hall by number
        int hallNumber = 0;
        IHall newHall = new ChildrenLibraryHall(5, "New Hall"); // Replace with the appropriate constructor parameters
        library.changeHallOnDifferentByNumber(hallNumber, newHall);

        // Changing a book by number
        int bookNumber = 1;
        IBook newBook = new ChildrenBook("New Book", 20); // Replace with the appropriate constructor parameters
        library.changeBookOnDifferentByNumber(bookNumber, newBook);

        // Adding a book to the library by number
        int addBookNumber = 1;
        IBook bookToAdd = new ChildrenBook("Book to Add", 15); // Replace with the appropriate constructor parameters
        library.addBookByNumber(addBookNumber, bookToAdd);

        library.showAllNameOfHallByCount();
        // Getting the best book in the library (with the highest price)
        double bestBookPrice = library.getBestBook();
        System.out.println("Best book price: " + bestBookPrice);
    }
}
