package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class SumSortTest {

    @Test
    public void whenTwoSortArraysThenSumSortArray() {
        SumSort sumSort = new SumSort();
        int[] arr1 = {1, 4, 6, 12, 14};
        int[] arr2 = {3, 6, 8, 25, 35, 59};
        int[] result = sumSort.sumSortArray(arr1, arr2);
        int[] expect = {1, 3, 4, 6, 6, 8, 12, 14, 25, 35, 59};
        assertThat(result, is(expect));
    }
}
