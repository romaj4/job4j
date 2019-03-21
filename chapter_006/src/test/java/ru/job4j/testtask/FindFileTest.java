package ru.job4j.testtask;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FindFileTest {

    @Test
    public void whenFindFilesByMaskThenResult() throws IOException {
        String[] args = {"-d", "src", "-n", "*.java",
                "-o", "src/main/resources/log.txt", "-m"};
        FindFile.main(args);
        List<String> lines = Files.readAllLines(Paths.get(args[5]));
        assertThat(lines.size(), is(18));
    }

    @Test
    public void whenFindFilesByFullNameThenResult() throws IOException {
        String[] args = {"-d", "src", "-n", "FindFileTest.java",
                "-o", "src/main/resources/log.txt", "-f"};
        FindFile.main(args);
        List<String> lines = Files.readAllLines(Paths.get(args[5]));
        assertThat(lines.size(), is(1));
    }
}