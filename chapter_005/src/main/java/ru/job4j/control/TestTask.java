package ru.job4j.control;

import java.util.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class TestTask {

    /**
     * Сравнивает состоят ли два слова из одинаковых символов.
     *
     * @param first  первое сово.
     * @param second второе слово.
     * @return рузультат.
     */
    public boolean compareStructureWords(String first, String second) {
        return this.getMapFromString(first).equals(this.getMapFromString(second));
    }

    /**
     * Возвращает все дубликаты в слове.
     *
     * @param str проверяемое слово.
     * @return список дубликато символов.
     */
    public List<Character> duplicatedSymbols(String str) {
        Map<Character, Integer> map = this.getMapFromString(str);
        List<Character> rst = new ArrayList<>();
        int i = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                rst.add(entry.getKey());
            }
        }
        return rst;
    }

    /**
     * Проверяет что два слова отличаются на одну перестановку символов.
     *
     * @param first  первое слово.
     * @param second второе слово.
     * @return результат.
     */
    public boolean differByOnePermutation(String first, String second) {
        List<Character> differSymbols = new ArrayList<>();
        if (first.length() == second.length()) {
            for (int i = 0; i < first.length(); i++) {
                if (!(first.charAt(i) == second.charAt(i))) {
                    differSymbols.add(first.charAt(i));
                    differSymbols.add(second.charAt(i));
                }
            }
        }
        return differSymbols.size() == 4 && differSymbols.get(0).equals(differSymbols.get(3))
                && differSymbols.get(1).equals(differSymbols.get(2));

    }

    /**
     * Возвращает коллекцию уникальных символов из слова.
     * Считает количество повторений для каждого символа.
     *
     * @param str слово.
     * @return map.
     */
    public Map<Character, Integer> getMapFromString(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char symbol = str.charAt(i);
            if (!map.containsKey(symbol)) {
                map.put(symbol, 1);
            } else {
                map.put(symbol, map.get(symbol) + 1);
            }
        }
        return map;
    }
}
