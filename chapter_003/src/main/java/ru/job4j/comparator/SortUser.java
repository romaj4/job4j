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

    public List<User> sortNameLength(List<User> list) {
        list.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return o1.getName().length() - o2.getName().length();
                    }
                }
        );
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        list.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int temp = o1.getName().length() - o2.getName().length();
                        return (temp != 0) ? temp : (o1.getAge() - o2.getAge());
                    }
                }
        );
        return list;
    }
}
