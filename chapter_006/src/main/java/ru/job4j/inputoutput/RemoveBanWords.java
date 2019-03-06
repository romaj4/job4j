package ru.job4j.inputoutput;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class RemoveBanWords {

    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        List<String> list = Arrays.asList(abuse);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in));
             OutputStreamWriter writer = new OutputStreamWriter(out)) {
            writer.write(reader.lines()
                    .flatMap(str -> Stream.of(str.split(" ")))
                    .filter(str -> !list.contains(str))
                    .collect(Collectors.joining(" ")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
