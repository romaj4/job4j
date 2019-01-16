package ru.job4j.testtask;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class UnitsSortTest {

    @Test
    public void whenSortCodesUnit() {
        UnitsSort unitsSort = new UnitsSort();
        String[] src = new String[]{"K1/SK1", "K1/SK2", "K1/SK1/SSK1", "K1/SK1/SSK2", "K2", "K2/SK1/SSK1", "K2/SK1/SSK2"};
        String[] sortCode = unitsSort.sortUnits(src);
        assertThat(sortCode[0], is("K1"));
        assertThat(sortCode[1], is("K1/SK1"));
        assertThat(sortCode[2], is("K1/SK1/SSK1"));
        assertThat(sortCode[3], is("K1/SK1/SSK2"));
        assertThat(sortCode[4], is("K1/SK2"));
        assertThat(sortCode[5], is("K2"));
        assertThat(sortCode[6], is("K2/SK1"));
        assertThat(sortCode[7], is("K2/SK1/SSK1"));
        assertThat(sortCode[8], is("K2/SK1/SSK2"));
    }

    @Test
    public void whenSortReverseCodesUnit() {
        UnitsSort unitsSort = new UnitsSort();
        String[] src = new String[]{"K1/SK1", "K1/SK2", "K1/SK1/SSK1", "K1/SK1/SSK2", "K2", "K2/SK1/SSK1", "K2/SK1/SSK2"};
        String[] sortCode = unitsSort.reverseSortUnits(src);
        assertThat(sortCode[0], is("K2"));
        assertThat(sortCode[1], is("K2/SK1"));
        assertThat(sortCode[2], is("K2/SK1/SSK2"));
        assertThat(sortCode[3], is("K2/SK1/SSK1"));
        assertThat(sortCode[4], is("K1"));
        assertThat(sortCode[5], is("K1/SK2"));
        assertThat(sortCode[6], is("K1/SK1"));
        assertThat(sortCode[7], is("K1/SK1/SSK2"));
        assertThat(sortCode[8], is("K1/SK1/SSK1"));
    }
}