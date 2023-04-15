package collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinked<E> implements LinkedList<E> {
    private int size = 0;
    private int modCount = 0;
    private Node<E> head;

    public void add(E  value) {
        final ForwardLinked.Node<E> newNode = new ForwardLinked.Node<>(value, null);
        if (head == null) {
            head = newNode;
        } else {
            ForwardLinked.Node<E> last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        ForwardLinked.Node<E> last = head;
        for (int i = 0; i < index; i++) {
            last = last.next;
        }
        return last.item;
    }

    public E deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        E rsl = head.item;
        Node<E> newHead = head.next;
        head.item = null;
        head.next = null;
        head = newHead;
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private final int expectedModCount = modCount;
            private ForwardLinked.Node<E> last = head;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return last != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E elem = last.item;
                last = last.next;
                return elem;
            }
        };
    }

    private static class Node<E> {
        private E item;
        private ForwardLinked.Node<E> next;

        Node(E element, ForwardLinked.Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}
