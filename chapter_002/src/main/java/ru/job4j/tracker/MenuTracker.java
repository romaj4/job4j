package ru.job4j.tracker;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class MenuTracker {

    private Input input;

    private Tracker tracker;

    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public int getActionsLentgh() {
        return this.actions.size();
    }

    public void fillActions() {
        this.actions.add(new AddItem(0, "Add new Item"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new UpdateItem(2, "Edit item"));
        this.actions.add(new DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit Program"));
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        System.out.println("Меню");
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
        System.out.println();
    }

    private class AddItem implements UserAction {

        private int key;

        private String info;

        public AddItem(int key, String info) {
            this.key = key;
            this.info = info;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Adding new item --------------");
            String name = input.ask("Please, provide item name:");
            String desc = input.ask("Please, provide item description:");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ New Item with Id : " + item.getId());
            System.out.println("------------ New Item with Name : " + item.getName());
            System.out.println("------------ New Item with Description : " + item.getDescription());
        }

        @Override
        public String info() {
            return String.format("%d. %s", this.key, this.info);
        }
    }

    private class ShowItems implements UserAction {

        private int key;

        private String info;

        public ShowItems(int key, String info) {
            this.key = key;
            this.info = info;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.println(String.format("Name: %s, description: %s, id: %s",
                        item.getName(), item.getDescription(), item.getId()));
            }
        }

        @Override
        public String info() {
            return String.format("%d. %s", this.key, this.info);
        }
    }

    private class UpdateItem implements UserAction {

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

    private class DeleteItem implements UserAction {

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

    private class FindItemById implements UserAction {

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

    private class FindItemsByName implements UserAction {

        private int key;

        private String info;

        public FindItemsByName(int key, String info) {
            this.key = key;
            this.info = info;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки: ");
            for (Item item : tracker.findByName(name)) {
                System.out.println(String.format("Name: %s, description: %s, id: %s",
                        item.getName(), item.getDescription(), item.getId()));
            }
        }

        @Override
        public String info() {
            return String.format("%d. %s", this.key, this.info);
        }
    }

    private class ExitProgram implements UserAction {

        private int key;

        private String info;

        public ExitProgram(int key, String info) {
            this.key = key;
            this.info = info;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }

        @Override
        public String info() {
            return String.format("%d. %s", this.key, this.info);
        }
    }
}


