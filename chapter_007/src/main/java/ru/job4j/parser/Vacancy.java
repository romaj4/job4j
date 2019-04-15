package ru.job4j.parser;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Vacancy {

    private final String name;

    private final String description;

    private final String link;

    private final long date;

    public Vacancy(String name, String description, String link, long date) {
        this.name = name;
        this.description = description;
        this.link = link;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }

    public long getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vacancy vacancy = (Vacancy) o;
        return name.equals(vacancy.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
