package ru.job4j.pool;

import ru.job4j.blockingqueue.SimpleBlockingQueue;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ThreadFromQueue extends Thread {
    private final SimpleBlockingQueue<Runnable> tasks;

    public ThreadFromQueue(SimpleBlockingQueue<Runnable> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            try {
                this.tasks.poll().run();
            } catch (InterruptedException e) {
                this.interrupt();
            }
        }
    }
}
