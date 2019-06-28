package ru.job4j.pingpong;

import javafx.scene.shape.Rectangle;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class RectangleMove implements Runnable {

    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        int vectorX = 1;
        while (!Thread.currentThread().isInterrupted()) {
            this.rect.setX(this.rect.getX() + vectorX);
            if (this.rect.getX() == PingPong.LIMIT_X - PingPong.RECT_WIDTH || this.rect.getX() == 0) {
                vectorX *= -1;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}