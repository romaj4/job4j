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
        Set<String> units = new TreeSet<>(this.insertUnits(src));
        return units.toArray(new String[]{});
    }

    /**
     * Сортировка подразделений по убыванию.
     *
     * @param src массив подразделений.
     * @return отсортированный массив.
     */
    public String[] reverseSortUnits(String[] src) {
        String[] units = this.insertUnits(src).toArray(new String[]{});
        Comparator<String> strCompare = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int minLen = Math.min(o1.length(), o2.length());
                String str1 = o1.substring(0, minLen);
                String str2 = o2.substring(0, minLen);
                int comp = str2.compareTo(str1);
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
    public Set<String> insertUnits(String[] src) {
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
        return set;
    }
}
