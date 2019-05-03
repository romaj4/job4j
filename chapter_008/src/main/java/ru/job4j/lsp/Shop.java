package ru.job4j.lsp;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Shop extends Storage {

    private final int discount;

    public Shop(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean addFood(Food food) {
        boolean rst = false;
        double foodResource = food.getResource();
        if (foodResource > 25 && foodResource <= 75) {
            rst = true;
            super.listFood.add(food);
        }
        if (foodResource > 75 && foodResource <= 100) {
            rst = true;
            food.setDiscount(this.discount);
            super.listFood.add(food);
        }
        return rst;
    }
}
