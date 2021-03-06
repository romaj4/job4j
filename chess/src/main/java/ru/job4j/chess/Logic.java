package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.exception.*;

import java.util.stream.IntStream;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {

    private final Figure[] figures = new Figure[32];

    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        int index = this.findBy(source);
        if (this.findBy(source) == -1) {
            throw new FigureNotFoundException("В заданной ячейке нет фигуры!");
        }
        Cell[] steps = this.figures[index].way(source, dest);
        for (int i = 0; i < steps.length; i++) {
            if (this.findBy(steps[i]) != -1) {
                throw new OccupiedWayException("Путь занят!");
            }
        }
        this.figures[index] = this.figures[index].copy(dest);
        return true;
    }

    private int findBy(Cell cell) {
        return IntStream.range(0, this.figures.length).filter(index -> this.figures[index] != null
                && this.figures[index].position().equals(cell)).findFirst().orElse(-1);
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }
}