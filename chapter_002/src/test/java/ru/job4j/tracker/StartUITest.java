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

    public String showMenu() {
        StringBuilder st = new StringBuilder();
        String ln = System.lineSeparator();
        st.append("Меню" + ln)
                .append("0. Add new Item" + ln)
                .append("1. Show all items" + ln)
                .append("2. Edit item" + ln)
                .append("3. Delete item" + ln)
                .append("4. Find item by Id" + ln)
                .append("5. Find items by name" + ln)
                .append("6. Exit Program" + ln);
        return st.toString();
    }

    @Test
    public void whenShowAllItem() {
        this.loadOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test1", "desc1"));
        Item item2 = tracker.add(new Item("test2", "desc2"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(this.showMenu() + this.ln)
                                .append("Name: test1, description: desc1, id: " + item1.getId() + this.ln)
                                .append("Name: test2, description: desc2, id: " + item2.getId() + this.ln)
                                .append(this.showMenu() + this.ln)
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
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(this.showMenu() + this.ln)
                                .append("Name: test2, description: desc2, id: " + item2.getId() + this.ln)
                                .append(this.showMenu() + this.ln)
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
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(this.showMenu() + this.ln)
                                .append("Name: test1, description: desc1, id: " + item1.getId() + this.ln)
                                .append(this.showMenu() + this.ln)
                                .toString()));
        this.backOutput();
    }

    @Test(expected = MenuOutException.class)
    public void whenMenuOutException() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"28"});
        new StartUI(input, tracker).init();
    }

    @Test(expected = NumberFormatException.class)
    public void whenNumberFormatException() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"java"});
        new StartUI(input, tracker).init();
    }
}