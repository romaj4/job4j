package ru.job4j.mail;

import org.junit.After;
import org.junit.Before;
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
public class EmailNotificationTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void whenSendEmailToUserThenResult() {
        EmailNotification en = new EmailNotification();
        en.emailTo(new User("Ivanov", "ivanov@mail.ru"));
        en.close();
        String expected = "Notification Ivanov to email ivanov@mail.ru";
        assertThat(expected, is(outContent.toString().replaceAll("(\\r|\\n)", "")));
    }
}