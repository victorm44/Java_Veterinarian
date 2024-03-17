package app;

import java.util.Scanner;
import app.dto.PersonDTO;
import app.dto.PetDTO;
import app.dto.MedicalRecordDTO;
import app.service.PersonService;
import app.service.PetService;
import app.service.MedicalRecordService;

public class App {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to the Veterinary Management System!");

		boolean exit = false;
		while (!exit) {
			displayMainMenu();
			int choice = scanner.nextInt();
			scanner.nextLine(); //Consuming the newline character

			switch (choice) {
				case 1:
					registerPerson();
					break;
				case 2:
					registerPet();
					break;
				case 3:
					registerMedicalRecord();
					break;
				case 4:
					// add case
					break;
				case 0:
					exit = true;
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}

		System.out.println("Thank you for using the Veterinary Management System. Goodbye!");
	}

	private static void displayMainMenu() {
		System.out.println("\nMain Menu:");
		System.out.println("1. Register a Person");
		System.out.println("2. Register a Pet");
		System.out.println("3. Register a Medical Record");
		System.out.println("4. Other Functionalities (to be implemented)");
		System.out.println("0. Exit");
		System.out.print("Enter your choice: ");
	}

	private static void registerMedicalRecord() {
		System.out.println("\nRegister a Medical Record:");

		System.out.print("Enter pet ID: ");
		String petId = scanner.nextLine();
		System.out.print("Enter date (YYYY-MM-DD): ");
		String date = scanner.nextLine();
		System.out.print("Enter veterinarian ID: ");
		String veterinarianId = scanner.nextLine();
		System.out.print("Enter reason for visit: ");
		String reasonForVisit = scanner.nextLine();
		System.out.print("Enter symptoms: ");
		String symptoms = scanner.nextLine();
		System.out.print("Enter diagnosis: ");
		String diagnosis = scanner.nextLine();
		System.out.print("Enter procedure: ");
		String procedure = scanner.nextLine();
		System.out.print("Enter medication: ");
		String medication = scanner.nextLine();
		System.out.print("Enter medication dose: ");
		String medicationDose = scanner.nextLine();
		System.out.print("Enter vaccination history: ");
		String vaccinationHistory = scanner.nextLine();
		System.out.print("Enter allergy medications: ");
		String allergyMedications = scanner.nextLine();
		System.out.print("Enter procedure details: ");
		String procedureDetails = scanner.nextLine();
		System.out.print("Enter order cancellation: ");
		String orderCancellation = scanner.nextLine();

		MedicalRecordDTO medicalRecordDTO = new MedicalRecordDTO(petId, date, veterinarianId,
				reasonForVisit, symptoms, diagnosis, procedure, medication, medicationDose,
				vaccinationHistory, allergyMedications, procedureDetails, orderCancellation);

		MedicalRecordService.registerMedicalRecord(medicalRecordDTO);
	}



	private static void registerPerson() {
		System.out.println("\nRegister a Person:");
		System.out.print("Enter ID number: ");
		String idNumber = scanner.nextLine();
		System.out.print("Enter name: ");
		String name = scanner.nextLine();
		System.out.print("Enter age: ");
		int age = scanner.nextInt();
		scanner.nextLine();
		String role;
		do {
			System.out.print("Enter role (administrator, veterinarian, owner, seller): ");
			role = scanner.nextLine().toLowerCase();
			if (!role.equals("administrator") && !role.equals("veterinarian") && !role.equals("owner") && !role.equals("seller")) {
				System.out.println("Invalid role. Please enter a valid role.");
			}
		} while (!role.equals("administrator") && !role.equals("veterinarian") && !role.equals("owner") && !role.equals("seller"));

		System.out.print("Enter username: ");
		String username = scanner.nextLine();
		System.out.print("Enter password: ");
		String password = scanner.nextLine();

		PersonDTO personDTO = new PersonDTO(idNumber, name, age, role);

		PersonService.registerPerson(personDTO, idNumber, name, age, role, username, password);
	}


	private static void registerPet() {
		System.out.println("\nRegister a Pet:");
		System.out.print("Enter pet name: ");
		String name = scanner.nextLine();
		System.out.print("Enter owner's ID number: ");
		String ownerID = scanner.nextLine();
		System.out.print("Enter age: ");
		int age = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter species: ");
		String species = scanner.nextLine();
		System.out.print("Enter breed: ");
		String breed = scanner.nextLine();
		System.out.print("Enter characteristics: ");
		String characteristics = scanner.nextLine();
		System.out.print("Enter weight: ");
		double weight = scanner.nextDouble();
		scanner.nextLine();

		PetDTO petDTO = new PetDTO(name, ownerID, age, species, breed, characteristics, weight);

		PetService.registerPet(petDTO);
	}
}
