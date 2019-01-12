package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.exception.ImpossibleMoveException;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class QeenBlack implements Figure {
    private final Cell position;

    public QeenBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if ((Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y))) {
            steps = new BishopBlack(source).way(source, dest);
        }
        if (source.x == dest.x && source.y != dest.y || source.x != dest.x && source.y == dest.y) {
            steps = new RookBlack(source).way(source, dest);
        }
        if (steps.length == 0) {
            throw new ImpossibleMoveException("Фигура не может так двигаться");
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QeenBlack(dest);
    }
}
