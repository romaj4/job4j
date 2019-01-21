package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ConvertMatrix2List {

    public List<Integer> toList(int[][] array) {
        return Arrays.stream(array).flatMapToInt(Arrays::stream).boxed().collect(Collectors.toList());
    }

    public List<Integer> convert(List<int[]> list) {
        return list.stream().flatMapToInt(Arrays::stream).boxed().collect(Collectors.toList());
    }
}
