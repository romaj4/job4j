package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class UserConvertTest {

    @Test
    public void whenAdd2Users() {
        UserConvert userConvert = new UserConvert();
        List<User> list = new ArrayList<>();
        list.add(new User(1111, "Ivan", "Moskva"));
        list.add(new User(2222, "Petr", "Minsk"));
        HashMap<Integer, User> result = userConvert.process(list);
        assertThat(result.get(1111).getName(), is("Ivan"));
        assertThat(result.get(2222).getCity(), is("Minsk"));
    }
}