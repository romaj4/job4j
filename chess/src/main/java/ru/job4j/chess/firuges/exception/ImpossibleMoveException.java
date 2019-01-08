package ru.job4j.chess.firuges.exception;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ImpossibleMoveException extends RuntimeException {

    public ImpossibleMoveException(String message) {
        super(message);
    }
}
