package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<>() {
            Iterator<Integer> itNext = it.next();

            @Override
            public boolean hasNext() {
                while (!itNext.hasNext()) {
                    if (it.hasNext()) {
                        itNext = it.next();
                    } else {
                        break;
                    }
                }
                return itNext.hasNext();
            }

            @Override
            public Integer next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return itNext.next();
            }
        };
    }
}
