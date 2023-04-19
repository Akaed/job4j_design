package collection;

import java.util.NoSuchElementException;

public class SimpleStack<T> {
    private Node<T> head;

    public T pop() {
        if ( head == null) {
            throw new NoSuchElementException();
        }
        T value = head.item;
        head = head.next;
        return value;
    }

    public void push(T value) {
        Node<T> node = new Node<>(value);
        node.next = head;
        head = node;
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;

        Node(T element) {
            this.item = element;
        }
    }
}
