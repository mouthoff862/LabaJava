package main.java.com.solvd.animals.linkedlist;

import java.util.Arrays;

public class MyLinkedListImpl<T extends Comparable<T>> implements MyLinkedList<T> {

    private static class Node {


        private Object value;
        private Node next;

        public <T> Node(Object value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node first;
    private Node last;
    private int size;


    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T t) {
        Node newNode = new Node(t);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public void remove(T t) {
        for (Node current = first, prev = null; current != null; prev = current, current = current.next) {
            if (current.value == t) {
                if (current == first) {
                    first = current.next;
                    current.next = null;
                } else if (current == last) {
                    prev.next = null;
                    last = prev;
                } else {
                    prev.next = current.next;
                    current.next = null;
                }
                size--;
            }
        }
    }

    public Object get(int index) {
        int currentIndex = 0;
        Node temp = first;

        while (temp != null) {
            if(currentIndex == index) {
                return temp.getValue();
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }

        throw new IllegalArgumentException();
    }

    public String toString() {
        Object[] result = new Object[size];

        int idx = 0;
        Node temp = first;

        while (temp != null) {
            result[idx++] = temp.getValue();
            temp = temp.getNext();
        }

        return Arrays.toString(result);
    }

    @Override
    public void sort() {
        Node current = first, index = null;
        Object temp;
        if (first == null) {
            return;
        } else {
            while (current != null) {
                index = current.next;
                while (index != null) {
                    if (((T) current.value).compareTo((T)(index.value)) > 0) {
                        temp = current.value;
                        current.value = index.value;
                        index.value = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

}
