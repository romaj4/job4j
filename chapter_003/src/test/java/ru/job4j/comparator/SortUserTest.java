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
        List<User> list = List.of(
                new User("Roman", 33),
                new User("Petr", 28),
                new User("Ivan", 14)
        );
        TreeSet<User> result = (TreeSet<User>) sortUser.sort(list);
        assertThat(result.first().getName(), is("Ivan"));
        assertThat(result.last().getAge(), is(33));
    }

    @Test
    public void whenSortedByNameLength() {
        SortUser sortUser = new SortUser();
        List<User> list = List.of(
                new User("Roman", 33),
                new User("Petr", 28),
                new User("Vlaimir", 14)
        );
        List<User> result = sortUser.sortNameLength(list);
        assertThat(result.get(0).getName(), is("Petr"));
        assertThat(result.get(1).getName(), is("Roman"));
    }

    @Test
    public void whenSortedByAllFields() {
        SortUser sortUser = new SortUser();
        List<User> list = List.of(
                new User("Roman", 25),
                new User("Ivan", 30),
                new User("Roman", 20),
                new User("Ivan", 25)
        );
        List<User> result = sortUser.sortByAllFields(list);
        assertThat(result.get(0).getName(), is("Ivan"));
        assertThat(result.get(0).getAge(), is(25));
        assertThat(result.get(1).getName(), is("Ivan"));
        assertThat(result.get(2).getAge(), is(20));
    }
}