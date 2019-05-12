package ru.job4j.tictactoe;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Field {

    private final int fieldSize;

    private final int lineToWin;

    private final Figure[][] field;

    public Field() {
        this.fieldSize = 3;
        this.lineToWin = fieldSize;
        this.field = new Figure[fieldSize][fieldSize];
    }

    public Field(int fieldSize, int lineToWin) {
        this.fieldSize = fieldSize;
        this.lineToWin = lineToWin;
        this.field = new Figure[fieldSize][fieldSize];
    }

    public int getFieldSize() {
        return this.fieldSize;
    }

    public int getLineToWin() {
        return this.lineToWin;
    }

    public Figure getFigure(int x, int y) {
        return this.field[x][y];
    }

    public void setFigure(int x, int y, Figure figure) {
        this.field[x][y] = figure;
    }

    public boolean checkCell(int x, int y) {
        return this.checkCoordinate(x) && this.checkCoordinate(y) && this.getFigure(x, y) == null;
    }

    private boolean checkCoordinate(int coordinate) {
        return coordinate >= 0 && coordinate < this.fieldSize;
    }
}
