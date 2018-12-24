package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class StartUI {

    private final Input input;

    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        while (true) {
            menu.show();
            int answer = Integer.parseInt(input.ask("Введите пункт меню : "));
            menu.select(answer);
            if (answer == 6) break;
        }
    }

    public String showMenu() {
        StringBuilder st = new StringBuilder();
        String ln = System.lineSeparator();
        st.append("Меню" + ln)
                .append("0. Add new Item" + ln)
                .append("1. Show all items" + ln)
                .append("2. Edit item" + ln)
                .append("3. Delete item" + ln)
                .append("4. Find item by Id" + ln)
                .append("5. Find items by name" + ln)
                .append("6. Exit Program" + ln);
        return st.toString();
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
