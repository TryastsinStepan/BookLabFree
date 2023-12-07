package org.example.Lab3;
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
public class ScientificBook extends Book {
    private double citationIndex;

    public ScientificBook() {
        super();
        this.citationIndex =0.0d;
    }

    public ScientificBook(String author, int year) {
        super(author, year);
        this.citationIndex = 0;
    }

    public ScientificBook(String author, String name, double coast, int year, double citationIndex) {
        super(author, name, coast, year);
        this.citationIndex = citationIndex;
    }

    public double getCitationIndex() {
        return citationIndex;
    }

    public void setCitationIndex(double citationIndex) {
        this.citationIndex = citationIndex;
    }

    @Override
    public String toString() {
        return "ScientificBook{" +
                "citationIndex=" + citationIndex +
                '}';
    }
}
