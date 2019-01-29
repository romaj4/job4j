package ru.job4j.iterator;

import java.util.Iterator;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class MatrixIterator implements Iterator<Integer> {

    private final int[][] arr;

    private int firstIndex = 0;

    private int secondIndex = 0;

    public MatrixIterator(int[][] arr) {
        this.arr = arr;
    }

    @Override
    public boolean hasNext() {
        return this.firstIndex < this.arr.length;
    }

    @Override
    public Integer next() {
        int res;
        if (this.secondIndex < arr[this.firstIndex].length - 1) {
            res = arr[this.firstIndex][this.secondIndex++];
        } else {
            res = arr[this.firstIndex++][this.secondIndex];
            this.secondIndex = 0;
        }
        return res;
    }
}
