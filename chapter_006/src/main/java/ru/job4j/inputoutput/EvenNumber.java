package ru.job4j.inputoutput;

import java.io.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class EvenNumber {

    boolean isNumber(InputStream in) {
        boolean rst = false;
        try (in) {
            int number;
            while ((number = in.read()) != -1) {
                if (number % 2 == 0) {
                    rst = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rst;
    }
}
