package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorTest {
    ArrayList<Person> personList = new ArrayList<Person>();

    public static void main(String[] args) {
        new ComparatorTest().go();
    }

    public void go() {
        createPersonList();
        printList();

        Collections.sort(personList, new PersonCompareName());
        Collections.sort(personList, new PersonCompareFamily());
        printList();
    }

    public void createPersonList() {
        personList.add(new Person("Richard", "Strauss"));
        personList.add(new Person("Antonio", "Salieri"));
        personList.add(new Person("Niccolo", "Paganini"));
        personList.add(new Person("Frederic", "Chopin"));
        personList.add(new Person("Franz", "Schubert"));
        personList.add(new Person("Felix", "Mendelssohn"));
        personList.add(new Person("Robert", "Schumann"));
        personList.add(new Person("Johannes", "Brahms"));
        personList.add(new Person("Felix", "Schumann"));
        personList.add(new Person("Giuseppe", "Verdi"));
        personList.add(new Person("Franz", "Liszt"));
        personList.add(new Person("Adam", "Liszt"));
        personList.add(new Person("Franz", "Kafka"));
        personList.add(new Person("Antonio", "Vivaldi"));
        personList.add(new Person("August", "Schumann"));
    }

    class PersonCompareFamily implements Comparator<Person> {
        public int compare(Person one, Person two) {
            return one.getFamily().compareTo(two.getFamily());
        }
    }

    class PersonCompareName implements Comparator<Person> {
        public int compare(Person one, Person two) {
            return one.getName().compareTo(two.getName());
        }
    }

    public void printList() {
        for (Person p : personList) {
            System.out.println(p.name + " " + p.family);
        }
        System.out.println("-----");
    }

    static class Person {
        private String name;
        private String family;

        public Person(String name, String family) {
            this.name = name;
            this.family = family;
        }

        public String getName() {
            return name;
        }
        public String getFamily() {
            return family;
        }

        public void setName(String name) {
            this.name = name;
        }
        public void setFamily(String family) {
            this.family = family;
        }

    }


}
