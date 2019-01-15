package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.exception.*;
import ru.job4j.chess.firuges.black.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class LogicTest {

    /**
     * Черный слон ходит по диагонали на право вверх.
     */
    @Test
    public void whenBlackBishopMoveRightUp() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.B1);
        logic.add(bishopBlack);
        boolean result = logic.move(Cell.B1, Cell.F5);
        assertThat(result, is(true));
    }

    /**
     * Черный слон ходит по диагонали на право вверх с препятствием.
     */
    @Test(expected = OccupiedWayException.class)
    public void whenBlackBishopMoveRightUpWithOccupiedWay() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.B1);
        PawnBlack pawnBlack = new PawnBlack(Cell.C2);
        logic.add(bishopBlack);
        logic.add(pawnBlack);
        logic.move(Cell.B1, Cell.F5);
    }


    /**
     * Черный слон ходит по по неправильной траектории.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenBlackBishopMoveRightUpWithImpossibleMove() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.B1);
        logic.add(bishopBlack);
        logic.move(Cell.B1, Cell.F8);
    }

    /**
     * Пустая ячейка.
     */
    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFound() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.B1);
        logic.add(bishopBlack);
        logic.move(Cell.B2, Cell.F8);
    }

    /**
     * Черная ладья идет назад.
     */
    @Test
    public void whenBlackRookMoveDown() {
        Logic logic = new Logic();
        RookBlack rookBlack = new RookBlack(Cell.D4);
        logic.add(rookBlack);
        boolean rst = logic.move(Cell.D4, Cell.F4);
        assertThat(rst, is(true));
    }

    /**
     * Черный король идет назад по диагонали.
     */
    @Test
    public void whenBlackKingMoveLeftDown() {
        Logic logic = new Logic();
        KingBlack kingBlack = new KingBlack(Cell.G2);
        logic.add(kingBlack);
        boolean result = logic.move(Cell.G2, Cell.H1);
        assertThat(result, is(true));
    }

    /**
     * Черная королева идет вперед на несколько клеток.
     */
    @Test
    public void whenBlackQeenMoveUp() {
        Logic logic = new Logic();
        QeenBlack qeenBlack = new QeenBlack(Cell.D4);
        logic.add(qeenBlack);
        boolean rst = logic.move(Cell.D4, Cell.B4);
        assertThat(rst, is(true));
    }

    /**
     * Конь делает ход буков Г направо вверх.
     */
    @Test
    public void whenBlackKnightMoveUpRight() {
        Logic logic = new Logic();
        KnightBlack knightBlack = new KnightBlack(Cell.D4);
        logic.add(knightBlack);
        boolean rst = logic.move(Cell.D4, Cell.B5);
        assertThat(rst, is(true));
    }
}
