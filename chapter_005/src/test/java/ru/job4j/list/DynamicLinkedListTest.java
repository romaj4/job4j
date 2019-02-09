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
public class DynamicLinkedListTest {

    DynamicLinkedList<Integer> linkedList;

    @Before
    public void setUp() {
        linkedList = new DynamicLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
    }

    @Test
    public void whenGetElement() {
        assertThat(linkedList.get(1), is(2));
    }

    @Test
    public void whenAddElement() {
        linkedList.add(4);
        assertThat(linkedList.get(2), is(4));
    }

    @Test
    public void whenAllNumbersIterate() {
        Iterator<Integer> it = linkedList.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenModifyListIterator() {
        Iterator<Integer> it = linkedList.iterator();
        it.next();
        linkedList.add(6);
        it.next();
    }
}