package org.example.Lab6.list;

public class MyDoubleList<T> {
    public static class Node<T> {
        public Node<T> prev;
        public Node<T> next;
        public T data;

        public Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int count;

    public MyDoubleList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean addByIndex(int index, T data) {
        if (index < 0 || index > count) {
            return false;
        }

        Node<T> newNode = new Node<>(data);

        if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else if (index == count) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }

        count++;
        return true;
    }

    public Node<T> getByIndex(int index) {
        if (index < 0 || index >= count) {
            return null;
        }

        Node<T> currentItem = head;
        int currentIndex = 0;
        while (currentIndex < index) {
            currentItem = currentItem.next;
            currentIndex++;
        }

        return currentItem;
    }

    public boolean deleteByIndex(int index) {
        if (index < 0 || index >= count || isEmpty()) {
            return false;
        }

        Node<T> current = head;

        // Deleting the first node
        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null; // If head is the only node in the list
            }
            count--;
            return true;
        }

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }

        count--;
        return true;
    }

    public int getCount() {
        return count;
    }
}