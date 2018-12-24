package ru.job4j.tracker;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class DeleteItem implements UserAction {

    private int key;

    private String info;

    public DeleteItem(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите ID удаляемой заявки: ");
        tracker.delete(id);
    }

    @Override
    public String info() {
        return String.format("%d. %s", this.key, this.info);
    }
}
