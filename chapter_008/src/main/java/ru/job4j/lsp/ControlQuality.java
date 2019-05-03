package ru.job4j.lsp;

import java.util.List;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ControlQuality {

    private final List<Storage> listStorage;

    public ControlQuality(List<Storage> listStorage) {
        this.listStorage = listStorage;
    }

    /**
     * Food distribution in storage.
     *
     * @param food food.
     */
    public void qualityFood(Food food) {
        for (Storage storage : this.listStorage) {
            if (storage.addFood(food)) {
                break;
            }
        }
    }
}
