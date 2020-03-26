package ru.job4j.blockingqueue;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

@ThreadSafe
public class SimpleBlockingQueue<T> {

    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();

    private int capacity;

    public SimpleBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Adds an item to the end of the queue.
     *
     * @param value
     * @return result.
     */
    public synchronized boolean offer(T value) {
        while (this.queue.size() >= this.capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        boolean result = this.queue.offer(value);
        notifyAll();
        return result;
    }

    /**
     * Returns with the removal of the element from the beginning of the queue. If the queue is empty, returns null.
     *
     * @return result.
     */
    public synchronized T poll() {
        while (this.queue.size() < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T result = this.queue.poll();
        notifyAll();
        return result;
    }

    public synchronized int getSize() {
        return this.queue.size();
    }
}
