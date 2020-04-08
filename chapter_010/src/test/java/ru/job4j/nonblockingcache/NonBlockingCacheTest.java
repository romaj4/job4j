package ru.job4j.nonblockingcache;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class NonBlockingCacheTest {

    @Test
    public void whenUpdateCacheThenResult() {
        NonBlockingCache cache = new NonBlockingCache();
        Base model1 = new Base(1);
        Base model2 = new Base(2);
        cache.add(model1);
        assertThat(cache.update(model1), is(true));
        assertThat(cache.update(model2), is(false));
    }

    @Test
    public void whenFiveUpdateThenVersion5() {
        NonBlockingCache cache = new NonBlockingCache();
        Base model1 = new Base(1);
        cache.add(model1);
        for (int i = 0; i < 5; i++) {
            cache.update(model1);
        }
        assertThat(cache.getModel(1).getVersion(), is(5));
    }

    @Test
    public void whenThrowException() throws InterruptedException {
        NonBlockingCache cache = new NonBlockingCache();
        cache.add(new Base(1));
        AtomicReference<Exception> ex = new AtomicReference<>();
        Thread thread1 = new Thread(
                () -> {
                    try {
                        cache.update(new Base(1));
                    } catch (OptimisticException e) {
                        ex.set(e);
                    }
                }
        );
        Thread thread2 = new Thread(
                () -> {
                    try {
                        cache.update(new Base(1));
                    } catch (OptimisticException e) {
                        ex.set(e);
                    }
                }
        );
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        assertThat(ex.get().getMessage(), is("Model modified"));
    }
}