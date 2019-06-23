package ru.job4j.cache;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TextFileCacheTest {

    private final String lineSeparator = System.lineSeparator();

    @Test
    public void whenEmptyCacheThenLoadFileText() {
        TextFileCache txtCache = new TextFileCache("src/main/resources/");
        String expect = new StringBuilder().append("Roman").append(this.lineSeparator)
                .append("Petr").append(this.lineSeparator).append("Ivan").toString();
        assertThat(txtCache.get("Names.txt"), is(expect));
    }
}