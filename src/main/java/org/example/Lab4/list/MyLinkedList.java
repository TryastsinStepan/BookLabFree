package org.example.Lab4.list;

import org.example.Lab4.book.ScientificBook;

public class MyLinkedList<T> {
    public static class Node<T> {
        private Node<T> next;
        public T data;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private int count;

    public MyLinkedList() {
        this.head = new Node<>(null);
        this.count = 0;
    }
    public boolean isEmpty() {
        return count == 0;
    }
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        this.count++;
    }
    public boolean addByIndex(int index, ScientificBook data) {
        if (index < 0 ) {
            return false;
        }

        Node<ScientificBook> newItem = new Node<>(data);
        Node<ScientificBook> current = (Node<ScientificBook>) head;
        Node<ScientificBook> previous = null;
        int currentIndex = 0;

        while (currentIndex < index) {
            previous = current;
            current = current.next;
            currentIndex++;
        }

        if (previous != null) {
            previous.next = newItem;
        } else {
            head = (Node<T>) newItem;
        }

        newItem.next = current;
        this.count++;
        return true;
    }
    public boolean deleteByIndex(int index) {
        if (index < 0 || index > count) {
            return false; // Если индекс находится вне диапазона списка, возвращаем false
        }

        if (index == 0) {
            head = head.next; // Если индекс равен 0, удаляем первый элемент списка, обновляя head
        } else {
            Node previous = head;
            Node current = head.next;
            int currentIndex = 1; // Начинаем с 1, так как 0 был уже обработан выше

            while (currentIndex < index) {
                previous = current;
                current = current.next;
                currentIndex++;
            }

            // Удаляем элемент из списка, связывая предыдущий узел с узлом, следующим за удаляемым
            previous.next = current.next;
        }

        this.count--;
        return true;
    }
    public Node getByIndex(int index) {
        if (index < 0 || index >= count) {
            return null;
        }
        Node currentItem = head.next;
        int currentIndex = 0;
        while (currentIndex < index) {
            currentItem = currentItem.next;
            currentIndex++;
        }
        return currentItem;
    }
    public void print() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        Node currentItem = head.next;
        for (int i = 0; i < count; i++) {
            System.out.println("Element at index " + i + ": " + currentItem.data);
            currentItem = currentItem.next;
        }
    }
    public int size() {
        return count;
    }
}
