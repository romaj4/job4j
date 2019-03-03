package ru.job4j.inputoutput;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class RemoveBanWordsTest {

    private final String ln = System.lineSeparator();

    @Test
    public void whenDeleteSomeWordsWhenNewLines() {
        String input = "One two three" + this.ln
                + "four five six" + this.ln
                + "seven eight nine";
        String[] abuses = {"two", "four", "nine"};
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        new RemoveBanWords().dropAbuses(inputStream, outputStream, abuses);
        assertThat(outputStream.toString(), is(new StringBuilder()
                .append("One three " + this.ln)
                .append("five six " + this.ln)
                .append("seven eight " + this.ln)
                .toString()));
    }
}