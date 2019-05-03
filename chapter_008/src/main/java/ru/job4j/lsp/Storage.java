package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public abstract class Storage {

    List<Food> listFood = new ArrayList<>();

    public List<Food> getListFood() {
        return this.listFood;
    }

    /**
     * Add food to storage.
     *
     * @param food food.
     * @return result.
     */
    public abstract boolean addFood(Food food);
}
