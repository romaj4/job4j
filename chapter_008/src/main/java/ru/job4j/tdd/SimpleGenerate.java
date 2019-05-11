package ru.job4j.tdd;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class SimpleGenerate implements Template {

    private static final Pattern KEYS = Pattern.compile("\\$\\{\\w*}");

    /**
     * Parses the string by pattern and returns the modified string.
     *
     * @param template template.
     * @param keysMap  map of keys - value.
     * @return modified string.
     */
    @Override
    public String generate(String template, Map<String, String> keysMap) {
        Matcher matcher = this.KEYS.matcher(template);
        while (matcher.find()) {
            String expression = matcher.group();
            String key = expression.substring(2, expression.length() - 1);
            if (!keysMap.containsKey(key)) {
                throw new NoSuchElementException("No such key");
            }
            template = template.replace(expression, keysMap.get(key));
            keysMap.remove(key);
            matcher = this.KEYS.matcher(template);
        }
        if (keysMap.size() > 0) {
            throw new IllegalStateException("There are extra keys in map");
        }
        return template;
    }
}
