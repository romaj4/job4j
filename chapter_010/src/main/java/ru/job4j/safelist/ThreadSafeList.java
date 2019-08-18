package ru.job4j.safelist;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.list.DynamicList;

import java.util.Iterator;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
@ThreadSafe
public class ThreadSafeList<E> implements Iterable<E> {

    @GuardedBy("this")
    private DynamicList<E> safeList;

    private int size;

    public ThreadSafeList(int size) {
        this.size = size;
        this.safeList = new DynamicList<>(size);
    }

    public synchronized boolean add(E value) {
        return this.safeList.add(value);
    }

    public synchronized E get(int index) {
        return this.safeList.get(index);
    }

    @Override
    public synchronized Iterator<E> iterator() {
        return copy(this.safeList).iterator();
    }

    private synchronized Iterable<E> copy(DynamicList<E> list) {
        DynamicList<E> copyList = new DynamicList<>(this.size);
        for (E value : this.safeList) {
            copyList.add(value);
        }
        return copyList;
    }
}
