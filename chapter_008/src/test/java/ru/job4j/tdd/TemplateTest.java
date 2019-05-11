package ru.job4j.tdd;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class TemplateTest {

    @Test
    public void whenGenerateStringWithDifferentKeysThenFormattedString() {
        Template generator = new SimpleGenerate();
        Map<String, String> keysMap = new HashMap<>();
        keysMap.put("name", "Roman");
        keysMap.put("subject", "you");
        String result = generator.generate("I am ${name}, Who are ${subject}?", keysMap);
        assertThat(result, is("I am Roman, Who are you?"));
    }

    @Test
    public void whenGenerateStringWithSameKeysThenFormattedString() {
        Template generator = new SimpleGenerate();
        Map<String, String> keysMap = new HashMap<>();
        keysMap.put("sos", "AAA");
        String result = generator.generate("Help, ${sos}, ${sos}, ${sos}", keysMap);
        assertThat(result, is("Help, AAA, AAA, AAA"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGenerateStringWithNonExistKeyThenException() {
        Template generator = new SimpleGenerate();
        generator.generate("Help, ${sos}, ${sos}, ${sos}", new HashMap<>());
    }

    @Test(expected = IllegalStateException.class)
    public void whenGenerateStringAndExtraKeyThenException() {
        Template generator = new SimpleGenerate();
        Map<String, String> keysMap = new HashMap<>();
        keysMap.put("sos", "AAA");
        keysMap.put("name", "Roman");
        generator.generate("Help, ${sos}, ${sos}, ${sos}", keysMap);
    }
}