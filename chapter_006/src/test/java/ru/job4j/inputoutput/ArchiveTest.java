package ru.job4j.inputoutput;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ArchiveTest {

    @Test
    public void whenZipSomeDir() throws IOException {
        String[] arg = {"-d", "src", "-e", ".txt", "-o", "target/project.zip"};
        Archive.main(arg);
        ZipInputStream zipIn = new ZipInputStream(
                new FileInputStream(new File(arg[5])));
        ZipEntry zipEntry;
        while ((zipEntry = zipIn.getNextEntry()) != null) {
            Assert.assertNotEquals(zipEntry.getName(), "src\\main\\resources\\log.txt");
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenInvalidArguments() {
        String[] arg = {"-d", "src", "-k", ".xml", "-o", "target/project.zip"};
        Archive.main(arg);
    }
}