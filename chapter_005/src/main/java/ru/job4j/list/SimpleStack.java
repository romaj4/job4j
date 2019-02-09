package ru.job4j.list;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class SimpleStack<T> {

    DynamicLinkedList<T> stack = new DynamicLinkedList<>();

    /**
     * Прмещает значение в коллекцию.
     *
     * @param value - значение.
     */
    public void push(T value) {
        this.stack.add(value);
    }

    /**
     * Возвращает значение и удаляет его из коллекции.
     *
     * @return значение.
     */
    public T poll() {
        return this.stack.deleteLast();
    }
}
