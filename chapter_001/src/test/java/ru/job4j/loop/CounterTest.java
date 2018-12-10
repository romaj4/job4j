package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class CounterTest {

    @Test
    public void whenSumEvenNumberFrom1To10Then30() {
        Counter counter = new Counter();
        int sum = counter.add(1, 10);
        assertThat(sum, is(30));
    }
}
