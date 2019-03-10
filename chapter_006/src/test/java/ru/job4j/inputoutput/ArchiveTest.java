package ru.job4j.inputoutput;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
    public void test() {
        String[] arg = {"-d", "C:/projects/job4j/chapter_006", "-e", ".xml", "-o", "C:/projects/project.zip"};
        Archive.main(arg);
        try (ZipInputStream zipIn = new ZipInputStream(
                new FileInputStream(new File("C:/projects/project.zip")))) {
            ZipEntry zipEntry;
            while ((zipEntry = zipIn.getNextEntry()) != null) {
                Assert.assertNotEquals(zipEntry.getName(), "pom.xml");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}