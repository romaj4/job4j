package ru.job4j.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class CountFunctionTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        CountFunction function = new CountFunction();
        List<Double> result = function.diapason(2, 5, x -> 4 * x + 3);
        List<Double> expected = Arrays.asList(11D, 15D, 19D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        CountFunction function = new CountFunction();
        List<Double> result = function.diapason(3, 6, x -> 3 * x * x - 2 * x + 4);
        List<Double> expected = Arrays.asList(25D, 44D, 69D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunction() {
        CountFunction function = new CountFunction();
        List<Double> result = function.diapason(3, 6, Math::log);
        List<Double> expected = Arrays.asList(Math.log(3), Math.log(4), Math.log(5));
        assertThat(result, is(expected));
    }
}