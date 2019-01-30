package ru.job4j.iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class MatrixIteratorTest {

    private Iterator<Integer> it;

    @Before
    public void setUp() {
        it = new MatrixIterator(new int[][]{{1}, {3, 4}, {7}});
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(7));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(7));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextOutOfArrayElement() {
        for (int i = 0; i < 10; i++) {
            it.next();
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmptyArray() {
        var itEmpty = new MatrixIterator(new int[][]{});
        itEmpty.next();
    }
}