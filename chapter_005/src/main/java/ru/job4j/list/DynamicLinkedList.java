package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class DynamicLinkedList<E> implements Iterable<E> {

    private int size;

    private Node<E> first;

    private Node<E> last;

    private int modCount;

    /**
     * Добавляет элемент в конец списка.
     *
     * @param date - значение элемента.
     */
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        if (this.size == 0) {
            this.first = newLink;
            newLink.prev = null;
        } else {
            newLink.prev = this.last;
            this.last.next = newLink;
        }
        newLink.next = null;
        this.last = newLink;
        this.size++;
        this.modCount++;
    }

    /**
     * Получает элемент из списка по индексу.
     *
     * @param index - индекс элемента.
     * @return - значение.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.value;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int itIndex = 0;

            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return this.itIndex < size;
            }

            @Override
            public E next() {
                if (this.expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(itIndex++);
            }
        };
    }

    /**
     * Класс - узел связанного списка.
     * Имеет собственное значение, а также хранит ссылки на
     * предыдущий и следующий узлы.
     *
     * @param <E> - тип класса.
     */
    private static class Node<E> {

        E value;

        Node<E> next;

        Node<E> prev;

        public Node(E data) {
            this.value = data;
        }
    }
}
