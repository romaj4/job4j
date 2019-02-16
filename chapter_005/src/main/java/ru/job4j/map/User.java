package ru.job4j.map;

import java.util.Calendar;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class User {

    private String name;

    private int children;

    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "name: " + name + '\''
                + ", children: " + children
                + ", birthday: " + birthday.toInstant();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return this.children == user.children
                && this.name.equals(user.name)
                && this.birthday.equals(user.birthday);
    }

    @Override
    public int hashCode() {
        int result = 17 + this.children;
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.birthday.hashCode();
        return result;
    }
}
