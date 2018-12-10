package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class MaxTest {

    @Test
    public void whenFirstLessSecond() {
        Max maximum = new Max();
        int result = maximum.max(8, 25);
        assertThat(result, is(25));
    }

    @Test
    public void whenFirstMoreSecond() {
        Max maximum = new Max();
        int result = maximum.max(64, 31);
        assertThat(result, is(64));
    }

    @Test
    public void whenEqualSecond() {
        Max maximum = new Max();
        int result = maximum.max(19, 19);
        assertThat(result, is(19));
    }

    @Test
    public void whenSetMax892ThenMax9() {
        Max maximum = new Max();
        int result = maximum.max(8, 9, 2);
        assertThat(result, is(9));
    }
}
