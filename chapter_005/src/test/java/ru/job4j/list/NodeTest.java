package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class NodeTest {

    Node<Integer> first;
    Node<Integer> two;
    Node<Integer> third;
    Node<Integer> four;

    @Before
    public void beforeTest() {
        first = new Node<>(1);
        two = new Node<>(2);
        third = new Node<>(3);
        four = new Node<>(4);
    }

    @Test
    public void whenHasCycleFalse() {
        first.next = two;
        two.next = third;
        third.next = four;
        assertThat(first.hasCycle(first), is(false));
    }

    @Test
    public void whenHasCycleTrue() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertThat(first.hasCycle(first), is(true));
    }

    @Test
    public void whenHasCycleInMiddle() {
        first.next = two;
        two.next = third;
        third.next = two;
        assertThat(first.hasCycle(first), is(true));
    }
}
