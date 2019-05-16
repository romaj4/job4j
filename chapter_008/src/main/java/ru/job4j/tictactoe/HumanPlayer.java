package ru.job4j.tictactoe;

import java.util.Scanner;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class HumanPlayer extends Player {

    private final Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String name, Figure figure) {
        super(name, figure);
    }

    @Override
    public void generateMove(Field field) {
        int x, y;
        do {
            System.out.println("Введите координаты хода X: ");
            x = scanner.nextInt() - 1;
            System.out.println("Введите координаты хода Y: ");
            y = scanner.nextInt() - 1;
            scanner.nextLine();
        } while (!field.checkCell(x, y));
        System.out.printf("%s сделал ход Х = %d, Y = %d \n", this.getName(), x + 1, y + 1);
        field.setFigure(x, y, this.getFigure());
    }
}
