package ru.job4j.tracker;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class StartUI {

    private int[] ranges;

    private final Input input;

    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        ranges = new int[menu.getActionsLentgh()];
        for (int i = 0; i < ranges.length; i++) {
            ranges[i] = i;
        }
        while (true) {
            menu.show();
            int answer = input.ask("Введите пункт меню : ", ranges);
            menu.select(answer);
            if (answer == 6) break;
        }
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}
