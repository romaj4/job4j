package ru.job4j.search;

import java.util.LinkedList;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PriorityQueue {

    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        int number = this.tasks.size();
        if (number == 0 || this.tasks.get(number - 1).getPriority() < task.getPriority()) {
            this.tasks.add(task);
        } else {
            for (int i = 0; i < number; i++) {
                if (task.getPriority() < this.tasks.get(i).getPriority()) {
                    this.tasks.add(i, task);
                    break;
                }
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
