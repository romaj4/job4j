package ru.job4j.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TreeTest {

    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void whenAddExistingChildElementThenFalse() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(2, 4);
        assertThat(
                tree.add(2, 3),
                is(false)
        );
    }

    @Test
    public void whenAddNotExistingChildElementThenFalse() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(2, 4);
        assertThat(
                tree.add(3, 5),
                is(false)
        );
    }

    @Test
    public void whenAllElementsIterate() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(2, 4);
        Iterator<Integer> it = tree.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenIsBinaryTree() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(2, 21);
        tree.add(2, 22);
        tree.add(3, 31);
        tree.add(3, 32);
        assertThat(tree.isBinary(), is(true));
    }

    @Test
    public void whenIsNotBinaryTree() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(2, 21);
        tree.add(2, 22);
        tree.add(3, 31);
        tree.add(3, 32);
        tree.add(3, 33);
        assertThat(tree.isBinary(), is(false));
    }
}