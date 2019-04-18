package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class CalculatorTest {
    /**
     * Test Calculator.
     */
    @Test
    public void whenAdd7And8Then15() {
        Calculator calc = new Calculator();
        double result = calc.add(7d, 8d);
        double expected = 15d;
        assertThat(result, is(expected));
    }

    @Test
    public void whenSubtract34And16Then18() {
        Calculator calc = new Calculator();
        double result = calc.subtract(34d, 16d);
        double expected = 18d;
        assertThat(result, is(expected));
    }

    @Test
    public void whenMultiply6And8Then48() {
        Calculator calc = new Calculator();
        double result = calc.multiply(6d, 8d);
        double expected = 48d;
        assertThat(result, is(expected));
    }

    @Test
    public void whenDiv12And4Then3() {
        Calculator calc = new Calculator();
        double result = calc.div(12d, 4d);
        double expected = 3d;
        assertThat(result, is(expected));
    }
}