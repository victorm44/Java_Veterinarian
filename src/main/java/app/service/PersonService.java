package app.service;

import app.dto.PersonDTO;
import app.models.User;

public class PersonService {
    private static final PersonDTO[] people = new PersonDTO[100];
    private static int numberOfPeople = 0;

    public static void registerPerson(PersonDTO personDTO, String idNumber, String name, int age, String role, String username, String password) {
        if (checkDuplicateIdNumber(idNumber)) {
            System.out.println("Error: La cédula ya está registrada.");
            return;
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);

        personDTO.setUser(user);

        people[numberOfPeople++] = personDTO;

        System.out.println("Persona registrada exitosamente.");
    }

    private static boolean checkDuplicateIdNumber(String idNumber) {
        for (int i = 0; i < numberOfPeople; i++) {
            if (people[i].getIdNumber().equals(idNumber)) {
                return true;
            }
        }
        return false;
    }
}
