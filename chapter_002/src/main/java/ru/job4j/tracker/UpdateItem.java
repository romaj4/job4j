package ru.job4j.tracker;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class UpdateItem implements UserAction {

    private int key;

    private String info;

    public UpdateItem(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите ID редактируемой заявки: ");
        String name = input.ask("Введите имя новой заявки :");
        String desc = input.ask("Введите описание новой заявки :");
        Item item = new Item(name, desc);
        tracker.replace(id, item);
    }

    @Override
    public String info() {
        return String.format("%d. %s", this.key, this.info);
    }
}
