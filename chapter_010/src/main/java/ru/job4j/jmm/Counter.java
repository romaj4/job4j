package ru.job4j.jmm;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
@ThreadSafe
public class Counter {
    @GuardedBy("this")
    private int count;

    public synchronized int getCount() {
        return this.count;
    }

    public synchronized void incrementCount() {
        this.count++;
    }

    public synchronized void decrementCount() {
        this.count--;
    }
}
