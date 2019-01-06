package ru.job4j.list;

import java.util.List;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ConvertList2Array {

    public int[][] toArray(List<Integer> list, int rows) {
        while (list.size() % rows != 0) {
            list.add(0);
        }
        int cells = list.size() / rows;
        int[][] array = new int[rows][cells];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                array[i][j] = list.get(count++);
            }
        }
        return array;
    }
}