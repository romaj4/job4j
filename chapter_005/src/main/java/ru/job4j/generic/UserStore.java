package ru.job4j.generic;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class UserStore extends AbstractStore<User> {

    public UserStore(SimpleArray<User> store) {
        super(store);
    }
}
