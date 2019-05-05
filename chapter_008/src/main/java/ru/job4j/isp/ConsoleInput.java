package ru.job4j.isp;

import java.util.Scanner;
import java.util.Set;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    public String ask(String question, Set<String> keySet) {
        System.out.println(question);
        String key = scanner.nextLine();
        if (!keySet.contains(key)) {
            throw new IllegalArgumentException("Такой пункт меню отсутствует");
        }
        return key;
    }
}
