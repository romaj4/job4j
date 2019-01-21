package ru.job4j.comparator;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class SortUser {

    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }

    public List<User> sortNameLength(List<User> list) {
        return list.stream().sorted(Comparator.comparingInt(o -> o.getName().length())).collect(Collectors.toList());
    }

    public List<User> sortByAllFields(List<User> list) {
        return list.stream().sorted((o1, o2) -> {
            int temp = o1.getName().length() - o2.getName().length();
            return (temp != 0) ? temp : (o1.getAge() - o2.getAge());
        }).collect(Collectors.toList());
    }
}
