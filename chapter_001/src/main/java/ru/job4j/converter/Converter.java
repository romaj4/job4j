package ru.job4j.converter;

/**
 * Currency converter
 *
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Converter {

    /**
     * Convert rubles to euro.
     *
     * @param value rubles.
     * @return Euro.
     */
    public int rubleToEuro(int value) {
        return value / 70;
    }

    /**
     * Convert rubles to dollars.
     *
     * @param value rubles.
     * @return dollars.
     */
    public int rubleToDollar(int value) {
        return value / 60;
    }

    /**
     * Convert euro to rubles.
     *
     * @param value Euro.
     * @return rubles.
     */
    public int euroToRuble(int value) {
        return value * 70;
    }

    /**
     * Convert dollars to rubles.
     *
     * @param value dollars.
     * @return rubles.
     */
    public int dollarToRuble(int value) {
        return value * 60;
    }
}
