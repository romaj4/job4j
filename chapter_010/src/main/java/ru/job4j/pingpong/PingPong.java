package ru.job4j.pingpong;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PingPong extends Application {

    private static final String JOB4J = "Пинг-понг www.job4j.ru";

    /**
     * The width of the window.
     */
    public static final int LIMIT_X = 300;

    /**
     * The height of the window.
     */
    public static final int LIMIT_Y = 300;

    /**
     * The width of the figure.
     */
    public static final int RECT_WIDTH = 10;

    @Override
    public void start(Stage stage) throws Exception {
        Group group = new Group();
        Rectangle rect = new Rectangle(50, 100, RECT_WIDTH, 10);
        group.getChildren().add(rect);
        Thread run = new Thread(new RectangleMove(rect));
        run.start();
        stage.setScene(new Scene(group, LIMIT_X, LIMIT_Y));
        stage.setTitle(JOB4J);
        stage.setResizable(false);
        stage.show();
        stage.setOnCloseRequest(windowEvent -> run.interrupt());
    }
}