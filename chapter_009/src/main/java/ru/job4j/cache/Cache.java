package ru.job4j.cache;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public interface Cache<K, V> {

    /**
     * Returns value by key.
     *
     * @param key key.
     * @return value.
     */
    V get(K key);

    /**
     * Loading object into cache.
     */
    void load(K key);
}
