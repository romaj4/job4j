package ru.job4j.storage;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class UserStorageTest {

    @Test
    public void whenAddAndDeleteUsersThenResizeStorage() {
        UserStorage storage = new UserStorage();
        User user = new User(1, 100);
        storage.add(user);
        storage.add(new User(2, 300));
        assertThat(storage.getStorage().size(), is(2));
        assertTrue(storage.delete(user));
        assertThat(storage.getStorage().size(), is(1));
    }

    @Test
    public void whenUpdateAndDeleteUsersThenChangeAmount() {
        UserStorage storage = new UserStorage();
        storage.add(new User(1, 100));
        assertTrue(storage.update(new User(1, 200)));
        assertThat(storage.getStorage().get(1).getAmount(), is(200));
    }

    @Test
    public void whenTransferAndDeleteUsersThenChangeAmount() {
        UserStorage storage = new UserStorage();
        storage.add(new User(1, 100));
        storage.add(new User(2, 200));
        assertFalse(storage.transfer(1, 2, 150));
        assertTrue(storage.transfer(1, 2, 50));
        assertThat(storage.getStorage().get(1).getAmount(), is(50));
        assertThat(storage.getStorage().get(2).getAmount(), is(250));
    }
}