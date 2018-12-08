package ru.job4j.calculator;

/**
 * The program for calculating the ideal weight.
 */

public class Fit {

    /**
     * The ideal weight for man.
     *
     * @param height height.
     * @return the ideal weight
     */
    public double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * The ideal weight for woman.
     *
     * @param height height.
     * @return the ideal weight
     */
    public double womanWeight(double height) {
        return (height - 110) * 1.15;
    }
}
