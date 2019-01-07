package ru.job4j.comparator;

import java.util.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class SortUser {

    public Set<User> sort(List<User> users) {
        Set<User> set = new TreeSet<>();
        for (User user : users) {
            set.add(user);
        }
        return set;
    }
}
