package ru.job4j.strategy;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Square implements Shape {

    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        String ln = System.lineSeparator();
        pic.append("++++");
        pic.append(ln);
        pic.append("+  +");
        pic.append(ln);
        pic.append("+  +");
        pic.append(ln);
        pic.append("++++");
        return pic.toString();
    }
}
