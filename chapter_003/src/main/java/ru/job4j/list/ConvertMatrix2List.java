package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ConvertMatrix2List {

    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] arr : array) {
            for (int val : arr) {
                list.add(val);
            }
        }
        return list;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] arr : list) {
            for (int val : arr) {
                result.add(val);
            }
        }
        return result;
    }
}
