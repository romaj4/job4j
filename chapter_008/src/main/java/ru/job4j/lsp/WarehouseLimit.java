package ru.job4j.lsp;

import java.util.List;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class WarehouseLimit extends Storage {

    private final Warehouse warehouse;

    private final int capacity;

    public WarehouseLimit(int capacity) {
        this.warehouse = new Warehouse();
        this.capacity = capacity;
    }

    @Override
    public boolean addFood(Food food) {
        return this.warehouse.getListFood().size() < capacity && this.warehouse.addFood(food);
    }

    @Override
    public List<Food> getListFood() {
        return this.warehouse.getListFood();
    }
}
