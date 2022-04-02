package main.java.com.solvd.animals.linkedlist;

public interface MyLinkedList<T> {

    int size();

    void add(T t);

    void remove(T t);

    void sort();

    Object get(int index);

    String toString();
}
