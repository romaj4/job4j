package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class StartUITest {

    private final PrintStream stdout = System.out;

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private final String ln = System.lineSeparator();

    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteItemThenTrackerHasLessValues() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test1", "desc1"));
        Item item2 = tracker.add(new Item("test2", "desc2"));
        Input input = new StubInput(new String[]{"3", item1.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(1));
        assertThat(tracker.findAll()[0].getName(), is("test2"));
    }

    @Test
    public void whenShowAllItem() {
        this.loadOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test1", "desc1"));
        Item item2 = tracker.add(new Item("test2", "desc2"));
        Input input = new StubInput(new String[]{"1", "6"});
        StartUI st = new StartUI(input, tracker);
        st.init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(st.showMenu() + this.ln)
                                .append("Name: test1, description: desc1, id: " + item1.getId() + this.ln)
                                .append("Name: test2, description: desc2, id: " + item2.getId() + this.ln)
                                .append(st.showMenu() + this.ln)
                                .toString()));
        this.backOutput();
    }

    @Test
    public void whenFindByID() {
        this.loadOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test1", "desc1"));
        Item item2 = tracker.add(new Item("test2", "desc2"));
        Input input = new StubInput(new String[]{"4", item2.getId(), "6"});
        StartUI st = new StartUI(input, tracker);
        st.init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(st.showMenu() + this.ln)
                                .append("Name: test2, description: desc2, id: " + item2.getId() + this.ln)
                                .append(st.showMenu() + this.ln)
                                .toString()));
        this.backOutput();
    }

    @Test
    public void whenFindByName() {
        this.loadOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test1", "desc1"));
        Item item2 = tracker.add(new Item("test2", "desc2"));
        Input input = new StubInput(new String[]{"5", item1.getName(), "6"});
        StartUI st = new StartUI(input, tracker);
        st.init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(st.showMenu() + this.ln)
                                .append("Name: test1, description: desc1, id: " + item1.getId() + this.ln)
                                .append(st.showMenu() + this.ln)
                                .toString()));
        this.backOutput();
    }
}