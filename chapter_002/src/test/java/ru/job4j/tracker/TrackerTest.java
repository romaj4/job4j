package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription1");
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription1");
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2");
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteNameThenTrackerHasAnotherItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1");
        Item item2 = new Item("test2", "testDescription2");
        Item item3 = new Item("test3", "testDescription3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.delete(item2.getId());
        assertThat(tracker.findAll()[1], is(item3));
    }

    @Test
    public void whenFindAllNameThenTrackerReturnAllName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1");
        Item item2 = new Item("test2", "testDescription2");
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findAll()[0], is(item1));
        assertThat(tracker.findAll()[1], is(item2));
        assertThat(tracker.findAll().length, is(2));
    }

    @Test
    public void whenFindByNameThenTrackerReturnArrayItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1");
        Item item2 = new Item("test1", "testDescription2");
        Item item3 = new Item("test3", "testDescription3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findByName("test1")[0], is(item1));
        assertThat(tracker.findByName("test1").length, is(2));
    }

    @Test
    public void whenFindByIdThenTrackerReturnItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1");
        Item item2 = new Item("test2", "testDescription2");
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findById(item1.getId()), is(item1));
        assertThat(tracker.findById(item2.getId()).getName(), is("test2"));
    }
}
