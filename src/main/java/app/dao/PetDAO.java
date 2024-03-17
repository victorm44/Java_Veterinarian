package app.dao;
import app.models.Pet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import app.config.MYSQLConnection;

public class PetDAO {
    private static final String INSERT_QUERY = "INSERT INTO pets (name, owner_id, age, species, breed, characteristics, weight) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM pets";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM pets WHERE id = ?";
    private static final String UPDATE_QUERY = "UPDATE pets SET name = ?, owner_id = ?, age = ?, species = ?, breed = ?, characteristics = ?, weight = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM pets WHERE id = ?";

    public static void addPet(Pet pet) {
        try (Connection connection = MYSQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, pet.getName());
            statement.setString(2, pet.getOwnerID());
            statement.setInt(3, pet.getAge());
            statement.setString(4, pet.getSpecies());
            statement.setString(5, pet.getBreed());
            statement.setString(6, pet.getCharacteristics());
            statement.setDouble(7, pet.getWeight());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Pet> getAllPets() {
        List<Pet> pets = new ArrayList<>();
        try (Connection connection = MYSQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Pet pet = new Pet();
                pet.setId(resultSet.getString("id"));
                pet.setName(resultSet.getString("name"));
                pet.setOwnerID(resultSet.getString("owner_id"));
                pet.setAge(resultSet.getInt("age"));
                pet.setSpecies(resultSet.getString("species"));
                pet.setBreed(resultSet.getString("breed"));
                pet.setCharacteristics(resultSet.getString("characteristics"));
                pet.setWeight(resultSet.getDouble("weight"));
                pets.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }

    public static Pet getPetById(String id) {
        Pet pet = null;
        try (Connection connection = MYSQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                pet = new Pet();
                pet.setId(resultSet.getString("id"));
                pet.setName(resultSet.getString("name"));
                pet.setOwnerID(resultSet.getString("owner_id"));
                pet.setAge(resultSet.getInt("age"));
                pet.setSpecies(resultSet.getString("species"));
                pet.setBreed(resultSet.getString("breed"));
                pet.setCharacteristics(resultSet.getString("characteristics"));
                pet.setWeight(resultSet.getDouble("weight"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pet;
    }

    public static void updatePet(Pet pet) {
        try (Connection connection = MYSQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, pet.getName());
            statement.setString(2, pet.getOwnerID());
            statement.setInt(3, pet.getAge());
            statement.setString(4, pet.getSpecies());
            statement.setString(5, pet.getBreed());
            statement.setString(6, pet.getCharacteristics());
            statement.setDouble(7, pet.getWeight());
            statement.setString(8, pet.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletePet(String id) {
        try (Connection connection = MYSQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
