package main.java.com.solvd.animal.linkedlist;

public interface MyLinkedList<T> {

    int size();

    void add(T t);

    void remove(T t);

    void sort();

    Object get(int index);

    String toString();
}