package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class DynamicList<E> implements Iterable<E> {

    private Object[] container;

    private int size;

    private int index;

    public DynamicList(int size) {
        this.size = size;
        this.container = new Object[size];
    }

    /**
     * Добавляет элемент в первую свободную позицию.
     *
     * @param value - значение
     * @return результат.
     */
    public boolean add(E value) {
        if (this.index < this.size) {
            this.container[this.index++] = value;
        } else {
            this.size *= 2;
            this.container = Arrays.copyOf(this.container, this.size);
            this.container[this.index++] = value;
        }
        return true;
    }

    /**
     * Возвращает значение по индексу.
     *
     * @param index - позиция.
     * @return значение.
     */
    public E get(int index) {
        return (E) this.container[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int itIndex = 0;

            private int modCount = index;

            @Override
            public boolean hasNext() {
                return itIndex < index;
            }

            @Override
            public E next() {
                if (modCount != index) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(itIndex++);
            }
        };
    }
}
