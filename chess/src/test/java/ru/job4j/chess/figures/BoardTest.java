package ru.job4j.chess.figures;

import org.junit.Test;
import ru.job4j.chess.firuges.Board;
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
public class BoardTest {

    /**
     * Черный слон ходит по диагонали на право вверх.
     */
    @Test
    public void whenBlackBishopMoveRightUp() {
        Board board = new Board();
        BishopBlack bishopBlack = new BishopBlack(Cell.B1);
        board.add(bishopBlack);
        boolean result = board.move(Cell.B1, Cell.F5);
        assertThat(result, is(true));
    }

    /**
     * Черный слон ходит по диагонали на право вверх с препятствием.
     */
    @Test(expected = OccupiedWayException.class)
    public void whenBlackBishopMoveRightUpWithOccupiedWay() {
        Board board = new Board();
        BishopBlack bishopBlack = new BishopBlack(Cell.B1);
        PawnBlack pawnBlack = new PawnBlack(Cell.C2);
        board.add(bishopBlack);
        board.add(pawnBlack);
        board.move(Cell.B1, Cell.F5);
    }

    /**
     * Черный слон ходит по по неправильной траектории.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenBlackBishopMoveRightUpWithImpossibleMove() {
        Board board = new Board();
        BishopBlack bishopBlack = new BishopBlack(Cell.B1);
        board.add(bishopBlack);
        board.move(Cell.B1, Cell.F8);
    }

    /**
     * Пустая ячейка.
     */
    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFound() {
        Board board = new Board();
        BishopBlack bishopBlack = new BishopBlack(Cell.B1);
        board.add(bishopBlack);
        board.move(Cell.B2, Cell.F8);
    }

    /**
     * Черная ладья идет назад.
     */
    @Test
    public void whenBlackRookMoveDown() {
        Board board = new Board();
        RookBlack rookBlack = new RookBlack(Cell.D4);
        board.add(rookBlack);
        boolean rst = board.move(Cell.D4, Cell.F4);
        assertThat(rst, is(true));
    }

    /**
     * Черный король идет назад по диагонали.
     */
    @Test
    public void whenBlackKingMoveLeftDown() {
        Board board = new Board();
        KingBlack kingBlack = new KingBlack(Cell.G2);
        board.add(kingBlack);
        boolean result = board.move(Cell.G2, Cell.H1);
        assertThat(result, is(true));
    }

    /**
     * Черная королева идет вперед на несколько клеток.
     */
    @Test
    public void whenBlackQeenMoveUp() {
        Board board = new Board();
        QeenBlack qeenBlack = new QeenBlack(Cell.D4);
        board.add(qeenBlack);
        boolean rst = board.move(Cell.D4, Cell.B4);
        assertThat(rst, is(true));
    }

    /**
     * Конь делает ход буков Г направо вверх.
     */
    @Test
    public void whenBlackKnightMoveUpRight() {
        Board board = new Board();
        KnightBlack knightBlack = new KnightBlack(Cell.D4);
        board.add(knightBlack);
        boolean rst = board.move(Cell.D4, Cell.B5);
        assertThat(rst, is(true));
    }
}
