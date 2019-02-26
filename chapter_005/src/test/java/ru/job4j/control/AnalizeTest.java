package ru.job4j.control;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class AnalizeTest {

    @Test
    public void whenAddAndChangeAndDeleteElements() {
        List<User> previousList = new ArrayList<>(
                Arrays.asList(new User(1, "user1"),
                        new User(2, "user2"),
                        new User(3, "user3"),
                        new User(4, "user4")));
        List<User> currentList = new ArrayList<>(
                Arrays.asList(new User(10, "user10"),
                        new User(2, "user2correct"),
                        new User(3, "user3"),
                        new User(4, "user4correct")));
        Analize.Info info = new Analize().diff(previousList, currentList);
        assertThat(info.getAdded(), is(1));
        assertThat(info.getChanged(), is(2));
        assertThat(info.getDeleted(), is(1));
    }
}