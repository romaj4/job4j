package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class SimpleArrayTest {

    SimpleArray<Integer> simpleArray;

    @Before
    public void setUp() {
        simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
    }

    @Test
    public void whenAddElement() {
        simpleArray.add(4);
        assertThat(simpleArray.get(3), is(4));
    }

    @Test
    public void whenSetElement() {
        simpleArray.set(1, 48);
        assertThat(simpleArray.get(1), is(48));
    }

    @Test
    public void whenRemoveElement() {
        simpleArray.remove(0);
        assertThat(simpleArray.get(1), is(3));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddMoreArraySizeElements() {
        simpleArray.add(4);
        simpleArray.add(5);
        simpleArray.add(6);
    }

    @Test
    public void whenAllNumbersIterate() {
        Iterator<Integer> it = simpleArray.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
    }
}