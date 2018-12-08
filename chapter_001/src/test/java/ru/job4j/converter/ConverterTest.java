package ru.job4j.converter;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Currency converter
 *
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class ConverterTest {

    @Test
    public void when210RubleToEuroThen3() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(210);
        assertThat(result, is(3));
    }

    @Test
    public void when360RubleToDollarThen6() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(360);
        assertThat(result, is(6));
    }

    @Test
    public void when5EuroToRubleThen350() {
        Converter converter = new Converter();
        int result = converter.euroToRuble(5);
        assertThat(result, is(350));
    }

    @Test
    public void when8DollarToRubleThen480() {
        Converter converter = new Converter();
        int result = converter.dollarToRuble(8);
        assertThat(result, is(480));
    }


}
