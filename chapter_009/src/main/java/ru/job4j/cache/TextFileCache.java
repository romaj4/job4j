package ru.job4j.cache;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class TextFileCache implements Cache<String, String> {

    /**
     * File path.
     */
    private final String path;

    private Map<String, SoftReference<String>> cacheMap = new HashMap<>();

    public TextFileCache(String path) {
        this.path = path;
    }

    @Override
    public String get(String key) {
        if (!this.cacheMap.containsKey(key) || this.cacheMap.get(key) == null) {
            this.load(key);
        }
        return this.cacheMap.get(key).get();
    }

    @Override
    public void load(String key) {
        String value = null;
        try {
            value = new String(Files.readAllBytes(Paths.get(this.path + key)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.cacheMap.put(key, new SoftReference<>(value));
    }
}
