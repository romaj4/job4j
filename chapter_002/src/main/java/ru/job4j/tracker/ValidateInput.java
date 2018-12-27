package ru.job4j.tracker;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ValidateInput extends ConsoleInput {

    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Ваше значение выходит за границы допустимых.");
            } catch (NumberFormatException nfe) {
                System.out.println("Необходимо использовать числовое значение");
            }
        } while (invalid);
        return value;
    }
}
