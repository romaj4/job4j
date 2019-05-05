package ru.job4j.isp;

import java.util.Set;

public class TestInput implements Input {

    private final String value;

    public TestInput(String value) {
        this.value = value;
    }

    @Override
    public String ask(String question, Set<String> keySet) {
        String key = this.value;
        if (!keySet.contains(key)) {
            throw new IllegalArgumentException("Такой пункт меню отсутствует");
        }
        return key;
    }
}
