package ru.job4j.lsp;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ControlQualityTest {

    private long currentTime = System.currentTimeMillis();

    private long dayMillis = 24 * 60 * 60 * 1000;

    @Test
    public void whenAddSomeFoodsThenResult() {
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

    @Test
    public void whenAddReproductionFoodsThenResult() {
        Storage warehouse1 = new WarehouseLimit(2);
        Storage warehouse2 = new WarehouseLimit(2);
        Storage shop = new Shop(30);
        Storage processing = new Processing();
        Storage trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(Arrays.asList(warehouse1, warehouse2, shop, processing, trash));
        List<Food> listFoods = Arrays.asList(
                new ReproductionFood("Fish", currentTime - 2 * dayMillis, currentTime + 10 * dayMillis, 100, false, false),
                new ReproductionFood("Meat", currentTime - 2 * dayMillis, currentTime + 10 * dayMillis, 200, false, false),
                new ReproductionFood("Apple", currentTime - 2 * dayMillis, currentTime + 10 * dayMillis, 300, false, false),
                new ReproductionFood("Orange", currentTime - 10 * dayMillis, currentTime + 10 * dayMillis, 400, false, false),
                new ReproductionFood("Banana", currentTime - 10 * dayMillis, currentTime - dayMillis, 400, true, false),
                new ReproductionFood("Lemon", currentTime - 10 * dayMillis, currentTime - dayMillis, 400, false, false),
                new ReproductionFood("Potato", currentTime - 10 * dayMillis, currentTime - dayMillis, 400, true, true)
        );
        for (Food food : listFoods) {
            controlQuality.qualityFood(food);
        }
        assertThat(warehouse1.getListFood().size(), is(2));
        assertThat(warehouse2.getListFood().size(), is(1));
        assertThat(shop.getListFood().size(), is(1));
        assertThat(trash.getListFood().size(), is(1));
        assertThat(processing.getListFood().size(), is(2));
        Storage warehouseLowTemp = new WarehouseLowTemp((Processing) processing, 1);
        List<Food> listProcessing = processing.getListFood();
        for (int i = 0; i < listProcessing.size(); i++) {
            warehouseLowTemp.addFood(listProcessing.get(i));
        }
        assertThat(processing.getListFood().size(), is(1));
        assertThat(warehouseLowTemp.getListFood().size(), is(1));
    }

    @Test
    public void whenAddAndResortFoodsThenResult() {
        Storage warehouse = new Warehouse();
        Storage shop = new Shop(30);
        Storage trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(Arrays.asList(warehouse, shop, trash));
        List<Food> listFoods = Arrays.asList(
                new Food("Fish", currentTime - 10 * dayMillis, currentTime + dayMillis, 100),
                new Food("Apple", currentTime - 2 * dayMillis, currentTime + 10 * dayMillis, 300),
                new Food("Orange", currentTime - 10 * dayMillis, currentTime + 2 * dayMillis, 400),
                new Food("Banana", currentTime - 10 * dayMillis, currentTime - dayMillis, 400)
        );
        for (Food food : listFoods) {
            controlQuality.qualityFood(food);
        }
        assertThat(warehouse.getListFood().size(), is(1));
        assertThat(shop.getListFood().size(), is(2));
        assertThat(trash.getListFood().size(), is(1));
        controlQuality.resort();
        assertThat(warehouse.getListFood().size(), is(1));
        assertThat(shop.getListFood().size(), is(2));
        assertThat(trash.getListFood().size(), is(1));
    }
}