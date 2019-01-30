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
        return this.numberNextEvenElement(this.index, this.numbers) != -1;
    }

    @Override
    public Integer next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        int temp = this.numberNextEvenElement(this.index, this.numbers);
        this.index = temp + 1;
        return this.numbers[temp];
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
