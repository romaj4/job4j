package ru.job4j.lsp;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ControlQualityTest {

    @Test
    public void whenAddSomeFoodsThenResult() {
        long currentTime = System.currentTimeMillis();
        long dayMillis = 24 * 60 * 60 * 1000;
        Storage warehouse = new Warehouse();
        Storage shop = new Shop(30);
        Storage trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(Arrays.asList(warehouse, shop, trash));
        List<Food> listFoods = Arrays.asList(
                new Food("Fish", currentTime - 10 * dayMillis, currentTime + dayMillis, 100),
                new Food("Meat", currentTime - 10 * dayMillis, currentTime + 4 * dayMillis, 200),
                new Food("Apple", currentTime - 2 * dayMillis, currentTime + 10 * dayMillis, 300),
                new Food("Orange", currentTime - 10 * dayMillis, currentTime + 2 * dayMillis, 400),
                new Food("Banana", currentTime - 10 * dayMillis, currentTime - dayMillis, 400)
        );
        for (Food food : listFoods) {
            controlQuality.qualityFood(food);
        }
        assertThat(warehouse.getListFood().size(), is(1));
        assertThat(shop.getListFood().size(), is(3));
        assertThat(trash.getListFood().size(), is(1));
        assertThat(listFoods.get(3).getPrice(), is(280));
    }

}