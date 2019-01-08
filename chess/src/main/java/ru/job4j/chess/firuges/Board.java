package ru.job4j.chess.firuges;

import ru.job4j.chess.firuges.exception.FigureNotFoundException;
import ru.job4j.chess.firuges.exception.ImpossibleMoveException;
import ru.job4j.chess.firuges.exception.OccupiedWayException;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Board {

    private final Figure[] figures = new Figure[32];

    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        int index = this.findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException("В заданной ячейке нет фигуры!");
        }
        Cell[] steps = this.figures[index].way(source, dest);
        if (steps.length == 0) {
            throw new ImpossibleMoveException("Фигура не может так двигаться");
        }
        for (int i = 0; i < steps.length; i++) {
            if (this.findBy(steps[i]) != -1) {
                throw new OccupiedWayException("Путь занят!");
            }
        }
        this.figures[index] = this.figures[index].copy(dest);
        return true;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index < this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
