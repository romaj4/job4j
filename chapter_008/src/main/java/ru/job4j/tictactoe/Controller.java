package ru.job4j.tictactoe;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Controller {

    /**
     * Check if the field is filled.
     *
     * @param field field.
     * @return result.
     */
    public boolean isFullField(Field field) {
        boolean rst = true;
        for (int i = 0; i < field.getFieldSize() && rst; i++) {
            for (int j = 0; j < field.getFieldSize(); j++) {
                if (field.getFigure(i, j) == null) {
                    rst = false;
                    break;
                }
            }
        }
        return rst;
    }

    /**
     * Check if there is a winner.
     *
     * @param field  field.
     * @param figure figure.
     * @return result.
     */
    public boolean isWinner(Field field, Figure figure) {
        boolean rst = false;
        for (int i = 0; i < field.getFieldSize() && !rst; i++) {
            for (int j = 0; j < field.getFieldSize() && !rst; j++) {
                if (field.getFigure(j, i) != figure) {
                    continue;
                }
                if (checkLine(i, j, 1, 0, field, figure)) {
                    rst = true;
                }
                if (checkLine(i, j, 0, 1, field, figure)) {
                    rst = true;
                }
                if (checkLine(i, j, 1, 1, field, figure)) {
                    rst = true;
                }
                if (checkLine(i, j, 1, -1, field, figure)) {
                    rst = true;
                }
            }
        }
        return rst;
    }

    /**
     * Check the winning line from the point.
     *
     * @param startX starting point X.
     * @param startY starting point Y.
     * @param dX     x change.
     * @param dY     y change.
     * @param field  field.
     * @param figure figure.
     * @return result.
     */
    private boolean checkLine(int startX, int startY, int dX, int dY, Field field, Figure figure) {
        int lineToWin = field.getLineToWin();
        int fieldSize = field.getFieldSize();
        boolean rst = true;
        if (startX + lineToWin * dX > fieldSize || startY + lineToWin * dY > fieldSize || startY + lineToWin * dY < -1) {
            rst = false;
        }
        for (int i = 0; i < lineToWin && rst; i++) {
            if (field.getFigure(startY + i * dY, startX + i * dX) != figure) {
                rst = false;
            }
        }
        return rst;
    }
}
