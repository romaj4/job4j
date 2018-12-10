package ru.job4j.loop;

/**
 * Factorial.
 *
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Factorial {

    /**
     * Вычисленние факториала
     *
     * @param n значение.
     * @return факториал.
     */
    public int calc(int n) {
        int fact = 1;
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                fact *= i;
            }
        }
        return fact;
    }
}
