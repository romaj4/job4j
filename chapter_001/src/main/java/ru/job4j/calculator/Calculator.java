package ru.job4j.calculator;

/**
 * Класс для вычисления арифметических операций + - * /.
 *
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Calculator {
    private double result;

    /**
     * Сложение.
     *
     * @param first  первый аргумент.
     * @param second второй аргумент.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Вычитание.
     *
     * @param first  первый аргумент.
     * @param second второй аргумент.
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Умножение.
     *
     * @param first  первый аргумент.
     * @param second второй аргумент.
     */
    public void multiply(double first, double second) {
        this.result = first * second;
    }

    /**
     * Деление.
     *
     * @param first  первый аргумент.
     * @param second второй аргумент.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Получить результат.
     *
     * @return результат
     */
    public double getResult() {
        return this.result;
    }
}