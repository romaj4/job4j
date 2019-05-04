package ru.job4j.lsp;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class WarehouseLowTemp extends Storage {

    private final Processing processing;

    private final int minTemp;

    public WarehouseLowTemp(Processing processing, int minTemp) {
        this.processing = processing;
        this.minTemp = minTemp;
    }

    @Override
    public boolean addFood(Food food) {
        ReproductionFood reproductionFood = (ReproductionFood) food;
        boolean rst = false;
        if (reproductionFood.isVegetable()) {
            super.listFood.add(reproductionFood);
            this.processing.getListFood().remove(reproductionFood);
            rst = true;
        }
        return rst;
    }
}
