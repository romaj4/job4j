package ru.job4j.tree;

import java.util.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    private final Node<E> root;

    private int modCount;

    public Tree(E root) {
        this.root = new Node<>(root);
    }

    /**
     * Добавляет дочерний элемент к родительскому.
     *
     * @param parent parent.
     * @param child  child.
     * @return результат операции.
     */
    @Override
    public boolean add(E parent, E child) {
        boolean rst = false;
        Optional<Node<E>> parentNode = this.findBy(parent);
        if (parentNode.isPresent() && this.findBy(child).isEmpty()) {
            parentNode.get().add(new Node<>(child));
            modCount++;
            rst = true;
        }
        return rst;
    }

    /**
     * Проверяет есть ли в дереве такой эдемент.
     *
     * @param value значение.
     * @return элемент.
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    /**
     * Проверяет бинарное ли дерево.
     *
     * @return результат.
     */
    public boolean isBinary() {
        boolean rst = true;
        Queue<Node<E>> treeList = new LinkedList<>();
        treeList.offer(this.root);
        while (!treeList.isEmpty()) {
            Node<E> el = treeList.poll();
            int count = 0;
            for (Node<E> child : el.leaves()) {
                treeList.offer(child);
                count++;
            }
            if (count > 2) {
                rst = false;
                break;
            }
        }
        return rst;
    }

    @Override
    public Iterator<E> iterator() {
        Queue<Node<E>> listIterator = new LinkedList<>();
        listIterator.offer(this.root);
        return new Iterator<>() {

            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return !listIterator.isEmpty();
            }

            @Override
            public E next() {
                if (this.expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> result = listIterator.poll();
                for (Node<E> child : result.leaves()) {
                    listIterator.offer(child);
                }
                return result.getValue();
            }
        };
    }
}
