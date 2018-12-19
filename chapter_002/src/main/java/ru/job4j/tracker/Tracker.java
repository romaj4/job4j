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
    public void replace(String id, Item item) {
        this.items[this.findPositionById(id)] = item;
    }

    /**
     * Метод удаляет заявку.
     *
     * @param id уникальный ключ.
     */
    public void delete(String id) {
        System.arraycopy(this.items, this.findPositionById(id)+1, this.items, this.findPositionById(id),
                this.items.length - 1 - this.findPositionById(id));
    }

    /**
     * Получение всех заявок.
     *
     * @return заявки.
     */
    public Item[] findAll() {
        Item[] result = new Item[position];
        for (int i = 0; i < result.length; i++) {
            result[i] = this.items[i];
        }
        return result;
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
        return (this.findPositionById(id) != -1) ? items[this.findPositionById(id)] : null;
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


