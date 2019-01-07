package ru.job4j.comparator;

import java.util.Comparator;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ListCompare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int res = 0;
        for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
            res = Character.compare(o1.charAt(i), o2.charAt(i));
            if (res != 0) {
                break;
            }
        }
        if (res == 0 && o1.length() != o2.length()) {
            res = o1.length() - o2.length();
        }
        return res;
    }
}