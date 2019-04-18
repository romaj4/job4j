package ru.job4j.srp;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class InteractCalcTest {

    InteractCalc calc = new InteractCalc();

    @Test
    public void whenAdd7And8Then15() {
        double result = this.calc.calculation(7, "+", 8);
        double expected = 15d;
        assertThat(result, is(expected));
    }

    @Test
    public void whenSubtract34And16Then18() {
        double result = this.calc.calculation(34, "-", 16);
        double expected = 18d;
        assertThat(result, is(expected));
    }

    @Test
    public void whenMultiply6And8Then48() {
        double result = this.calc.calculation(6, "*", 8);
        double expected = 48d;
        assertThat(result, is(expected));
    }

    @Test
    public void whenDiv12And4Then3() {
        double result = this.calc.calculation(12, "/", 4);
        double expected = 3d;
        assertThat(result, is(expected));
    }

    @Test
    public void whenCos60Then05() {
        double result = this.calc.calculation(60, "cos", 0);
        double expected = 0.5000000000000001;
        assertThat(result, is(expected));
    }

    @Test
    public void whenSin30Then05() {
        double result = this.calc.calculation(30, "sin", 0);
        double expected = 0.49999999999999994;
        assertThat(result, is(expected));
    }

    @Test
    public void whenTan45Then1() {
        double result = this.calc.calculation(45, "tan", 0);
        double expected = 0.9999999999999999;
        assertThat(result, is(expected));
    }
}