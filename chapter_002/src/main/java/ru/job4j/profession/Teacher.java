package ru.job4j.profession;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Teacher extends Profession {

   public Teacher(String name) {
      super(name);
      this.profession = "Teacher";
   }

   public void teach(Student name){

   }
}
