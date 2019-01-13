package ru.job4j.bank;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class User {

    private String name;

    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public int hashCode() {
        return this.passport.hashCode() + this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.passport.equals(((User) obj).passport) && this.name.equals((((User) obj).name));
    }
}
