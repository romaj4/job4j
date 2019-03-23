package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSQLTest {

    private TrackerSQL tracker;

    private Item testItem;

    @Before
    public void setUp() {
        this.tracker = new TrackerSQL();
        this.testItem = new Item("testName", "testDesc");
        this.tracker.add(testItem);
    }

    @After
    public void clear() {
        this.tracker.dropTable();
    }

    @Test
    public void whenAddItemThenIncrSize() {
        this.tracker.add(new Item("name1", "desc1"));
        assertThat(this.tracker.findAll().size(), is(2));
    }

    @Test
    public void whenReplaceItem() {
        Item item = new Item("name1", "desc1");
        this.tracker.replace("1", item);
        assertThat(this.tracker.findAll().get(0).getName(), is("name1"));
    }

    @Test
    public void whenDeleteItemThenDecrSize() {
        this.tracker.delete("1");
        assertThat(this.tracker.findAll().size(), is(0));
    }

    @Test
    public void whenFindByNameThenResult() {
        this.tracker.add(new Item("name1", "desc1"));
        this.tracker.add(new Item("name1", "desc2"));
        assertThat(this.tracker.findByName("name1").size(), is(2));
    }

    @Test
    public void whenFindByIdThenResult() {
        this.tracker.add(new Item("name1", "desc1"));
        assertThat(this.tracker.findById("2").getName(), is("name1"));
    }
}