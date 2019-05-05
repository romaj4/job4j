package ru.job4j.isp;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Menu {

    private Map<String, MenuEntry> menuEntry = new LinkedHashMap<>();

    public void fillMenuEntry() {
        this.menuEntry.put("1", new Task("Задача"));
        this.menuEntry.put("1.1", new Task("Задача"));
        this.menuEntry.put("1.1.1", new Task("Задача"));
        this.menuEntry.put("1.1.2", new Task("Задача"));
        this.menuEntry.put("1.2", new Task("Задача"));
        this.menuEntry.put("2", new Task("Задача"));
        this.menuEntry.put("2.1", new Task("Задача"));
        this.menuEntry.put("2.2", new Task("Задача"));
    }

    /**
     * Show the menu in the tree structure.
     */
    public void show() {
        String separator = "-";
        System.out.println("Меню:");
        for (String key : this.menuEntry.keySet()) {
            StringBuilder menuItem = new StringBuilder();
            for (int i = 0; i < key.length() - 1; i++) {
                menuItem.append(separator);
            }
            menuItem.append(this.menuEntry.get(key).getName()).append(" ").append(key);
            System.out.println(menuItem.toString());
        }
    }

    /**
     * Menu item selection.
     *
     * @param key key.
     * @return result.
     */
    public String select(String key) {
        this.menuEntry.get(key).run();
        return key;
    }

    public Map<String, MenuEntry> getMenuEntry() {
        return this.menuEntry;
    }

    private class Task extends MenuEntry {

        private Task(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("Run " + super.getName());
        }
    }
}
