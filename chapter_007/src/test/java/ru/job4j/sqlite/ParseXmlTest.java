package ru.job4j.sqlite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ParseXmlTest {

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenStartAppThenSum() {
        XmlUsage xmlUsage = new XmlUsage(new File("sqlite/xmlentry.xml"));
        xmlUsage.save(new StoreSQL(18).load());
        new ParseXml(new ConvertXSQT(new File("sqlite/xmlconverted.xml"),
                new File("sqlite/scheme.xml"), xmlUsage));
        assertThat(this.out.toString(), is("171"));
    }
}