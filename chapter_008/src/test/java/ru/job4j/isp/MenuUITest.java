package ru.job4j.isp;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MenuUITest {

    @Test
    public void whenChooseMenuItemThenResult() {
        MenuUI menuUI = new MenuUI(new TestInput("1.1.1"));
        String rst = menuUI.init();
        assertThat(rst, is("1.1.1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenChooseNonExistMenuItemThenResult() {
        MenuUI menuUI = new MenuUI(new TestInput("4.2"));
        String rst = menuUI.init();
    }
}