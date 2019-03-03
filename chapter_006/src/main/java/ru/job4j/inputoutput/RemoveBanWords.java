package ru.job4j.inputoutput;

import java.io.*;
import java.util.Arrays;
import java.util.List;

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
            String line;
            while ((line = reader.readLine()) != null) {
                String[] readLine = line.split(" ");
                StringBuilder correctLine = new StringBuilder();
                for (String s : readLine) {
                    if (!list.contains(s)) {
                        correctLine.append(s).append(" ");
                    }
                }
                correctLine.append(System.lineSeparator());
                writer.write(String.valueOf(correctLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
