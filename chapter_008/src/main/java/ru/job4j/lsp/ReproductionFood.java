package ru.job4j.lsp;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ReproductionFood extends Food {

    private final boolean canReproduction;

    private final boolean isVegetable;

    public ReproductionFood(String name, long createDate, long expiryDate, int price, boolean canReproduction, boolean isVegetable) {
        super(name, createDate, expiryDate, price);
        this.canReproduction = canReproduction;
        this.isVegetable = isVegetable;
    }

    public boolean isCanReproduction() {
        return canReproduction;
    }

    public boolean isVegetable() {
        return isVegetable;
    }
}
