package ru.job4j.pool;

import org.junit.Test;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ThreadPoolTest {

    @Test(expected = InterruptedException.class)
    public void whenShutdownAndWorkThenException() throws InterruptedException {
        ThreadPool pool = new ThreadPool();
        pool.work(() -> System.out.println(1));
        pool.work(() -> System.out.println(2));
        pool.shutdown();
        pool.work(() -> System.out.println(3));
    }
}