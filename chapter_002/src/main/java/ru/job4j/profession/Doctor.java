package ru.job4j.profession;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Doctor extends Profession {

    public Doctor(String name) {
        super(name);
        this.profession = "Doctor";
    }

    public Diagnose heal(Patient patient) {
        return new Diagnose();
    }
}
