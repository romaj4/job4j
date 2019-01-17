package ru.job4j.testtask;

import java.util.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class UnitsSort {

    /**
     * Сортировка подразделений по возрастанию.
     *
     * @param src массив подразделений.
     * @return отсортированный массив.
     */
    public String[] sortUnits(String[] src) {
        String[] units = this.insertUnits(src);
        Arrays.sort(units);
        return units;
    }

    /**
     * Сортировка подразделений по убыванию.
     *
     * @param src массив подразделений.
     * @return отсортированный массив.
     */
    public String[] reverseSortUnits(String[] src) {
        String[] units = this.insertUnits(src);
        Comparator<String> strCompare = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int minLen = Math.min(o1.length(), o2.length());
                char[] str1 = o1.toCharArray();
                char[] str2 = o2.toCharArray();
                int comp = 0;
                for (int i = 0; i < minLen && comp == 0; i++) {
                    comp = str2[i] - str1[i];
                }
                return comp == 0 ? o1.length() - o2.length() : comp;
            }
        };
        Arrays.sort(units, strCompare);
        return units;
    }

    /**
     * Втавка кода всех подразделений структуры.
     *
     * @param src массив подразделений.
     * @return массив всех подразделений структуры.
     */
    public String[] insertUnits(String[] src) {
        Set<String> set = new HashSet<>();
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
}
