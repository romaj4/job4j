package ru.job4j.array;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Check {

    public boolean mono(boolean[] data) {
        boolean result = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] != result) {
                return false;
            }
        }
        return true;
    }
}
