package org.example.Lab6;



import org.example.Lab6.lib.ChildrenLibraryHall;
import org.example.Lab6.lib.LibraryChildren;

import java.io.*;

public class Main {
        public static void main(String[] args) throws FileNotFoundException {
                ChildrenLibraryHall hall1 = new ChildrenLibraryHall(5,"Hall");
                ChildrenLibraryHall hall2 = new ChildrenLibraryHall(5,"Hall");
                LibraryChildren lib = new LibraryChildren("Library", new
                        ChildrenLibraryHall[]{hall1});
                Libraries.outputLibrary(lib, new FileOutputStream("data.bin"));
                 var readLib = Libraries.inputLibrary(new FileInputStream("data.bin"));
                System.out.println(readLib);
                Libraries.writeLibrary(lib, new PrintWriter(System.out, true));
                var readLib2 = Libraries.readLibrary(new InputStreamReader(System.in));
                System.out.println(readLib2);
                try (ObjectOutputStream oos = new ObjectOutputStream(new
                        FileOutputStream("object"))) {
                        oos.writeObject(readLib2);
                } catch (IOException e) {
                        e.printStackTrace();
                }
                LibraryChildren readLib3 = null;
                try (var ois = new ObjectInputStream(new FileInputStream("object"))) {
                        readLib3 = (LibraryChildren) ois.readObject();
                        System.out.println(readLib3);
                } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                }

        }
}

