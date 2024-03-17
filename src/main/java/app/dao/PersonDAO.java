package app.dao;
import app.models.Person;

public class PersonDAO {
    private static Person[] persons = new Person[100];
    private static int numberOfPersons = 0;

    public static void addPerson(Person person) {
        persons[numberOfPersons++] = person;
    }
}
