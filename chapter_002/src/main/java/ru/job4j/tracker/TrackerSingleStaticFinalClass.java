package ru.job4j.tracker;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class TrackerSingleStaticFinalClass {

    private TrackerSingleStaticFinalClass() {
    }

    public static TrackerSingleStaticFinalClass getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingleStaticFinalClass INSTANCE = new TrackerSingleStaticFinalClass();
    }

    Tracker tracker = new Tracker();

    public Item add(Item item) {
        return this.tracker.add(item);
    }

    public boolean replace(String id, Item item) {
        return this.tracker.replace(id, item);
    }

    public boolean delete(String id) {
        return this.tracker.delete(id);
    }

    public Item[] findAll() {
        return this.tracker.findAll();
    }

    public Item[] findByName(String name) {
        return this.tracker.findByName(name);
    }

    public Item findById(String id) {
        return this.tracker.findById(id);
    }

    public int findPositionById(String id) {
        return this.tracker.findPositionById(id);
    }
}
