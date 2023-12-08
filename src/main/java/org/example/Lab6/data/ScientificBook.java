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
public class ScientificBook extends Book  implements  Serializable {
    private float citationIndex;
    public ScientificBook() {
        super();
        this.citationIndex = 0.0f;
    }
    public ScientificBook(String title, String author, int publishingYear, float price, float citationIndex) {
        super(title, author, publishingYear, price);
        this.citationIndex = citationIndex;
    }
    public ScientificBook(String author, int publishingYear) {
        super(author, publishingYear);
        this.citationIndex = 0.0f;
    }
    public void setCitationIndex(float index) {
        this.citationIndex = index;
    }
    public float getCitationIndex() {
        return this.citationIndex;
    }

}
