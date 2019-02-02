package ru.job4j.generic;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class SimpleArray<T> implements Iterable<T> {

    private Object[] arr;

    private int index = 0;

    private int size;

    public SimpleArray(int size) {
        this.size = size;
        this.arr = new Object[size];
    }

    /**
     * Add element to the first empty position.
     *
     * @param model - element for insertion.
     * @return - operation result.
     */
    public boolean add(T model) {
        if (this.index < this.size) {
            this.arr[index++] = model;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        return true;
    }

    /**
     * Insert element to the position of index.
     *
     * @param index - index of element to insert in.
     * @param model - element for insertion.
     * @return - result.
     */
    public boolean set(int index, T model) {
        boolean rst = false;
        if (index <= this.index) {
            this.arr[index] = model;
            rst = true;
        }
        return rst;
    }

    /**
     * Remove element by index.
     */
    public boolean remove(int index) {
        boolean rst = false;
        if (index >= 0 && index <= this.index) {
            System.arraycopy(this.arr, index + 1, this.arr, index, this.size - index - 1);
            this.index--;
            rst = true;
        }
        return rst;
    }

    /**
     * Return element by index.
     *
     * @param index position.
     * @return element
     */
    public T get(int index) {
        return (T) this.arr[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int itIndex = 0;

            @Override
            public boolean hasNext() {
                return this.itIndex < index;
            }

            @Override
            public T next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(this.itIndex++);
            }
        };
    }
}
