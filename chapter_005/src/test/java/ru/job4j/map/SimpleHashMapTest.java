package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class SimpleHashMapTest {

    SimpleHashMap<String, String> map;

    @Before
    public void start() {
        map = new SimpleHashMap<>();
        map.insert("France", "Paris");
        map.insert("Germany", "Berlin");
        map.insert("Spain", "Madrid");
    }

    @Test
    public void whenAddElement() {
        map.insert("Belarus", "Minsk");
        assertThat(map.size(), is(4));
    }

    @Test
    public void whenDeleteElement() {
        map.delete("France");
        assertThat(map.size(), is(2));
    }

    @Test
    public void whenGetElement() {
        assertThat(map.get("Spain"), is("Madrid"));
    }

    @Test
    public void whenGetElementWithIncorrectKey() {
        assertThat(map.get("Russia"), is((String) null));
    }

    @Test
    public void whenAddElementWithSameKey() {
        assertThat(map.insert("Germany", "Bern"), is(false));
    }

    @Test
    public void whenAllElementsIterate() {
        Iterator<SimpleHashMap.Entry> iterator = map.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next().getValue(), is("Berlin"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next().getValue(), is("Madrid"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next().getValue(), is("Paris"));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenModifyListIterator() {
        Iterator<SimpleHashMap.Entry> it = map.iterator();
        it.next();
        map.insert("Belarus", "Minsk");
        it.next();
    }
}