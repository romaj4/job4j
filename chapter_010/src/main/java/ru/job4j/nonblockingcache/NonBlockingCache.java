package ru.job4j.nonblockingcache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class NonBlockingCache {

    private final ConcurrentHashMap<Integer, Base> map = new ConcurrentHashMap<>();

    public Base add(Base model) {
        return this.map.put(model.getId(), model);
    }

    public boolean update(Base model) {
        int key = model.getId();
        Base res = map.computeIfPresent(key, (k, v) -> {
            if (map.get(key).getVersion() != model.getVersion()) {
                throw new OptimisticException("Model modified");
            }
            model.incrVersion();
            return model;
        });
        return res != null;
    }

    public Base delete(Base model) {
        return this.map.remove(model.getId());
    }

    public Base getModel(int id) {
        return this.map.get(id);
    }
}
