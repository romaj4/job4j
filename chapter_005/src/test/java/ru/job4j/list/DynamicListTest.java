package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class DynamicListTest {

    DynamicList<Integer> dynamicList;

    @Before
    public void setUp() {
        dynamicList = new DynamicList<>(4);
        dynamicList.add(1);
        dynamicList.add(2);
        dynamicList.add(3);
    }

    @Test
    public void whenAddElement() {
        dynamicList.add(4);
        assertThat(dynamicList.get(3), is(4));
    }

    @Test
    public void whenAddElementAndGrowSize() {
        dynamicList.add(4);
        dynamicList.add(5);
        assertThat(dynamicList.get(4), is(5));
    }

    @Test
    public void whenAllNumbersIterate() {
        Iterator<Integer> it = dynamicList.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenModifyListIterator() {
        Iterator<Integer> it = dynamicList.iterator();
        it.next();
        dynamicList.add(6);
        it.next();
    }
}