package ru.job4j.tictactoe;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ControllerTest {

    @Test
    public void whenWinHorizontalThenTrueResult() {
        Controller controller = new Controller();
        Field field = new Field();
        field.setFigure(0, 2, Figure.O);
        field.setFigure(1, 2, Figure.O);
        field.setFigure(2, 2, Figure.O);
        assertThat(controller.isWinner(field, Figure.O), is(true));
    }

    @Test
    public void whenWinVerticalThenTrueResult() {
        Controller controller = new Controller();
        Field field = new Field();
        field.setFigure(1, 0, Figure.O);
        field.setFigure(1, 1, Figure.O);
        field.setFigure(1, 2, Figure.O);
        assertThat(controller.isWinner(field, Figure.O), is(true));
    }

    @Test
    public void whenWinDiagonalThenTrueResult() {
        Controller controller = new Controller();
        Field field = new Field();
        field.setFigure(2, 0, Figure.X);
        field.setFigure(1, 1, Figure.X);
        field.setFigure(0, 2, Figure.X);
        assertThat(controller.isWinner(field, Figure.X), is(true));
    }

    @Test
    public void whenNoWinThenFalseResult() {
        Controller controller = new Controller();
        Field field = new Field();
        field.setFigure(1, 0, Figure.O);
        field.setFigure(1, 1, Figure.X);
        field.setFigure(1, 2, Figure.O);
        assertThat(controller.isWinner(field, Figure.O), is(false));
    }

    @Test
    public void whenExtendedFieldAndWinDiagonalThenResult() {
        Controller controller = new Controller();
        Field field = new Field(5, 4);
        field.setFigure(1, 1, Figure.O);
        field.setFigure(2, 2, Figure.O);
        field.setFigure(3, 3, Figure.O);
        field.setFigure(4, 4, Figure.O);
        assertThat(controller.isWinner(field, Figure.O), is(true));
    }

    @Test
    public void whenFullFieldThenTrueResult() {
        Controller controller = new Controller();
        Field field = new Field();
        for (int i = 0; i < field.getFieldSize(); i++) {
            for (int j = 0; j < field.getFieldSize(); j++) {
                field.setFigure(i, j, Figure.O);
            }
        }
        assertThat(controller.isFullField(field), is(true));
    }
}