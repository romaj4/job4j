package ru.job4j.inputoutput;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class EvenNumberTest {

    @Test
    public void whenStreamHasEvenNumberThenTrue() {
        byte[] array1 = new byte[]{3, 5, 10, 7, 12};
        ByteArrayInputStream byteStream = new ByteArrayInputStream(array1);
        EvenNumber en = new EvenNumber();
        System.out.println(en.isNumber(byteStream));
        assertThat(en.isNumber(byteStream), is(true));
    }

    @Test
    public void whenStreamHasNotEvenNumberThenTrue() {
        byte[] array1 = new byte[]{3, 5, 7, 13};
        ByteArrayInputStream byteStream = new ByteArrayInputStream(array1);
        EvenNumber en = new EvenNumber();
        System.out.println(en.isNumber(byteStream));
        assertThat(en.isNumber(byteStream), is(false));
    }
}