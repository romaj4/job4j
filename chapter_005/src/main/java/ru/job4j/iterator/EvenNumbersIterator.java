package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class EvenNumbersIterator implements Iterator<Integer> {

    private final int[] numbers;

    private int index = 0;

    public EvenNumbersIterator(final int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        boolean rst = false;
        int nextIndex = this.numberNextEvenElement(this.index, this.numbers);
        if (nextIndex != -1) {
            rst = true;
            this.index = nextIndex;
        }
        return rst;
    }

    @Override
    public Integer next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return this.numbers[this.index++];
    }

    private int numberNextEvenElement(int position, int[] arr) {
        int res = -1;
        for (int i = position; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                res = i;
                break;
            }
        }
        return res;
    }
}
