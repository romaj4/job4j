package ru.job4j.tracker;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class StartUI {

    private static final String ADD = "0";

    private static final String SHOWALL = "1";

    private static final String EDIT = "2";

    private static final String DELETE = "3";

    private static final String FINDBYID = "4";

    private static final String FINDBYNAME = "5";

    private static final String EXIT = "6";

    private final Input input;

    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOWALL.equals(answer)) {
                this.showAll();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDBYID.equals(answer)) {
                this.findById();
            } else if (FINDBYNAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    private void findByName() {
        String name = this.input.ask("Введите имя заявки: ");
        for (Item item : this.tracker.findByName(name)) {
            showItem(item);
        }
    }

    private void findById() {
        String id = this.input.ask("Введите ID заявки: ");
        showItem(this.tracker.findById(id));
    }

    private void deleteItem() {
        String id = this.input.ask("Введите ID удаляемой заявки: ");
        this.tracker.delete(id);
    }

    private void editItem() {
        String id = this.input.ask("Введите ID редактируемой заявки: ");
        String name = this.input.ask("Введите имя новой заявки :");
        String desc = this.input.ask("Введите описание новой заявки :");
        Item item = new Item(name, desc);
        this.tracker.replace(id, item);
    }

    private void showAll() {
        for (Item item : this.tracker.findAll()) {
            showItem(item);
        }
    }

    private void showItem(Item item) {
        System.out.println("Name: " + item.getName() + "  description: "
                + item.getDescription() + " id:" + item.getId());
    }

    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item\n"
                + "1. Show all items\n"
                + "2. Edit item\n"
                + "3. Delete item\n"
                + "4. Find item by Id\n"
                + "5. Find items by name\n"
                + "6. Exit Program");
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
