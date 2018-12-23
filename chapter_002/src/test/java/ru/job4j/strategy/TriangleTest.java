package ru.job4j.strategy;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {

    @Test
    public void whenDrawTriangle(){
        Triangle triangle = new Triangle();
        String ln = System.lineSeparator();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("   +   ")
                                .append(ln)
                                .append("  +++  ")
                                .append(ln)
                                .append(" +++++ ")
                                .append(ln)
                                .append("+++++++")
                                .toString())
        );
    }
}