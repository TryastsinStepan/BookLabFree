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
public class ChildrenBook extends Book{
    private int acceptableAge;

    public ChildrenBook() {
        super();
        this.acceptableAge = 0;
    }
    public ChildrenBook(String author, int year) {
        super(author, year);
        this.acceptableAge = 0;
    }

    public ChildrenBook(String author, String name, double coast, int year,int acceptableAge) {
        super(author, name, coast, year);
        this.acceptableAge = acceptableAge;
    }

    public int getAcceptableAge() {
        return acceptableAge;
    }
    public void setAcceptableAge(int acceptableAge) {
        this.acceptableAge = acceptableAge;
    }

    @Override
    public String toString() {
        return "ChildrenBook{" +
                "acceptableAge=" + acceptableAge +
                '}';
    }
}
