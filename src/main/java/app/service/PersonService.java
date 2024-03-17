package app.service;

import app.dao.PersonDAO;
import app.dto.PersonDTO;
import app.models.Person;
import app.models.User;
import app.validators.PersonValidator;

public class PersonService {
    public static void registerPerson(PersonDTO personDTO, String idNumber, String name, int age, String role, String username, String password) {
        if (PersonValidator.validatePerson(personDTO)) {
            Person person = new Person();
            person.setIdNumber(idNumber);
            person.setName(name);
            person.setAge(age);
            person.setRole(role);

            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setRole(role);
            person.setUser(user);

            person.setUsername(username);
            person.setPassword(password);

            PersonDAO.addPerson(person);
            System.out.println("Persona registrada exitosamente.");
        } else {
            System.out.println("Error validando los datos de la persona.");
        }
    }
}