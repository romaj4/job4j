package ru.job4j.search;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary dictionary = new PhoneDictionary();
        dictionary.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        dictionary.add(new Person("Roman", "Korolchuk", "435460", "Piter"));
        List<Person> persons = dictionary.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindBySurname() {
        PhoneDictionary dictionary = new PhoneDictionary();
        dictionary.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        dictionary.add(new Person("Roman", "Korolchuk", "435460", "Piter"));
        List<Person> persons = dictionary.find("orolch");
        assertThat(persons.iterator().next().getName(), is("Roman"));
    }

    @Test
    public void whenFindByPhone() {
        PhoneDictionary dictionary = new PhoneDictionary();
        dictionary.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        dictionary.add(new Person("Roman", "Korolchuk", "435460", "Piter"));
        List<Person> persons = dictionary.find("5460");
        assertThat(persons.iterator().next().getSurname(), is("Korolchuk"));
    }

    @Test
    public void whenFindByAddress() {
        PhoneDictionary dictionary = new PhoneDictionary();
        dictionary.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        dictionary.add(new Person("Roman", "Korolchuk", "435460", "Piter"));
        List<Person> persons = dictionary.find("Piter");
        assertThat(persons.iterator().next().getSurname(), is("Korolchuk"));
    }
}