package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class BubbleSortTest {

    @Test
    public void whenArray54321ThenSortArray12345() {
        BubbleSort arr = new BubbleSort();
        int[] result = arr.sort(new int[]{5, 4, 3, 2, 1});
        int[] expect = {1, 2, 3, 4, 5};
        assertThat(result, is(expect));

    }
}
