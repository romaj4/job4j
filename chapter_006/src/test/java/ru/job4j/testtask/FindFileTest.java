package ru.job4j.testtask;

import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FindFileTest {

    @Ignore
    @Test
    public void whenFindFilesByMaskThenResult() throws IOException {
        String[] args = {"-d", "C:/projects/job4j/chapter_006",
                "-n", "*.java", "-o", "target/log.txt", "-m"};
        FindFile.main(args);
        List<String> lines = Files.readAllLines(Paths.get(args[5]));
        assertThat(lines.size(), is(18));
    }

    @Ignore
    @Test
    public void whenFindFilesByFullNameThenResult() throws IOException {
        String[] args = {"-d", "C:/projects/job4j/chapter_006",
                "-n", "FindFileTest.java", "-o", "target/log.txt", "-f"};
        FindFile.main(args);
        List<String> lines = Files.readAllLines(Paths.get(args[5]));
        assertThat(lines.size(), is(1));
    }
}