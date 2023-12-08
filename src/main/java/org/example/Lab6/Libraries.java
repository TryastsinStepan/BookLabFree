package org.example.Lab6;

import org.example.Lab3.ChildrenLibrary;
import org.example.Lab6.data.ChildrenBook;
import org.example.Lab6.data.ScientificBook;
import org.example.Lab6.inter.ILibrary;
import org.example.Lab6.lib.ChildrenLibraryHall;
import org.example.Lab6.lib.LibraryChildren;
import org.example.Lab6.lib.ScientificLibrary;
import org.example.Lab6.lib.ScientificLibraryHall;


import java.io.*;

public class Libraries {
    public static void outputLibrary(ILibrary lib, OutputStream out) {
        try (var dataOut = new DataOutputStream(out)) {
            if (lib instanceof LibraryChildren) {
                dataOut.writeUTF("Children library");
            } else if (lib instanceof ScientificLibrary) {
                dataOut.writeUTF("Scientific library");
            }
            dataOut.writeInt(lib.getNumberOfHalls());
            for (int i = 0; i < lib.getNumberOfHalls(); i++) {
                var hall = lib.getLibraryHallByIndex(i);
                if (hall instanceof ChildrenLibraryHall) {
                    dataOut.writeUTF("Children library hall");
                } else if (hall instanceof ScientificLibraryHall) {
                    dataOut.writeUTF("Scientific library hall");
                }
                dataOut.writeInt(hall.getSize());
                for (int j = 0; j < hall.getCountBook(); j++) {
                    var book = hall.getBookByNumber(j);
                    if (book instanceof ChildrenBook childrenBook) {
                        dataOut.writeUTF("Children book");
                        dataOut.writeUTF(childrenBook.getAuthor());
                        dataOut.writeUTF(childrenBook.getName());
                        dataOut.writeInt(childrenBook.getYear());
                        dataOut.writeFloat((float) childrenBook.getPrice());
                        dataOut.writeInt(childrenBook.getMinimumAge());
                    } else if (book instanceof ScientificBook scientificBook) {
                        dataOut.writeUTF("Scientific book");
                        dataOut.writeUTF(scientificBook.getAuthor());
                        dataOut.writeUTF(scientificBook.getName());
                        dataOut.writeInt(scientificBook.getYear());
                        dataOut.writeFloat((float) scientificBook.getPrice());
                        dataOut.writeFloat(scientificBook.getCitationIndex());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ILibrary inputLibrary(InputStream in) {
        ILibrary lib = null;
        try (var dataIn = new DataInputStream(in)) {
            String libType = dataIn.readUTF();
            int hallsAmount = dataIn.readInt();
            if (libType.equals("Children library")) {
                ChildrenLibraryHall[] halls = new ChildrenLibraryHall[hallsAmount];
                for (int i = 0; i < halls.length; i++) {
                    dataIn.readUTF();
                    int booksAmount = dataIn.readInt();
                    ChildrenBook[] books = new ChildrenBook[booksAmount];
                    for (int j = 0; j < booksAmount; j++) {
                        dataIn.readUTF();
                        String author = dataIn.readUTF();
                        String title = dataIn.readUTF();
                        int publishingYear = dataIn.readInt();
                        float price = dataIn.readFloat();
                        int minimumAge = dataIn.readInt();
                        books[j] = new ChildrenBook(title, author, publishingYear, price, minimumAge);
                    }
                    halls[i] = new ChildrenLibraryHall("?", books);
                }
                lib = new LibraryChildren("<>", halls);
            } else if (libType.equals("Scientific library")) {
                ScientificLibraryHall[] halls = new ScientificLibraryHall[hallsAmount];
                for (int i = 0; i < halls.length; i++) {
                    dataIn.readUTF();
                    int booksAmount = dataIn.readInt();
                    ScientificBook[] books = new ScientificBook[booksAmount];
                    for (int j = 0; j < booksAmount; j++) {
                        dataIn.readUTF();
                        String author = dataIn.readUTF();
                        String title = dataIn.readUTF();
                        int publishingYear = dataIn.readInt();
                        float price = dataIn.readFloat();
                        float citationIndex = dataIn.readFloat();
                        books[j] = new ScientificBook(title, author, publishingYear, price, citationIndex);
                    }
                    halls[i] = new ScientificLibraryHall("<>", books);
                }
                lib = new ScientificLibrary("<>", halls);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return lib;
    }

    public static void writeLibrary(ILibrary lib, Writer out) {
        var printOut = new PrintWriter(out);
        if (lib instanceof ChildrenLibrary) {
            printOut.write("Children library\n");
        } else if (lib instanceof ScientificLibrary) {
            printOut.write("Scientific library\n");
        }
        printOut.write(lib.getNumberOfHalls() + "\n");
        for (int i = 0; i < lib.getNumberOfHalls(); i++) {
            var hall = lib.getLibraryHallByIndex(i);
            printOut.write(hall.getSize() + "\n");
            for (int j = 0; j < hall.getCountBook(); j++) {
                var book = hall.getBookByNumber(j);
                printOut.write(book.getAuthor() + "\n");
                printOut.write(book.getName() + "\n");
                printOut.write(book.getYear() + "\n");
                printOut.write(book.getPrice() + "\n");
                if (book instanceof ChildrenBook childrenBook) {
                    printOut.write(childrenBook.getMinimumAge() + "\n");
                } else if (book instanceof ScientificBook scientificBook) {
                    printOut.write(scientificBook.getCitationIndex() + "\n");
                }
            }
        }
        printOut.flush();
    }

    public static ILibrary readLibrary(Reader in) {
        ILibrary lib = null;
        var tokenizer = new StreamTokenizer(in);
        try {
            tokenizer.nextToken();
            String libType = tokenizer.sval;
            if (libType.equals("Children library")) {
                tokenizer.nextToken();
                int hallsAmount = (int) tokenizer.nval;
                ChildrenLibraryHall[] halls = new ChildrenLibraryHall[hallsAmount];
                for (int i = 0; i < hallsAmount; i++) {
                    tokenizer.nextToken();
                    int booksAmount = (int) tokenizer.nval;
                    ChildrenBook[] books = new ChildrenBook[booksAmount];
                    for (int j = 0; j < booksAmount; j++) {
                        tokenizer.nextToken();
                        String author = tokenizer.sval;
                        tokenizer.nextToken();
                        String title = tokenizer.sval;
                        tokenizer.nextToken();
                        int publishingYear = (int) tokenizer.nval;
                        tokenizer.nextToken();
                        float price = (float) tokenizer.nval;
                        tokenizer.nextToken();
                        int minimumAge = (int) tokenizer.nval;
                        books[j] = new ChildrenBook(title, author, publishingYear, price, minimumAge);
                    }
                    halls[i] = new ChildrenLibraryHall("<>", books);
                }
                lib = new LibraryChildren("?", halls);
            } else if (libType.equals("Scientific library")) {
                tokenizer.nextToken();
                int hallsAmount = (int) tokenizer.nval;
                ScientificLibraryHall[] halls = new ScientificLibraryHall[hallsAmount];
                for (int i = 0; i < hallsAmount; i++) {
                    tokenizer.nextToken();
                    int booksAmount = (int) tokenizer.nval;
                    ScientificBook[] books = new ScientificBook[booksAmount];
                    for (int j = 0; j < booksAmount; j++) {
                        tokenizer.nextToken();
                        String author = tokenizer.sval;
                        tokenizer.nextToken();
                        String title = tokenizer.sval;
                        tokenizer.nextToken();
                        int publishingYear = (int) tokenizer.nval;
                        tokenizer.nextToken();
                        float price = (float) tokenizer.nval;
                        tokenizer.nextToken();
                        float citationIndex = (float) tokenizer.nval;
                        books[j] = new ScientificBook(title, author, publishingYear, price, citationIndex);
                    }
                    halls[i] = new ScientificLibraryHall("<>", books);
                }
                lib = new ScientificLibrary("?", halls);
            } else {
                System.out.println("Error: Unknown library type!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lib;
    }
}

