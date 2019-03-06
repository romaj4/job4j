package ru.job4j.inputoutput;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class SearchTest {

    private final static String PATH = System.getProperty("java.io.tmpdir") + "/JavaSearchTest";
    private static File dir1 = new File(PATH + "/dir1");
    private static File dir2 = new File(PATH + "/dir2");

    @Before
    public void createFileSystem() throws IOException {
        new File(PATH).mkdir();
        dir1.mkdir();
        dir2.mkdir();
        new File(dir1, "11.txt").createNewFile();
        new File(dir1, "12.txt").createNewFile();
        new File(dir1, "13.doc").createNewFile();
        new File(dir2, "21.txt").createNewFile();
        new File(dir2, "22.java").createNewFile();
        new File(dir2, "23.doc").createNewFile();
        new File(dir2, "24.pdf").createNewFile();
        new File(dir2, "25.txt").createNewFile();
    }

    @Test
    public void whenSearchSomeExtensionThenListResult() {
        Search search = new Search();
        List<String> searchList = Arrays.asList(".doc", ".pdf");
        List<String> searchTxtList = Arrays.asList(".txt");
        assertThat(search.files(PATH, searchList).size(), is(3));
        assertThat(search.files(PATH, searchTxtList).size(), is(4));
    }

    @Test
    public void whenExtIsEmptyThenListIsEmpty() {
        Search search = new Search();
        assertThat(search.files(PATH, new ArrayList<>()).size(), is(0));
    }
}