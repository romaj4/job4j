package ru.job4j.array;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class MatrixCheck {

    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i][i] != data[i + 1][i + 1] || data[i][data.length - i - 1] != data[i + 1][data.length - i - 2]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
