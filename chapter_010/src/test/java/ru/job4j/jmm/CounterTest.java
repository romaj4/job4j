package ru.job4j.jmm;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class CounterTest {

    private class ThreadCount extends Thread {
        private final Counter count;

        private ThreadCount(final Counter count) {
            this.count = count;
        }

        @Override
        public void run() {
            this.count.incrementCount();
        }
    }

    @Test
    public void whenExecute2ThreadThen2() throws InterruptedException {
        final Counter count = new Counter();
        Thread first = new ThreadCount(count);
        Thread second = new ThreadCount(count);
        first.start();
        second.start();
        first.join();
        second.join();
        assertThat(count.getCount(), is(2));
    }

    @Test
    public void testThreadProblem() {
        Counter counter = new Counter();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.incrementCount();
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.decrementCount();
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThat(counter.getCount(), is(0));
    }
}