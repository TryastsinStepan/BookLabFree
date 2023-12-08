package org.example.Lab6.list;


import org.example.Lab6.inter.IBook;

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
        this.head = null; // Изменено: Начальное значение head - null
        this.count = 0; // Изменено: Начальное значение count - 0
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        this.count++;
    }

    public boolean addByIndex(int index, T data) {
        if (index < 0 || index > count) {
            return false;
        }

        Node<T> newItem = new Node<>(data);
        if (index == 0) {
            newItem.next = head;
            head = newItem;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newItem.next = current.next;
            current.next = newItem;
        }

        this.count++;
        return true;
    }

    public boolean deleteByIndex(int index) {
        if (index < 0 || index >= count) {
            return false;
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }

        this.count--;
        return true;
    }

    public Node<T> getByIndex(int index) {
        if (index < 0 || index > count || head == null) {
            return null;
        }

        Node<T> currentItem = head;
        for (int i = 0; i < index; i++) {
            currentItem = currentItem.next;
        }
        return currentItem;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        Node<T> currentItem = head;
        for (int i = 0; i < count; i++) {
            System.out.println("Element at index " + i + ": " + currentItem.data);
            currentItem = currentItem.next;
        }
    }

    public int size() {
        return count;
    }

}
