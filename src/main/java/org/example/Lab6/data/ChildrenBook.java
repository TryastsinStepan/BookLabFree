package org.example.Lab6.data;

import org.example.Lab6.inter.IBook;

import java.io.Serializable;
import java.util.Objects;

/*Задание 2. Создайте класс ChildrenBook, описывающий книгу для детей, расширяющий класс Book.
Книга для детей имеет еще один параметр – минимальный возраст, с которого можно читать книгу (в
годах). Создайте соответствующую переменную, методы получения и установки значения. Создайте 3
конструктора: по умолчанию (мин. возраст = 0), с двумя параметрами (как в задании 1) и с полным
списком параметров. При разработке конструкторов используйте вызовы конструкторов суперкласса.
Создайте класс ScientificBook, описывающий научную книгу, расширяющий класс Book. Научная
книга имеет дополнительный параметр – индекс цитируемости (вещественное число). Создайте
соответствующую переменную, методы получения и установки значения. Создайте 3 конструктора: по
умолчанию (индекс цитирования = 0.0), с двумя параметрами (как в задании 1) и с полным списком
параметров. При разработке конструкторов используйте вызовы конструкторов суперкласса*/
public class ChildrenBook extends Book  implements  Serializable {
    private int minimumAge;
    public ChildrenBook() {
        super();
        this.minimumAge = 0;
    }
    public ChildrenBook(String title, String author, int publishingYear, float
            price, int minimumAge) {
        super(title, author, publishingYear, price);
        this.minimumAge = minimumAge;
    }
    public ChildrenBook(String author, int publishingYear) {
        super(author, publishingYear);
        this.minimumAge = 0;
    }
    public void setMinimumAge(int age) {
        this.minimumAge = age;
    }
    public int getMinimumAge() {
        return this.minimumAge;
    }

}
