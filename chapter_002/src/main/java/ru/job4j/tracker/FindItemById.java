package ru.job4j.tracker;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class FindItemById implements UserAction {

    private int key;

    private String info;

    public FindItemById(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите ID заявки: ");
        Item item = tracker.findById(id);
        System.out.println(String.format("Name: %s, description: %s, id: %s",
                item.getName(), item.getDescription(), item.getId()));
    }

    @Override
    public String info() {
        return String.format("%d. %s", this.key, this.info);
    }
}
