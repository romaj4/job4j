package ru.job4j.control;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class TestTaskTest {

    @Test
    public void whenCompareStructureTwoWordsThenResult() {
        TestTask task = new TestTask();
        assertThat(task.compareStructureWords("привет", "ветрип"), is(true));
        assertThat(task.compareStructureWords("привет", "превет"), is(false));
    }

    @Test
    public void whenDifferByOnePermutationThenResult() {
        TestTask task = new TestTask();
        assertThat(task.differByOnePermutation("привет", "пвирет"), is(true));
        assertThat(task.differByOnePermutation("привет", "пверит"), is(false));
    }

    @Test
    public void whenFindDuplicatedSymbolsThenResult() {
        TestTask task = new TestTask();
        assertThat(task.duplicatedSymbols("параллелограмм").size(), is(4));
        assertThat(task.duplicatedSymbols("мама"), is(2));
    }
}