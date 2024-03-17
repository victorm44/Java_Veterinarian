package app.service;


import app.dto.PetDTO;
import app.models.Pet;
import app.validators.PetValidator;
import app.dao.PetDAO;
import java.util.UUID;

public class PetService {
    private static int petIdCounter = 1;
    public static void registerPet(PetDTO petDTO) {
        if (PetValidator.validatePet(petDTO)) {

            Pet pet = new Pet();
            pet.setId(Integer.toString(petIdCounter));
            petIdCounter++;
            pet.setName(petDTO.getName());
            pet.setOwnerID(petDTO.getOwnerID());
            pet.setAge(petDTO.getAge());
            pet.setSpecies(petDTO.getSpecies());
            pet.setBreed(petDTO.getBreed());
            pet.setCharacteristics(petDTO.getCharacteristics());
            pet.setWeight(petDTO.getWeight());
            PetDAO.addPet(pet);
            System.out.println("Pet registered successfully.");
        } else {
            System.out.println("Error validating pet data.");
        }
    }
}
