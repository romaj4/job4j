package ru.job4j.lsp;

import java.util.List;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Processing extends Storage {

    private final Trash trash;

    public Processing() {
        this.trash = new Trash();
    }

    @Override
    public boolean addFood(Food food) {
        ReproductionFood reproductionFood = (ReproductionFood) food;
        return reproductionFood.isCanReproduction() && this.trash.addFood(reproductionFood);
    }

    @Override
    public List<Food> getListFood() {
        return this.trash.getListFood();
    }
}
