package ru.job4j.tracker;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSQLTest {

    public Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void whenAddItemThenIncrSize() throws Exception {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name", "desc"));
            assertThat(tracker.findByName("name").size(), is(1));
        }
    }

    @Test
    public void whenReplaceItem() throws Exception {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name", "desc"));
            Item item = new Item("name1", "desc1");
            tracker.replace(tracker.findByName("name").get(0).getId(), item);
            assertThat(tracker.findAll().get(0).getName(), is("name1"));
        }
    }

    @Test
    public void whenDeleteItemThenDecrSize() throws Exception {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name", "desc"));
            tracker.delete(tracker.findByName("name").get(0).getId());
            assertThat(tracker.findAll().size(), is(0));
        }
    }

    @Test
    public void whenFindByNameThenResult() throws Exception {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name1", "desc1"));
            tracker.add(new Item("name1", "desc2"));
            assertThat(tracker.findByName("name1").size(), is(2));
        }
    }
}