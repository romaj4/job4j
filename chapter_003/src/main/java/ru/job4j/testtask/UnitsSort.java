package ru.job4j.testtask;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class UnitsSort {

    public String[] sortUnits(String[] src) {
        Set<String> set = new TreeSet<>();
        String del = "/";
        for (int i = 0; i < src.length; i++) {
            String[] splitStr = src[i].split(del);
            String temp = splitStr[0];
            set.add(temp);
            for (int j = 1; j < splitStr.length; j++) {
                temp = temp.concat(del).concat(splitStr[j]);
                set.add(temp);
            }
        }
        return set.toArray(new String[]{});
    }

    public String[] reverseSortUnits(String[] src) {
        String[] units = this.sortUnits(src);
        Comparator<String> strCompare = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int minLen = Math.min(o1.length(), o2.length());
                int comp = 0;
                for (int i = 0; i < minLen && comp == 0; i++) {
                    comp = o2.toCharArray()[i] - o1.toCharArray()[i];
                }
                return comp == 0 ? o1.length() - o2.length() : comp;
            }
        };
        Arrays.sort(units, strCompare);
        return units;
    }
}
