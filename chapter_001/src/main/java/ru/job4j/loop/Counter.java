package ru.job4j.loop;

/**
 * Counter.
 *
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Counter {
    /**
     * Вычисленние суумы четных чисел.
     *
     * @param start  начала диапазона.
     * @param finish конец диапазона.
     * @return сумма.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return  sum;
    }
}
