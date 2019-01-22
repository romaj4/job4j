package ru.job4j.students;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class StudentsList {

    /**
     * Метод возвращает спиисок студентов, у которых бал выше bound.
     *
     * @param students List of student.
     * @param bound    bound.
     * @return A list of students.
     */
    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().flatMap(Stream::ofNullable).sorted()
                .takeWhile(student -> student.getScore() > bound).collect(Collectors.toList());
    }
}
