package ru.job4j.task;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDivTest {

    @Test
    public void whenDivisionEvenArray() {
        int[] arr = {10, 7, 5, 1};
        ArrayDiv arrayDev = new ArrayDiv();
        Integer[] result = arrayDev.arrayDivision(arr)[0];
        assertThat(result, is(new Integer[]{10, 1}));
    }

    @Test
    public void whenDivisionOddArray() {
        int[] arr = {36, 8, 12, 10, 25, 7, 1};
        ArrayDiv arrayDev = new ArrayDiv();
        Integer[] result = arrayDev.arrayDivision(arr)[0];
        assertThat(result, is(new Integer[]{36, 12, 1}));
    }
}