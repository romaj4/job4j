package ru.job4j.tdd;

import java.util.Map;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public interface Template {

    String generate(String template, Map<String, String> map);
}
