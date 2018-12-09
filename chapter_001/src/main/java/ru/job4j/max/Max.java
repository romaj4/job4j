package ru.job4j.max;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Max {

    /**
     * Находит максимум из двух чисел.
     *
     * @param first  first.
     * @param second second.
     * @return max.
     */
    public int max(int first, int second) {
        return first >= second ? first : second;
    }

    /**
     * Находит максимум из трех чисел.
     *
     * @param first  first number.
     * @param second second number.
     * @param third  second number.
     * @return max.
     */
    public int max(int first, int second, int third) {
        int temp = this.max(first, second);
        int max = this.max(temp, third);
        return max;
    }
}
