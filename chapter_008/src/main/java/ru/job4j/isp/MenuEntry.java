package ru.job4j.isp;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public abstract class MenuEntry {

    private final String name;

    public abstract void run();

    protected MenuEntry(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
