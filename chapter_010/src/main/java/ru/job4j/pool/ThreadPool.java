package ru.job4j.pool;

import ru.job4j.blockingqueue.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ThreadPool {
    private final List<Thread> threads = new LinkedList<>();

    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>(10);

    private boolean isShutdown;

    public ThreadPool() {
        int poolSize = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < poolSize; i++) {
            this.threads.add(new ThreadFromQueue(this.tasks));
        }
        this.threads.forEach(Thread::start);
    }

    /**
     * The method adds tasks to the blocking queue.
     *
     * @param job the task to work.
     */
    public void work(Runnable job) throws InterruptedException {
        if (this.isShutdown) {
            throw new InterruptedException("Work was shutdown");
        }
        this.tasks.offer(job);
    }

    /**
     * Stop the thread pool.
     */
    public void shutdown() {
        this.isShutdown = true;
        this.threads.forEach(Thread::interrupt);
    }
}
