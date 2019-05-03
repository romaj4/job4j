package ru.job4j.lsp;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Trash extends Storage {

    @Override
    public boolean addFood(Food food) {
        boolean rst = false;
        if (food.getResource() > 100) {
            rst = true;
            super.listFood.add(food);
        }
        return rst;
    }
}
