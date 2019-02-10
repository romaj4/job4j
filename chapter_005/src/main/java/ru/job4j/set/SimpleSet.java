package ru.job4j.set;

import ru.job4j.list.DynamicList;

import java.util.Iterator;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class SimpleSet<E> implements Iterable<E> {

    private int capacity = 10;

    private DynamicList<E> simpleSet;

    private int size;

    public SimpleSet() {
        this.simpleSet = new DynamicList<>(this.capacity);
    }

    /**
     * Добавляет уникальный элемент в коллекцию.
     *
     * @param value - значение.
     */
    public void add(E value) {
        boolean isValue = false;
        for (E e : this.simpleSet) {
            if (e.equals(value)) {
                isValue = true;
                break;
            }
        }
        if (!isValue) {
            this.simpleSet.add(value);
            this.size++;
        }
    }

    /**
     * Возвращает размер коллекции.
     *
     * @return size.
     */
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return this.simpleSet.iterator();
    }
}
