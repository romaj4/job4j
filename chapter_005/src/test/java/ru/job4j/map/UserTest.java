package ru.job4j.map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class UserTest {

    @Test
    public void whenAdd2UsersWithSameValue() {
        User user1 = new User("Roma", 2, new GregorianCalendar(1986, 2, 20));
        User user2 = new User("Roma", 2, new GregorianCalendar(1986, 2, 20));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, "User1");
        map.put(user2, "User2");
        System.out.println(map);
    }
}