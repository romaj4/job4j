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
        if (!this.isValue(value)) {
            this.simpleSet.add(value);
            this.size++;
        }
    }

    /**
     * Проверяет есть ли такой элемент в коллекции.
     *
     * @param value значение.
     * @return result.
     */
    public boolean isValue(E value) {
        boolean rst = false;
        for (E e : this.simpleSet) {
            if (e.equals(value)) {
                rst = true;
                break;
            }
        }
        return rst;
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
