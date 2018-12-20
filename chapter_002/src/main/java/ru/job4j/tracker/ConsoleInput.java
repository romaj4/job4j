package ru.job4j.tracker;

import java.util.Scanner;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ConsoleInput implements Input {

    private Scanner scanner  = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
