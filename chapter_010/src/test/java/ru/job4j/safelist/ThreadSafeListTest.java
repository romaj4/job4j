package ru.job4j.safelist;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ThreadSafeListTest {

    @Test
    public void whenGetIteratorAndChangeListThenNoException() {
        ThreadSafeList<Integer> safeList = new ThreadSafeList<>(5);
        safeList.add(5);
        safeList.add(6);
        Iterator<Integer> listIterator = safeList.iterator();
        assertThat(listIterator.next(), is(5));
        safeList.add(7);
        assertThat(listIterator.next(), is(6));
        assertThat(listIterator.hasNext(), is(false));
    }
}