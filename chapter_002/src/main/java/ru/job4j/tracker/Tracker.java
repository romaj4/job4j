package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + new Random().nextInt(10000));
    }

    /**
     * Метод редактирует заявку.
     *
     * @param id   уникальный ключ.
     * @param item новая заявка.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        int position = this.findPositionById(id);
        if (position != -1) {
            item.setId(this.items[position].getId());
            this.items[position] = item;
            result = true;
        }
        return result;
    }

    /**
     * Метод удаляет заявку.
     *
     * @param id уникальный ключ.
     */
    public boolean delete(String id) {
        boolean result = false;
        int position = this.findPositionById(id);
        if (position != -1) {
            System.arraycopy(this.items, position + 1, this.items,
                    position, this.items.length - 1 - position);
            result = true;
            this.position--;
        }
        return result;
    }

    /**
     * Получение всех заявок.
     *
     * @return заявки.
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, this.position);
    }

    /**
     * Получение заявок по имени.
     *
     * @param name имя.
     * @return заявки.
     */
    public Item[] findByName(String name) {
        Item[] result = new Item[position];
        int count = 0;
        for (int i = 0; i < result.length; i++) {
            if (items[i].getName().equals(name)) {
                result[count++] = items[i];
            }
        }
        return Arrays.copyOf(result, count);
    }

    /**
     * Получение заявки по id.
     *
     * @param id уникальный ключ.
     * @return заявка.
     */
    public Item findById(String id) {
        int position = this.findPositionById(id);
        return (position != -1) ? items[position] : null;
    }

    /**
     * Получение позиции заявки в items по id.
     *
     * @param id уникальный ключ.
     * @return позиция заявки.
     */
    public int findPositionById(String id) {
        int result = -1;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                result = i;
                break;
            }
        }
        return result;
    }
}


