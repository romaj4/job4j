package ru.job4j.testtask;

import java.util.Arrays;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class SumArrayNumbers {

    /**
     * Метод возвращает сумму квадратов четных элементов массива.
     *
     * @param array array of numbers.
     * @return sum of elements.
     */
    public int sumEvenSquareElement(int[] array) {
        return Arrays.stream(array).filter(n -> n % 2 == 0).map(n -> n * n).reduce(0, (a, b) -> a + b);
    }
}
