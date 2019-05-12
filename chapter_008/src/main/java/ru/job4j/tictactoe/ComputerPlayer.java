package ru.job4j.tictactoe;

import java.util.Random;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ComputerPlayer extends Player {

    private final Random random = new Random();

    public ComputerPlayer(String name, Figure figure) {
        super(name, figure);
    }

    @Override
    public void generateMove(Field field) {
        int x, y;
        do {
            x = random.nextInt(field.getFieldSize());
            y = random.nextInt(field.getFieldSize());
        } while (!field.checkCell(x, y));
        System.out.printf("%s сделал ход Х = %d, Y = %d \n", this.getName(), x + 1, y + 1);
        field.setFigure(x, y, this.getFigure());
    }
}
