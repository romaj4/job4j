package ru.job4j.isp;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class MenuUI {

    private final Input input;

    private final Menu menu = new Menu();

    public MenuUI(Input input) {
        this.input = input;
    }

    /**
     * Init the MenuUI.
     *
     * @return menu selection result.
     */
    public String init() {
        this.menu.fillMenuEntry();
        this.menu.show();
        String rst = menu.select(this.input.ask("Выберите пункт меню", this.menu.getMenuEntry().keySet()));
        System.out.println("Вы выбрали: " + rst);
        return rst;
    }

    public static void main(String[] args) {
        new MenuUI(new ConsoleInput()).init();
    }
}