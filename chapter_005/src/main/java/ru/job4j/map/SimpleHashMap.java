package ru.job4j.map;

import java.util.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class SimpleHashMap<K, V> implements Iterable<SimpleHashMap.Entry> {

    private Entry[] container;

    private int capacity = 16;

    private final float loadFactor = 0.75f;

    private int size;

    private int modCount;

    public SimpleHashMap() {
        this.container = new Entry[this.capacity];
    }

    /**
     * Определяет индекс элемента по ключу.
     *
     * @param key ключ.
     * @return индекс.
     */
    private int indexFor(K key) {
        return key.hashCode() & (this.capacity - 1);
    }

    /**
     * Вставка элемента в коллекцию.
     *
     * @param key   ключ.
     * @param value значение.
     * @return результат операции.
     */
    public boolean insert(K key, V value) {
        this.checkSize();
        int basket = this.indexFor(key);
        boolean rst = this.container[basket] == null;
        if (rst) {
            this.container[basket] = new Entry(key, value);
            this.size++;
            this.modCount++;
        }
        return rst;
    }

    /**
     * Увеличивает размер массива и перераспределяет элементы
     * с учетом новой ёмкости.
     */
    private void checkSize() {
        if (this.size > this.capacity * this.loadFactor) {
            this.capacity *= 2;
            Entry[] newContainer = new Entry[this.capacity];
            for (Entry entry : this.container) {
                if (entry != null) {
                    newContainer[indexFor((K) entry.getKey())] = entry;
                }
            }
            this.container = newContainer;
        }
    }

    /**
     * Возвращает значение элемента по ключу.
     *
     * @param key ключ.
     * @return значение.
     */
    public V get(K key) {
        V rst = null;
        Entry entry = this.container[this.indexFor(key)];
        if (entry != null && entry.getKey().equals(key)) {
            rst = (V) entry.getValue();
        }
        return rst;
    }

    /**
     * Удаляет элемент по ключу.
     *
     * @param key ключ.
     * @return результат.
     */
    boolean delete(K key) {
        boolean rst = false;
        int basket = this.indexFor(key);
        Entry entry = this.container[basket];
        if (entry != null) {
            this.container[basket] = null;
            this.size--;
            this.modCount++;
            rst = true;
        }
        return rst;
    }

    /**
     * Возвращает кольчество элементов в коллекции.
     * @return размер.
     */
    public int size() {
        return this.size;
    }

    static class Entry<K, V> {

        private K key;

        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    @Override
    public Iterator<Entry> iterator() {
        return new Iterator<>() {

            private int itIndex = 0;

            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                boolean rst = false;
                int count = itIndex;
                while (count < container.length) {
                    if (container[count] != null) {
                        this.itIndex = count;
                        rst = true;
                        break;
                    }
                    count++;
                }
                return rst;
            }

            @Override
            public Entry<K, V> next() {
                if (this.expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[this.itIndex++];
            }
        };
    }
}
