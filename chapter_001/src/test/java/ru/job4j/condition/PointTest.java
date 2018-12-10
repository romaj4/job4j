package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class PointTest {

    @Test
    public void whenPoint22AndPoint56ThenDistance5() {
        Point a = new Point(2, 2);
        Point b = new Point(5, 6);
        double dist = a.distanceTo(b);
        assertThat(dist, closeTo(5, 0.1));
    }
}
