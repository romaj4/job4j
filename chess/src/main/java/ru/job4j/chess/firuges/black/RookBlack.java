package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.exception.ImpossibleMoveException;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class RookBlack implements Figure {
    private final Cell position;

    public RookBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (source.x == dest.x && source.y != dest.y || source.x != dest.x && source.y == dest.y) {
            int deltaX = dest.x - source.x > 0 ? 1 : -1;
            int deltaY = dest.y - source.y > 0 ? 1 : -1;
            if (source.x == dest.x) {
                steps = new Cell[Math.abs(dest.y - source.y)];
                for (int index = 0; index < steps.length; index++) {
                    steps[index] = Cell.values()[source.y + deltaY * (index + 1) + source.x * 8];
                }
            } else {
                steps = new Cell[Math.abs(dest.x - source.x)];
                for (int index = 0; index < steps.length; index++) {
                    steps[index] = Cell.values()[(source.x + deltaX * (index + 1)) * 8 + source.y];
                }
            }
        }
        if (steps.length == 0) {
            throw new ImpossibleMoveException("Фигура не может так двигаться");
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
    }
}
