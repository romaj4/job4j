package ru.job4j.list;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class SimpleQueue<T> {

    private SimpleStack<T> inputStack = new SimpleStack<>();

    private SimpleStack<T> outputStack = new SimpleStack<>();

    private int inputSize;

    private int outputSize;

    /**
     * Помещает значение в коллекцию.
     *
     * @param value - значение.
     */
    public void push(T value) {
        this.inputStack.push(value);
        this.inputSize++;
    }

    /**
     * Возвращает значение и удаляет его из коллекции.
     *
     * @return значение.
     */
    public T poll() {
        if (this.outputSize == 0) {
            while (this.inputSize != 0) {
                this.outputStack.push(this.inputStack.poll());
                this.inputSize--;
                this.outputSize++;
            }
        }
        this.outputSize--;
        return this.outputStack.poll();
    }
}
