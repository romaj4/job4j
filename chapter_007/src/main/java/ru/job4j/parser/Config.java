package ru.job4j.parser;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Config {

    private final Properties values = new Properties();

    public Config() {
        this.init();
    }

    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("sqlru.properties")) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public String getValue(String key) {
        return this.values.getProperty(key);
    }
}
