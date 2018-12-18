package ru.job4j.profession;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Profession {

    private String name;

    public String profession;

    public Profession(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getProfession() {
        return profession;
    }
}
