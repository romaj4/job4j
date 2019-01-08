package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class KnightBlack implements Figure {
    private final Cell position;

    public KnightBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (dest.x == source.x + 2 && dest.y == source.y + 1
                || dest.x == source.x + 2 && dest.y == source.y - 1
                || dest.x == source.x - 2 && dest.y == source.y + 1
                || dest.x == source.x - 2 && dest.y == source.y - 1
                || dest.x == source.x + 1 && dest.y == source.y + 2
                || dest.x == source.x + 1 && dest.y == source.y - 2
                || dest.x == source.x - 1 && dest.y == source.y + 2
                || dest.x == source.x - 1 && dest.y == source.y - 2) {
            steps = new Cell[]{dest};
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightBlack(dest);
    }
}
