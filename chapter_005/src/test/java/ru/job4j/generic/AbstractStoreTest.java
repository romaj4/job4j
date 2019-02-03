package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class AbstractStoreTest {

    @Test
    public void whenAddUser() {
        AbstractStore<User> absStore = new UserStore(new SimpleArray<>(5));
        User user1 = new User("1");
        User user2 = new User("2");
        User user3 = new User("3");
        absStore.add(user1);
        absStore.add(user2);
        absStore.add(user3);
        assertThat(absStore.findById("2"), is(user2));
    }

    @Test
    public void whenReplaceUser() {
        AbstractStore<User> absStore = new UserStore(new SimpleArray<>(5));
        User user1 = new User("1");
        User user2 = new User("2");
        User user3 = new User("3");
        User user4 = new User("10");
        absStore.add(user1);
        absStore.add(user2);
        absStore.add(user3);
        absStore.replace("2", user4);
        assertThat(absStore.findPositionById("10"), is(1));
        assertThat(absStore.findById("2"), is((User) null));
    }

    @Test
    public void whenDeleteRole() {
        AbstractStore<Role> absStore = new RoleStore(new SimpleArray<>(5));
        Role role1 = new Role("1");
        Role role2 = new Role("2");
        Role role3 = new Role("3");
        absStore.add(role1);
        absStore.add(role2);
        absStore.add(role3);
        absStore.delete("2");
        assertThat(absStore.findPositionById("3"), is(1));
        assertThat(absStore.findById("2"), is((Role) null));
    }

    @Test
    public void whenDeleteAndReplaceNotFindRole() {
        AbstractStore<Role> absStore = new RoleStore(new SimpleArray<>(5));
        Role role1 = new Role("1");
        Role role2 = new Role("2");
        absStore.add(role1);
        absStore.add(role2);
        assertThat(absStore.delete("10"), is(false));
        assertThat(absStore.replace("11", role1), is(false));
    }
}