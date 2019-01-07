package ru.job4j.comparator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class SortUserTest {

    @Test
    public void whenAdd3Users() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        list.add(new User("Roman", 33));
        list.add(new User("Petr", 28));
        list.add(new User("Ivan", 14));
        TreeSet<User> result = (TreeSet<User>) sortUser.sort(list);
        assertThat(result.first().getName(), is("Ivan"));
        assertThat(result.last().getAge(), is(33));
    }
}