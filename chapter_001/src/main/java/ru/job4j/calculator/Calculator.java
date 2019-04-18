package ru.job4j.calculator;

import java.util.Arrays;
import java.util.List;

/**
 * Класс для вычисления арифметических операций + - * /.
 *
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Calculator {

    private final List<String> listOperations = Arrays.asList("+", "-", "/", "*", "sin", "cos", "tan");

    private final List<String> oneOperandOperations = Arrays.asList("sin", "cos", "tan");

    public List<String> getListOperations() {
        return this.listOperations;
    }

    public List<String> getOneOperandOperations() {
        return this.oneOperandOperations;
    }

    /**
     * Сложение.
     *
     * @param first  первый аргумент.
     * @param second второй аргумент.
     */
    public double add(double first, double second) {
        return first + second;
    }

    /**
     * Вычитание.
     *
     * @param first  первый аргумент.
     * @param second второй аргумент.
     */
    public double subtract(double first, double second) {
        return first - second;
    }

    /**
     * Умножение.
     *
     * @param first  первый аргумент.
     * @param second второй аргумент.
     */
    public double multiply(double first, double second) {
        return first * second;
    }

    /**
     * Деление.
     *
     * @param first  первый аргумент.
     * @param second второй аргумент.
     */
    public double div(double first, double second) {
        return first / second;
    }

    /**
     * Calculating the sinus of angle.
     *
     * @param deg angle in degrees.
     * @return result.
     */
    public double sin(double deg) {
        return Math.sin(Math.toRadians(deg));
    }

    /**
     * Calculating the cosine of angle.
     *
     * @param deg angle in degrees.
     * @return result.
     */
    public double cos(double deg) {
        return Math.cos(Math.toRadians(deg));
    }

    /**
     * Calculating the tangent of angle.
     *
     * @param deg angle in degrees.
     * @return result.
     */
    public double tan(double deg) {
        return Math.tan(Math.toRadians(deg));
    }
}