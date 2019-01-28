package ru.job4j.testtask;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class SumArrayNumbersTest {

    @Test
    public void whenSumSomeEvenSquareElement() {
        SumArrayNumbers sumArrayNumbers = new SumArrayNumbers();
        int[] arr = {1, 2, 5, 9, 7, 3, 21, 4};
        int res = sumArrayNumbers.sumEvenSquareElement(arr);
        assertThat(res, is(20));
    }

    @Test
    public void whenNoEvenElement() {
        SumArrayNumbers sumArrayNumbers = new SumArrayNumbers();
        int[] arr = {1, 11, 5, 9, 7, 3, 31};
        int res = sumArrayNumbers.sumEvenSquareElement(arr);
        assertThat(res, is(0));
    }
}