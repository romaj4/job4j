package ru.job4j.sqlite;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ParseXmlTest {

    @Test
    public void whenStartAppThenSum() {
        XmlUsage xmlUsage = new XmlUsage(new File("sqlite/xmlentry.xml"));
        xmlUsage.save(new StoreSQL(19).load());
        int sum = new ParseXml(new ConvertXSQT(new File("sqlite/xmlconverted.xml"),
                new File("sqlite/scheme.xml"), xmlUsage)).getSum();
        assertThat(sum, is(190));
    }
}