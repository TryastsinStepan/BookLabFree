package org.example.Lab6;

import org.example.Lab6.inter.IBook;
import org.example.Lab6.inter.IHall;
import org.example.Lab6.inter.ILibrary;
import org.example.Lab6.lib.LibraryChildren;
import org.example.Lab6.list.MyDoubleList;

import java.io.*;

public class Libraries {
    public static void outputLibrary(ILibrary lib, OutputStream out) {
        if (lib == null || out == null) {
            throw new IllegalArgumentException("Library or OutputStream cannot be null");
        }
        try (DataOutputStream dataOutputStream = new DataOutputStream(out)) {
            int numberOfHalls = lib.getNumberOfHalls();
            dataOutputStream.writeInt(numberOfHalls);
            for (int i = 0; i < numberOfHalls; i++) {
                IHall hall = lib.getLibraryHallByIndex(i);
                dataOutputStream.writeUTF(hall.getName());
                dataOutputStream.writeInt(hall.getCountBook());
                for (int j = 0; j < hall.getCountBook(); j++) {
                    IBook book = hall.getBookByNumber(j);
                    dataOutputStream.writeUTF(book.getName());
                    dataOutputStream.writeDouble(book.getPrice());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
