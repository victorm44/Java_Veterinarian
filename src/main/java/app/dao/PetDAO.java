package app.dao;
import app.models.Pet;

public class PetDAO {
    private static Pet[] pets = new Pet[100];
    private static int numberOfPets = 0;

    public static void addPet(Pet pet) {
        pets[numberOfPets++] = pet;
    }
}
