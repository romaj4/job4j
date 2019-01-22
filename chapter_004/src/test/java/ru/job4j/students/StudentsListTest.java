package ru.job4j.students;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class StudentsListTest {

    @Test
    public void whenAdd4Students() {
        StudentsList studentsList = new StudentsList();
        Student student1 = new Student("Ivan", 9);
        Student student2 = new Student("Petr", 6);
        Student student3 = new Student("Roman", 4);
        Student student4 = new Student("Nick", 8);
        List<Student> list = new ArrayList<>(Arrays.asList(student1, student2, student3, student4));
        List<Student> result = studentsList.levelOf(list, 6);
        assertThat(result, is(new ArrayList(Arrays.asList(student1, student4))));
    }

    @Test
    public void whenAdd4StudentsAnd4Null() {
        StudentsList studentsList = new StudentsList();
        Student student1 = new Student("Ivan", 3);
        Student student2 = new Student("Petr", 6);
        Student student3 = new Student("Roman", 7);
        Student student4 = new Student("Nick", 1);
        List<Student> list = new ArrayList<>(Arrays.asList(student1, null, student2, null, null, student3, student4, null));
        List<Student> result = studentsList.levelOf(list, 5);
        assertThat(result, is(new ArrayList(Arrays.asList(student3, student2))));
    }
}