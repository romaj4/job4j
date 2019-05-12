package ru.job4j.tictactoe;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ConsoleView {

    /**
     * Show the field in the console.
     *
     * @param field field.
     */
    public void showField(Field field) {
        for (int i = 0; i <= field.getFieldSize(); i++) {
            System.out.printf("%2d ", i);
        }
        System.out.println();
        for (int i = 0; i < field.getFieldSize(); i++) {
            System.out.printf("%2d ", i + 1);
            for (int j = 0; j < field.getFieldSize(); j++) {
                Figure currentFigure = field.getFigure(j, i);
                System.out.printf(currentFigure == null ? " - " : "%2s ", currentFigure);
            }
            System.out.println();
        }
        System.out.println();
    }
}
